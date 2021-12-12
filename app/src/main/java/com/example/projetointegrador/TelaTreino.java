package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TelaTreino extends AppCompatActivity {

    private Button botaoWeb;
    private Button botaoWeb2;
    private Button botaoWeb3;
    private Button botaoWeb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_treino);

        getSupportActionBar().hide();

        botaoWeb = (Button) findViewById(R.id.bt_download1);
        botaoWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mediafire.com/file/26qvhsx65ghmhbz/Treino+Iniciante+1.pdf/file")));
            }
        });

        botaoWeb2 = (Button) findViewById(R.id.bt_download2);
        botaoWeb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mediafire.com/file/6zqlami319gk1cw/Treino+Intermediario+1.pdf/file")));
            }
        });

        botaoWeb3 = (Button) findViewById(R.id.bt_download3);
        botaoWeb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mediafire.com/file/echdt8amdzdw79l/Treino+Avançado+1.pdf/file")));
            }
        });

        botaoWeb4 = (Button) findViewById(R.id.bt_download4);
        botaoWeb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mediafire.com/file/ufc9sjzpks3gir1/Treino_Adaptativo.pdf/file")));
            }
        });

    }



}