package com.example.guia3_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.guia3_android_java.databinding.PrimerFragmentBinding;


public class Fragmento1 extends Fragment {
    private PrimerFragmentBinding binding;
    private EditText Nombre, Horas;
    private Button Btn_Calcular;


    public Fragmento1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = PrimerFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Nombre = binding.nombre;
        Horas = binding.horas;
        Btn_Calcular = binding.button;

        Btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = Nombre.getText().toString();
                double pagohoras = 8.50;
                double salario = (Double.parseDouble(Horas.getText().toString()) * pagohoras);
                double isss = salario * 0.03;
                double afp = salario * 0.04;
                double renta = salario * 0.05;
                double descuentos = isss + afp + renta;
                double sueldoneto = salario - descuentos;

                Bundle bundle = new Bundle();

                bundle.putString("nombre", nombre);
                bundle.putString("salario", String.valueOf(salario));
                bundle.putString("isss", String.valueOf(isss));
                bundle.putString("afp", String.valueOf(afp));
                bundle.putString("renta", String.valueOf(renta));
                bundle.putString("sueldoneto", String.valueOf(sueldoneto));

                getParentFragmentManager().setFragmentResult("valores", bundle);


            }
        });

    }
}