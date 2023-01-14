package com.example.triviamundial;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.triviamundial.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {
    FragmentTitleBinding mBinding;

    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance(String param1) {
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
        mBinding = FragmentTitleBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();


        mBinding.comenzarTriviaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBinding.nameTv.getText().toString().isEmpty()) {
                    addTriviaFragment(mBinding.nameTv.getText().toString());
                } else {
                    Toast.makeText(getContext(), "DEBE ESCRIBIR SU NOMBRE", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }


    private void addTriviaFragment(String Name) {
        TriviaFragment triviaFragment = TriviaFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, triviaFragment, TitleFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }




}