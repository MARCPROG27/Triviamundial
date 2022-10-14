package com.example.triviaejemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.triviaejemplo.databinding.ActivityMainBinding;
import com.example.triviaejemplo.databinding.FragmentTitleBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addTitleFragment();

    }


    private void addTitleFragment() {
        TitleFragment titleFragment = TitleFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(binding.contentFragment.getId(),
                titleFragment, TitleFragment.class.getSimpleName());
        fragmentTransaction.commit();

    }
}