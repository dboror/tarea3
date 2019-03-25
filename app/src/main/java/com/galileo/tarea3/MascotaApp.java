package com.galileo.tarea3;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MascotaApp extends Application {
    private List<Mascota> listMascotas;

    @Override
    public void onCreate() {
        super.onCreate();
        listMascotas = new ArrayList<Mascota>();
    }

    public void insertaMascota(Mascota _Mascota){
        listMascotas.add(_Mascota);
    }

    public List<Mascota> getMascotas(){
        return listMascotas;
    }
}
