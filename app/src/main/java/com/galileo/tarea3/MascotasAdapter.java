package com.galileo.tarea3;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MascotasAdapter extends ArrayAdapter<Mascota> {
    private List<Mascota> lista;
    private Context context;
    private int layout;

    public MascotasAdapter(@Nullable Context context, @Nullable List<Mascota> objects) {
        super(context, R.layout.mascota_item_list_layout, objects);
        this.lista = objects;
        this.context = context;
        this.layout = R.layout.mascota_item_list_layout;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = ((LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE));
            v = li.inflate(layout, null);
        }
        if (lista.get(position) != null) {

            LinearLayout lyt;
            TextView txtName, txtDate, txtType;
            ImageView imageView;

            lyt = v.findViewById(R.id.lyFondo);
            txtName = v.findViewById(R.id.txtvName);
            txtDate = v.findViewById(R.id.txtvDate);
            txtType = v.findViewById(R.id.txtvTipo);
            imageView = v.findViewById(R.id.imagevView);

            String _Fecha = "";
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = new java.util.Date();
                Date date2 = df.parse(lista.get(position).getFechanacimiento()); // df.parse("00:00:00_2013.01.01");
                long diff = date1.getTime() - date2.getTime();
                _Fecha = String.valueOf( diff / 1000 / 60 / 60 / 24 / 365);
            } catch (ParseException e) {
                Log.e("TEST", "Exception", e);
            }


            txtName.setText(lista.get(position).getNombre());
            txtDate.setText(_Fecha + " Años");
            txtType.setText(lista.get(position).getTipo());

            switch (txtType.getText().toString()){
                case "Perro":
                    imageView.setImageResource(R.drawable.dog);
                    break;
                case "Gato":
                    imageView.setImageResource(R.drawable.cat);
                    break;
                case "Pajaro":
                    imageView.setImageResource(R.drawable.bird);
                    break;
            }



        }
        return v;

    }
}
