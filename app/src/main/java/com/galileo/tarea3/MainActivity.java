package com.galileo.tarea3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNombre, txtDate;
    private RadioButton rbtnDog, rbtnCat, rbtnBird;
    private RadioGroup rbtnPet;
    private Button btnGrabar, btnConsultar;
    private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtName);
        txtDate = findViewById(R.id.txtDate);
        rbtnDog = findViewById(R.id.rbtnDog);
        rbtnCat = findViewById(R.id.rbtnCat);
        rbtnBird = findViewById(R.id.rbtnBird);
        btnGrabar = findViewById(R.id.btnGrabar);
        btnConsultar = findViewById(R.id.btnConsultar);
        rbtnPet = findViewById(R.id.rbtnPet);
        imageView = findViewById(R.id.imgPet);

        btnGrabar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);
        rbtnDog.setOnClickListener(this);
        rbtnCat.setOnClickListener(this);
        rbtnBird.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        Mascota _Mascota;
        Intent intent;
        switch (v.getId()) {
            case R.id.btnConsultar:
                Toast.makeText(this, "Click sobre consultar", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.btnGrabar:
                _Mascota = new Mascota();
                _Mascota.setNombre(txtNombre.getText().toString());
                _Mascota.setFechanacimiento(txtDate.getText().toString());
                _Mascota.setTipo(((RadioButton) findViewById(rbtnPet.getCheckedRadioButtonId())).getText().toString());
                ((MascotaApp)getApplication()).insertaMascota(_Mascota);
                txtDate.setText("");
                txtNombre.setText("");
                ((RadioButton) rbtnPet.getChildAt(1)).setChecked(true);
                Toast.makeText(this, "Click Sobre Grabar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbtnBird:
                imageView.setImageResource(R.drawable.bird);
                break;
            case R.id.rbtnCat:
                imageView.setImageResource(R.drawable.cat);
                break;
            case R.id.rbtnDog:
                imageView.setImageResource(R.drawable.dog);
                    break;
        }
    }


}
