package com.example.sena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiccionarioAdapter extends RecyclerView.Adapter<DiccionarioAdapter.ViewHolder> {

    private Context context;
    private List<Senia> lista;

    public DiccionarioAdapter(Context context, List<Senia> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_diccionario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Senia senia = lista.get(position);
        holder.txtPalabra.setText(senia.getPalabra());

        holder.itemView.setOnClickListener(v -> {
            SeniaDialog dialog = new SeniaDialog(context, senia);
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPalabra;

        ViewHolder(View itemView) {
            super(itemView);
            txtPalabra = itemView.findViewById(R.id.txtPalabra);
        }
    }
}
