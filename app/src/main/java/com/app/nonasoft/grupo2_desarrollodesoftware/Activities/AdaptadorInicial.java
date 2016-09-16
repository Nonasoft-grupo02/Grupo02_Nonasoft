package com.app.nonasoft.grupo2_desarrollodesoftware.Activities;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.app.nonasoft.grupo2_desarrollodesoftware.R;

/**
 * Created by Yoel on 10/09/2016.
 */
public class AdaptadorInicial extends BaseExpandableListAdapter{
    Context contexto;
    String[] padrea_inicial = {"Gestion de contactos", "Llamadas", "Galeria de Imagenes", "Mensajes de texto"};

    String[][] tutoriales_inicial = {
            {"Agregar contacto", "Eliminar contacto", "Buscar contacto"},
            {"Agregar tutoriales"},
            {"Agregar tutoriales"},
            {"Agregar tutoriales"}
    };

    public AdaptadorInicial(Context context){
        this.contexto = context;
    }

    @Override
    public int getGroupCount() {
        return padrea_inicial.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return tutoriales_inicial[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView tv = new TextView(contexto);
        tv.setText(this.padrea_inicial[groupPosition]);
        tv.setTextSize(20);
        tv.setBackgroundColor(Color.parseColor("#E6E6E6"));
        tv.setPadding(40,0,0,0);

        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //Con esto "inflate" "heredo" la estructura del layout "lhijo.xml"
        View inflate = View.inflate(contexto, R.layout.lhijo, null);
        TextView tv = (TextView) inflate.findViewById(R.id.tvHijo);
        tv.setText(tutoriales_inicial[groupPosition][childPosition]);

        return inflate;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
