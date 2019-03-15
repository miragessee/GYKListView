package com.example.gyklistview;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        final ArrayList arrayList = new ArrayList();
        //arrayList.add("Türkiye");

        Locale trLocale= Locale.forLanguageTag("tr-TR");

        String[] locales = trLocale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("tr-TR", countryCode);

            //System.out.println("Country Code = " + obj.getCountry()
                    //+ ", Country Name = " + obj.getDisplayCountry(trlocale));

            arrayList.add(obj.getDisplayCountry(trLocale));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ulkeAdi = arrayList.get(position).toString();

                Toast.makeText(getApplicationContext(),ulkeAdi, Toast.LENGTH_LONG).show();
                Snackbar.make(view, ulkeAdi, Snackbar.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(ulkeAdi);

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });
    }
}
