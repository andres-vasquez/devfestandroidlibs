package xyz.devfest.devfestandroidlibs.orm;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.devfest.devfestandroidlibs.Persona;
import xyz.devfest.devfestandroidlibs.R;

public class ActivityOrm extends AppCompatActivity {

    private Context context;
    private List<Persona> items =new ArrayList<Persona>();
    private ListaAdapter adapter;

    private Button btnInsertar;
    private ListView lstBaseDatos;

    private DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_orm);

        context=this;
        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btnInsertar=(Button)findViewById(R.id.btnInsertar);
        lstBaseDatos=(ListView)findViewById(R.id.lstBaseDatos);

        adapter=new ListaAdapter(context, items, new ListaAdapter.Callback() {
            @Override
            public void eliminar(Persona persona) {
                Dao dao;
                try {
                    dao = getHelper().getPersonaDao();
                    dao.delete(persona);
                    obtenerRegistros();
                } catch (SQLException e) {
                    Log.e("ActivityOrm", "Error eliminar usuario");
                }
            }

            @Override
            public void editar(Persona persona) {
                Dao dao;
                try {
                    dao = getHelper().getPersonaDao();
                    dao.update(persona);
                    obtenerRegistros();
                } catch (SQLException e) {
                    Log.e("ActivityOrm", "Error editar usuario");
                }
            }
        });
        lstBaseDatos.setAdapter(adapter);


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dao dao;
                try {
                    dao = getHelper().getPersonaDao();
                    Persona persona=new Persona("Juan","Perez",16);
                    dao.create(persona);
                } catch (SQLException e) {
                    Log.e("ActivityOrm", "Error creando usuario");
                }
                obtenerRegistros();
            }
        });
        obtenerRegistros();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_activity_zxing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private DBHelper getHelper() {
        if (mDBHelper == null) {
            mDBHelper = OpenHelperManager.getHelper(this, DBHelper.class);
        }
        return mDBHelper;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDBHelper != null) {
            OpenHelperManager.releaseHelper();
            mDBHelper = null;
        }
    }


    private void obtenerRegistros()
    {
        Dao dao;
        try {
            dao = getHelper().getPersonaDao();
            QueryBuilder queryBuilder = dao.queryBuilder();
            List<Persona> personas = dao.query(queryBuilder.prepare());
            if (!personas.isEmpty())
            {
                items.clear();
                items.addAll(personas);
            }
            else
                items.clear();

            adapter.notifyDataSetChanged();
        } catch (SQLException e) {
            Log.e("ActivityOrm", "Error cargando datos");
        }
    }
}
