package com.app.nonasoft.grupo2_desarrollodesoftware.Activities;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TabHost;

import com.app.nonasoft.grupo2_desarrollodesoftware.R;

public class SegundaActivity extends AppCompatActivity {
    ExpandableListView lista_expandible_incial;
    ExpandableListView lista_expandible_intermedo;
    ExpandableListView lista_expandible_avazado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        //tabs
        Resources res = getResources();

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();


        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.inicial);
        spec.setIndicator("inicial");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.intermedio);
        spec.setIndicator("medio");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.avanzado);
        spec.setIndicator("avanzado");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
        //tabs

        //ExpandableListView
        lista_expandible_incial = (ExpandableListView) findViewById(R.id.expandableListView1);
        lista_expandible_incial.setAdapter(new AdaptadorInicial(this));

        lista_expandible_intermedo = (ExpandableListView) findViewById(R.id.expandableListView2);
        lista_expandible_intermedo.setAdapter(new AdaptadorIntermedio(this));

        lista_expandible_avazado = (ExpandableListView) findViewById(R.id.expandableListView3);
        lista_expandible_avazado.setAdapter(new AdaptadorAvanzado(this));
    }
}
