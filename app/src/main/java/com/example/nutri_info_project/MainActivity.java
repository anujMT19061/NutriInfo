package com.example.nutri_info_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button=(Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getBaseContext(),Parameter_calc.class);
                startActivity(intent);
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.activity_level, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.goal_state, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


        final ImageButton imageButton2 = (ImageButton) findViewById(R.id.female_b);
        final ImageButton imageButton = (ImageButton) findViewById(R.id.male_b);
        imageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View button) {

                button.setSelected(!button.isSelected());
                if (button.isSelected())
                {
                    imageButton2.setSelected(false);
                   imageButton.setSelected(true);
                }
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {

                button.setSelected(!button.isSelected());
                if (button.isSelected())
                {
                    imageButton.setSelected(false);
                    imageButton2.setSelected(true);

                }
            }

        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        if(position==0)
        {
            onNothingSelected(parent);
        }
        else {
            String sSelected = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, sSelected, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this,"Nothing Selected",Toast.LENGTH_SHORT).show();
    }
}
