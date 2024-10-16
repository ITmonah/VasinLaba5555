package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private EditText fio,email;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        fio = binding.editTextText2;
        email = binding.editTextTextEmailAddress2;

        Button button = binding.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fio.setText("");
                email.setText("");
                Toast myToast = Toast.makeText(getActivity().getApplicationContext(),"Успешная отправка",Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}