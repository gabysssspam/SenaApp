package com.example.sena;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoParejasActivity extends AppCompatActivity {

    // Modelo de pareja
    static class PairItem {
        String key;
        String word;

        PairItem(String key, String word) {
            this.key = key;
            this.word = word;
        }
    }

    // Modelo interno para mezclar tarjetas
    private abstract static class Item {
        String key;

        Item(String key) {
            this.key = key;
        }

        static class Image extends Item {
            Image(String key) {
                super(key);
            }
        }

        static class Word extends Item {
            String word;

            Word(String key, String word) {
                super(key);
                this.word = word;
            }
        }
    }

    private final Handler handler = new Handler(Looper.getMainLooper());
    private GridLayout grid;

    private View firstView = null;
    private String firstKey = null;
    private boolean lock = false;
    private int matched = 0;

    // ✅ 5 parejas = 10 tarjetas
    private final List<PairItem> pairs = List.of(
            new PairItem("hola", "Hola"),
            new PairItem("bien", "Bien"),
            new PairItem("adios", "Adiós"),
            new PairItem("gracias", "Gracias"),
            new PairItem("perdon", "Perdón")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_parejas);

        grid = findViewById(R.id.gridPairs);

        Button btnReiniciar = findViewById(R.id.btnReiniciar);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        btnReiniciar.setOnClickListener(v -> iniciar());
        btnRegresar.setOnClickListener(v -> finish());


        iniciar();
    }

    private void iniciar() {
        matched = 0;
        lock = false;
        firstView = null;
        firstKey = null;

        List<Item> items = new ArrayList<>();

        // 5 imágenes + 5 palabras
        for (PairItem p : pairs) {
            items.add(new Item.Image(p.key));
            items.add(new Item.Word(p.key, p.word));
        }

        Collections.shuffle(items);

        grid.removeAllViews();
        grid.setColumnCount(2);

        for (Item item : items) {
            View view;
            if (item instanceof Item.Image) {
                view = buildImageCard(item.key);
            } else {
                Item.Word w = (Item.Word) item;
                view = buildWordCard(w.key, w.word);
            }

            view.setOnClickListener(v -> onTap(view, item.key));
            grid.addView(view);
        }
    }

    private View buildImageCard(String key) {
        ImageButton btn = new ImageButton(this);

        int resId = getResources().getIdentifier(key, "drawable", getPackageName());
        btn.setImageResource(resId != 0 ? resId : android.R.drawable.ic_menu_gallery);
        btn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btn.setAdjustViewBounds(true);

        btn.setBackgroundColor(0xFFFFFFFF);
        btn.setPadding(14, 14, 14, 14);

        GridLayout.LayoutParams p = new GridLayout.LayoutParams();
        p.width = 0;
        p.height = 420;
        p.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        p.setMargins(12, 12, 12, 12);
        btn.setLayoutParams(p);

        return btn;
    }

    private View buildWordCard(String key, String word) {
        Button btn = new Button(this);
        btn.setText(word);
        btn.setAllCaps(false);
        btn.setTextSize(16f);
        btn.setBackgroundColor(0xFFFFFFFF);
        btn.setTextColor(0xFF000000);

        GridLayout.LayoutParams p = new GridLayout.LayoutParams();
        p.width = 0;
        p.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        p.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        p.setMargins(12, 12, 12, 12);
        btn.setLayoutParams(p);

        return btn;
    }

    private void onTap(View view, String key) {
        if (lock) return;
        if (!view.isEnabled()) return;

        if (firstView == null) {
            firstView = view;
            firstKey = key;
            view.setAlpha(0.7f);
            return;
        }

        if (view == firstView) return;

        lock = true;
        boolean ok = firstKey != null && firstKey.equals(key);

        if (ok) {
            matched += 2;
            handler.postDelayed(() -> {
                firstView.setEnabled(false);
                view.setEnabled(false);

                firstView.setAlpha(0.35f);
                view.setAlpha(0.35f);

                firstView = null;
                firstKey = null;
                lock = false;

                if (matched == pairs.size() * 2) {
                    Toast.makeText(this,
                            "🎉 ¡Completaste el juego!",
                            Toast.LENGTH_LONG
                    ).show();
                    finish();
                }
            }, 300);
        } else {
            handler.postDelayed(() -> {
                firstView.setAlpha(1f);
                view.setAlpha(1f);
                firstView = null;
                firstKey = null;
                lock = false;

                Toast.makeText(this,
                        "❌ No es pareja, intenta otra vez.",
                        Toast.LENGTH_SHORT
                ).show();
            }, 450);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
