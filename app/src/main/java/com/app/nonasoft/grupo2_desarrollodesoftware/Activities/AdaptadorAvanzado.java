package com.app.nonasoft.grupo2_desarrollodesoftware.Activities;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.app.nonasoft.grupo2_desarrollodesoftware.R;

/**
 * Created by Yoel on 10/09/2016.
 */
public class AdaptadorAvanzado extends BaseExpandableListAdapter {
    Context contexto;
    String[] padre_avanzado= {"Navegar por internet", "Configuracion del celular", "Correo electronico", "Noticias"};

    String[][] tutoriales_avanzado= {
            {"Agregar tutorial"},
            {"Agregar tutoriales"},
            {"Agregar tutoriales"},
            {"Agregar tutoriales"}
    };

    public AdaptadorAvanzado(Context context){
        this.contexto = context;
    }

    @Override
    public int getGroupCount() {
        return padre_avanzado.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return tutoriales_avanzado[groupPosition].length;
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
        tv.setText(this.padre_avanzado[groupPosition]);
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
        tv.setText(tutoriales_avanzado[groupPosition][childPosition]);

        return inflate;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
