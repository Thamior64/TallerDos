package com.example.joseossa.tallerdos;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity implements DialogoCurso.Comunicador {

    Button bCerrar, bAbrir;

    private RecyclerView cursos;
    private RecyclerView.Adapter cursosAdapter;

    private List listaCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bCerrar = (Button)findViewById(R.id.botonCerrar);
        bAbrir = (Button)findViewById(R.id.botonAgregarCurso);


        bCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(home.this, Inicio.class);
                startActivity(intent);
            }
        });

        cursos = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        cursos.setLayoutManager(lim);

        bAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoCurso(view);
            }
        });

        listaCursos = new ArrayList();
        listaCursos.add(new Curso("Ecosistemas super aplicativas", "1604640"));

        cursosAdapter = new CursosAdapter(listaCursos, new CursosAdapter.OnCursoListener() {
            @Override
            public void onCursoClick(Curso curso) {
                Intent nuevaActividad = new Intent(home.this,InsideActivity.class);
                nuevaActividad.putExtra("TITULO",curso.getNombre());
                startActivity(nuevaActividad);
            }
        });

        cursos.setAdapter(cursosAdapter);

    }

    public void mostrarDialogoCurso(View v){
        android.app.FragmentManager manager=getFragmentManager();
        DialogoCurso dialogoCurso = new DialogoCurso();
        dialogoCurso.show(manager, "Dialogo");
    }

    @Override
    public void onDialogMessage(String message) {
        if (!message.contains("nel")){
            listaCursos.add(new Curso(message,""));
            cursosAdapter.notifyItemInserted(listaCursos.size()-1);
            cursosAdapter.notifyDataSetChanged();
        }
    }
}
