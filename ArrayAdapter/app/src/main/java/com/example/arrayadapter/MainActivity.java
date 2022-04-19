package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> elt = getList("pays.json");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.ligne, R.id.txt, elt);
        spinner.setAdapter(adapter);
    }



    private ArrayList<String> getList(String fileName) {
        JSONArray jsonArray = null;
        ArrayList<String> cList = new ArrayList<String>();
        try {
            InputStream sp = getResources().getAssets().open(fileName);
            int size = sp.available();
            byte[] data = new byte[size];
            sp.read(data);
            sp.close();
            String json = new String(data, "UTF-8");
            jsonArray = new JSONArray(json);
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    cList.add(jsonArray.getJSONObject(i).getString("cnom"));
                }
            }
        }
        catch(UnsupportedEncodingException ue){ ue.printStackTrace(); }
        catch(IOException e){ e.printStackTrace(); }
        catch(JSONException j){ j.printStackTrace(); }
        return cList;
        }

    }