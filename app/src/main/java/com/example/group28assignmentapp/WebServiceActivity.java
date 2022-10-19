package com.example.group28assignmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.group28assignmentapp.databinding.ActivityMainBinding;
import com.example.group28assignmentapp.databinding.ActivityWebServiceBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WebServiceActivity extends AppCompatActivity {
    private ActivityWebServiceBinding binding;
    private TextView dummyText;
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebServiceBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dummyText = binding.dummyText;

//        try {
//            url = new URL("https://google.com");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//        HttpURLConnection conn = null;
//        try {
//            conn = (HttpURLConnection) url.openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            conn.setRequestMethod("GET");
//        } catch (ProtocolException e) {
//            e.printStackTrace();
//        }
//        conn.setDoInput(true);
//
//        try {
//            conn.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Read response.
//        InputStream inputStream = null;
//        try {
//            inputStream = conn.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String resp = WebServiceActivity.convertStreamToString(inputStream);
//        dummyText.setText(resp);



    }

    public static String convertStreamToString(InputStream inputStream){
        StringBuilder stringBuilder=new StringBuilder();
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String len;
            while((len=bufferedReader.readLine())!=null){
                stringBuilder.append(len);
            }
            bufferedReader.close();
            return stringBuilder.toString().replace(",", ",\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}