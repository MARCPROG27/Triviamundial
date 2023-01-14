package com.example.triviamundial;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.triviamundial.databinding.FragmentTryAgainBinding;


public class TryAgainFragment extends Fragment {

    FragmentTryAgainBinding Mbinding;
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    public TryAgainFragment() {
        // Required empty public constructor
    }


    public static TryAgainFragment newInstance(String param1) {
        TryAgainFragment fragment = new TryAgainFragment();
        Bundle args = new Bundle();
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
        Mbinding = FragmentTryAgainBinding.inflate(inflater, container, false);
        View view = Mbinding.getRoot();

        String loserMessage = getString(R.string.loserMessage, mParam1);
        Mbinding.trayAgainTv.setText(loserMessage);


        Mbinding.tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

