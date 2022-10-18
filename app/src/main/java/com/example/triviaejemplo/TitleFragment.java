package com.example.triviaejemplo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.triviaejemplo.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {


   FragmentTitleBinding mBinding;
    public TitleFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentTitleBinding.inflate(inflater, container,false);
        View view = mBinding.getRoot();
// esto tambien lo puedo hacer en el metodo onviewCREATE ese método se instancia cuando ya esta creado el objeto
        mBinding.comenzarTriviaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBinding.nameTv.getText().toString().isEmpty()) {
                    addLogoTriviaFragment(mBinding.nameTv.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Debes escribir tu nombre", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return  view;
    }

    // instanciamos y enviamos un parametro al otro fragmento

    private void addLogoTriviaFragment(String name) {
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, logoTriviaFragment, TitleFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }




}