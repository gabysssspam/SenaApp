package com.example.sena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

class Principal : Fragment(), OnItemClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listita: ListView
        var retornaditos = ArrayList<String?>()
        val actividaditas: Arreglo?

        listita = view.findViewById<ListView?>(R.id.principal)
        actividaditas = Arreglo()
        retornaditos = actividaditas.regresa()

        listita.setOnItemClickListener(this)
        val adaptatito = ArrayAdapter<String?>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            retornaditos
        )
        listita.setAdapter(adaptatito)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        if (position == 0) {
            findNavController(view).navigate<Any?>(R.id.inicioSesion)
        } else if (position == 1) {
            findNavController(view).navigate<Any?>(R.id.registro)
        }
    }
} //Gabrielle Góngora Méndez 5IM8