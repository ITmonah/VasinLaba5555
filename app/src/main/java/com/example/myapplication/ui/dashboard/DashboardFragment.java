package com.example.myapplication.ui.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
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

import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = binding.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] pers = {"1","2","3"};
                boolean[] pers_c = {false,false,false};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Выберите ответ")
                        .setPositiveButton("Ответить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast myToast;
                                if(pers_c[2] && !pers_c[0] && !pers_c[1]){
                                    myToast = Toast.makeText(getActivity().getApplicationContext(), "все верно", Toast.LENGTH_LONG);
                                }
                                else {
                                    myToast = Toast.makeText(getActivity().getApplicationContext(), "Неверно", Toast.LENGTH_LONG);
                                }
                                myToast.show();
                            }
                        })
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setMultiChoiceItems(pers, pers_c, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                pers_c[i]=b;
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
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