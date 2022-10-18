package com.example.triviaejemplo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.triviaejemplo.databinding.FragmentLogoTriviaBinding;


public class LogoTriviaFragment extends Fragment {


    // AGREGAR BINDING
    FragmentLogoTriviaBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    public static final int OPT_01 = 0;
    public static final int OPT_02 = 1;
    public static final int OPT_03 = 2;
    public static final int OPT_04 = 3;

    // VARIABLE NUMERICA PARA CAPTAR SELECCION
    private int choice;

    public LogoTriviaFragment() {
        // Required empty public constructor
    }


    public static LogoTriviaFragment newInstance(String param1, String param2) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        Bundle args = new Bundle();
        // recibe el nombre
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // busca eN EL R EL STRING QUE GUARDAMOS Y LE ASIGNA LO QUE RECIBIMOS
        String greeting = getString(R.string.greeting, mParam1);
        binding.triviaNameTv.setText(greeting);

// pertenece al contenedor de los radioButtons

       // se atuo completa reemplazando hasta el RadioGroup.OnCheckedChangeListener

        binding.triviaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = binding.triviaRg.findViewById(checkedId);
                int index = binding.triviaRg.indexOfChild(radioButton);
                switch (index) {
                    case OPT_01:
                        choice = OPT_01;
                        break;
                    case OPT_02:
                        choice = OPT_02;
                        break;
                    case OPT_03:
                        choice = OPT_03;
                        break;
                    case OPT_04:
                        choice = OPT_04;
                        break;
                    default:
                        choice = 5;
                        break;
                }

            }
        });


        binding.triviaSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == OPT_03) {
                    goToWinFragment(mParam1);
                } else {

                    goToTryAgainFragment(mParam1);
                }
            }
        });

        return view;

    }

    private  void goToWinFragment(String name) {
        WinFragment winFragment = WinFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, winFragment,
                WinFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }


    private void goToTryAgainFragment(String name) {
      TryAgainFragment tryAgainFragment = TryAgainFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, tryAgainFragment,
                TryAgainFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }




}

