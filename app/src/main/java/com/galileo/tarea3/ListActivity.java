package com.galileo.tarea3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = findViewById(R.id.list_mascota);
        lista.setAdapter(new MascotasAdapter(this, ((MascotaApp)getApplication()).getMascotas()));

    }
}
