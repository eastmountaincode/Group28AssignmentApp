package com.example.group28assignmentapp;

import static android.view.View.Z;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.group28assignmentapp.databinding.ActivityMainBinding;
import com.example.group28assignmentapp.databinding.ActivityWebServiceBinding;

import java.io.BufferedInputStream;
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
    private Handler handler;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebServiceBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.bottomPart, GenreGetFragment.newInstance())
                    .commitNow();
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.topPart, SongListFragment.newInstance(), "SongList")
                    .commitNow();
        }


//        dummyText = binding.dummyText;
//        handler = new Handler();
//        MyThread thread = new MyThread();
//        thread.start();

    }

//    public static String convertStreamToString(InputStream inputStream){
//        StringBuilder stringBuilder=new StringBuilder();
//        try {
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//            String len;
//            while((len=bufferedReader.readLine())!=null){
//                stringBuilder.append(len);
//            }
//            bufferedReader.close();
//            return stringBuilder.toString().replace(",", ",\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    private class MyThread extends Thread {
//        @Override
//        public void run() {
//
//            try {
//                url = new URL("https://google.com");
//                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
//                try {
//                    urlc.setRequestProperty("Connection", "close");
//                    urlc.setConnectTimeout(1000 * 30); // Timeout is in seconds
//
//                    InputStream inputStream = new BufferedInputStream(urlc.getInputStream());
//                    result = WebServiceActivity.convertStreamToString(inputStream);
//                }
//                finally {
//                    urlc.disconnect();
//                }
//
//
//            }
//            catch (MalformedURLException e1) {
//                e1.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    dummyText.setText(result);
//                }
//            });
//
//        }
//    }


}