package xyz.devfest.devfestandroidlibs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import xyz.devfest.devfestandroidlibs.gson.ActivityGson;
import xyz.devfest.devfestandroidlibs.iconis.ActivityIconics;
import xyz.devfest.devfestandroidlibs.material.ActivityMaterial;
import xyz.devfest.devfestandroidlibs.orm.ActivityOrm;
import xyz.devfest.devfestandroidlibs.slider.ActivitySlider;
import xyz.devfest.devfestandroidlibs.universal.ActivityUniversalImage;
import xyz.devfest.devfestandroidlibs.zxing.ActivityZxing;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener{

    private Button btnGson;
    private Button btnOrm;
    private Button btnUniversal;
    private Button btnIconics;
    private Button btnMaterial;
    private Button btnSlider;
    private Button btnZxing;

    private Context context;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        // Handle Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setTitle("Android Libs");

        context=this;

         btnGson=(Button)findViewById(R.id.btnGson);
         btnOrm=(Button)findViewById(R.id.btnOrm);
         btnUniversal=(Button)findViewById(R.id.btnUniversal);
         btnIconics=(Button)findViewById(R.id.btnIconics);
         btnMaterial=(Button)findViewById(R.id.btnMaterial);
         btnSlider=(Button)findViewById(R.id.btnSlider);
         btnZxing=(Button)findViewById(R.id.btnZxing);

        btnGson.setOnClickListener(this);
        btnOrm.setOnClickListener(this);
        btnUniversal.setOnClickListener(this);
        btnIconics.setOnClickListener(this);
        btnMaterial.setOnClickListener(this);
        btnSlider.setOnClickListener(this);
        btnZxing.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(context,"Aplicación creada por Andrés Vasquez",Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnGson: IniciarActivity(ActivityGson.class);break;
            case R.id.btnOrm:IniciarActivity(ActivityOrm.class);break;
            case R.id.btnUniversal:IniciarActivity(ActivityUniversalImage.class);break;
            case R.id.btnIconics:IniciarActivity(ActivityIconics.class);break;
            case R.id.btnMaterial:IniciarActivity(ActivityMaterial.class);break;
            case R.id.btnSlider:IniciarActivity(ActivitySlider.class);break;
            case R.id.btnZxing:IniciarActivity(ActivityZxing.class);break;
        }
    }

    private void IniciarActivity(Class<?> clase)
    {
        Intent intent=new Intent(context,clase);
        startActivity(intent);
    }
}
