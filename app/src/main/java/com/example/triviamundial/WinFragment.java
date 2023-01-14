package com.example.triviamundial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.triviamundial.databinding.FragmentWinBinding;


public class WinFragment extends Fragment {
    FragmentWinBinding Mbinding;


    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    public WinFragment() {
        // Required empty public constructor
    }


    public static WinFragment newInstance(String param1) {
        WinFragment fragment = new WinFragment();
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

        Mbinding = FragmentWinBinding.inflate(inflater, container, false);
        View view = Mbinding.getRoot();
        String win_msg = getString(R.string.win_msg, mParam1);
        Mbinding.winTv.setText(win_msg);
        Mbinding.winRetryBtn.setTextSize(14);

        Mbinding.winRetryBtn.setText("FELICITACIONES.ACERTASTE LA TRIVIA");

        Mbinding.winRetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}