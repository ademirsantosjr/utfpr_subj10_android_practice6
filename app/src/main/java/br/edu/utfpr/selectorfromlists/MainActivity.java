package br.edu.utfpr.selectorfromlists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerManufacturers, spinnerModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerManufacturers = findViewById(R.id.spinnerManufacturers);
        spinnerModels = findViewById(R.id.spinnerModels);

        spinnerManufacturers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view,
                                       int position,
                                       long id) {

                String manufacturer = parent.getItemAtPosition(position).toString();

                if (manufacturer.equals(getString(R.string.ford))) {
                    populateModels(R.array.ford_models);
                }else
                    if (manufacturer.equals(getString(R.string.fiat))) {
                        populateModels(R.array.fiat_models);
                    }else
                        if(manufacturer.equals(getString(R.string.honda))) {
                            populateModels(R.array.honda_models);
                        }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void populateModels(int arrayId) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                arrayId,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerModels.setAdapter(adapter);
    }
}