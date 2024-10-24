package com.example.pizzeria;

import android.view.View;
import android.widget.CheckBox;

public class MiOnClickListenerCheckbox implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        CheckBox checkBox = (CheckBox) v;
        boolean isChecked = checkBox.isChecked();

        if (isChecked) {

        } else {
            checkBox.setText("Checkbox desmarcado!");
        }
    }
}
