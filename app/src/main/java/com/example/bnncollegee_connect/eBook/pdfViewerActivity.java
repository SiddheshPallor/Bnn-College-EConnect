package com.example.bnncollegee_connect.eBook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bnncollegee_connect.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class pdfViewerActivity extends AppCompatActivity {

    private String pdfUrl;
    private PDFView pdfView;
    private SpinKitView pdfSpinKitProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        pdfUrl = getIntent().getStringExtra("pdfUrl");
        pdfView = findViewById(R.id.pdfView);
        pdfSpinKitProgressBar = findViewById(R.id.pdfSpinKitProgressBar);



        loadFile(pdfUrl);

    }
    // Using AsyncTask by extending it so that pdf will download in background thread and the result will shown in our UI Thread!
    private void loadFile(String pdfUrl) {
        FileLoader.with(this)
                .load(pdfUrl) //2nd parameter is optional, pass true to force load from network
                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File loadedFile = response.getBody();
                        pdfSpinKitProgressBar.setVisibility(View.GONE);
                        pdfView.fromFile(loadedFile)
                                .defaultPage(0)
                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .spacing(5)
                                .load();
                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        Toast.makeText(pdfViewerActivity.this, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        pdfSpinKitProgressBar.setVisibility(View.GONE);
                    }
                });
    }
}






// This code was applied before Progressbar Initiation

//private  class  PdfDownload extends AsyncTask<String, Void, InputStream>{
//
//
//    @Override
//    protected InputStream doInBackground(String... strings) {
//        InputStream inputStream = null;
//
//        try {
//            URL url = new URL(strings[0]);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//
//            if (urlConnection.getResponseCode() == 200){
//                inputStream = new BufferedInputStream(urlConnection.getInputStream());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return inputStream;
//    }
//
//    @Override
//    protected void onProgressUpdate(Void... values) {
//        super.onProgressUpdate(values[0]);
//    }
//
//    @Override
//    protected void onPostExecute(InputStream inputStream) {
//        pdfView.fromStream(inputStream)
//                .load();
//
//    }