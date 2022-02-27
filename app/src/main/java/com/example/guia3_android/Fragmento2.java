package com.example.guia3_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guia3_android_java.databinding.PrimerFragmentBinding;
import com.example.guia3_android_java.databinding.SegundoFragmentBinding;


public class Fragmento2 extends Fragment {
    private SegundoFragmentBinding binding;
    private TextView nombretxt, salariotxt, issstxt, afptxt, rentatxt, snetotxt;


    public Fragmento2() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("valores", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String nombre = result.getString("nombre");
                nombretxt.setText("Nombre empleado: " + nombre);
                String salario = result.getString("salario");
                salariotxt.setText("Salario: $" + salario);
                String isss = result.getString("isss");
                issstxt.setText("ISSS: $" + isss);
                String afp = result.getString("afp");
                afptxt.setText("AFP: $" + afp);
                String renta = result.getString("renta");
                rentatxt.setText("Renta: $" + renta);
                String sueldoneto = result.getString("sueldoneto");
                snetotxt.setText("Sueldo Neto: $" + sueldoneto);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SegundoFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombretxt = binding.nombretxt;
        salariotxt = binding.salariotxt;
        issstxt = binding.isssxtxt;
        afptxt = binding.afptxt;
        rentatxt = binding.rentatxt;
        snetotxt = binding.snetotxt;
    }
}