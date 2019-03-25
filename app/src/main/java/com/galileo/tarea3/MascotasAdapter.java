package com.galileo.tarea3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

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

            txtName.setText(lista.get(position).getNombre());
            txtDate.setText(lista.get(position).getFechanacimiento());
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
