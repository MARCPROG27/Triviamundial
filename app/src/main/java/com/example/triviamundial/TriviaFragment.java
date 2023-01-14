package com.example.triviamundial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.triviamundial.databinding.FragmentLogoTriviaBinding;


public class TriviaFragment extends Fragment {


    // AGREGAR BINDING
    FragmentLogoTriviaBinding binding;

    private static final String ARG_PARAM1 = "param1";


    private String mParam1;
    ;

    public static final int OPT_01 = 0;
    public static final int OPT_02 = 1;
    public static final int OPT_03 = 2;
    public static final int OPT_04 = 3;

    // VARIABLE NUMERICA PARA CAPTAR SELECCION
    private int optionchoice;

    public TriviaFragment() {
        // Constructor Vacío
    }


    public static TriviaFragment newInstance(String param1) {
        TriviaFragment fragment = new TriviaFragment();
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


        binding.triviaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = binding.triviaRg.findViewById(checkedId);
                int index = binding.triviaRg.indexOfChild(radioButton);
                switch (index) {
                    case OPT_01:
                        optionchoice = OPT_01;
                        break;
                    case OPT_02:
                        optionchoice = OPT_02;
                        break;
                    case OPT_03:
                        optionchoice = OPT_03;
                        break;
                    case OPT_04:
                        optionchoice = OPT_04;
                        break;
                    default:
                        optionchoice = 5;
                        break;
                }

            }
        });


        binding.triviaSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionchoice == OPT_03) {
                    goToWin(mParam1);
                } else {

                    goToTryAgain(mParam1);
                }
            }
        });

        return view;

    }

    private void goToWin(String Name) {
        WinFragment winFragment = WinFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, winFragment,
                WinFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }


    private void goToTryAgain(String Name) {
        TryAgainFragment tryAgainFragment = TryAgainFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, tryAgainFragment,
                TryAgainFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }


}

