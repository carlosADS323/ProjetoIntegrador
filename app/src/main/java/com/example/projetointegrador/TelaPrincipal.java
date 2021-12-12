package com.example.projetointegrador;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TelaPrincipal extends AppCompatActivity {

    private TextView nomeUsuario, emailUsuario;
    private Button bt_deslogar;
    private Button bt_treino;
    private Button bt_imc;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        getSupportActionBar().hide();
        IniciarComponentes();


        /*
        MaterialToolbar toolbar = findViewById(R.id.toAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id) {
                    case R.id.nav_home:
                        replaceFragment(new Fragment());
                        break;

                    default:
                        return true;

                }
                return true;
            }
        });
       */
        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(TelaPrincipal.this, FormLogin.class);
                startActivity(intent);
                finish();
            }
        });


        bt_treino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance();
                Intent intent = new Intent(TelaPrincipal.this, TelaTreino.class);
                startActivity(intent);

            }
        });

        bt_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance();
                Intent intent = new Intent(TelaPrincipal.this, TelaImc.class);
                startActivity(intent);

            }
        });

    }

    /*
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    */
    /*-----------------------BOTÕES---------------------------*/


    @Override
    protected void onStart() {
        super.onStart();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("Usuarios").document(usuarioId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null) {
                    nomeUsuario.setText(documentSnapshot.getString("nome"));
                    emailUsuario.setText(email);
                }
            }
        });
    }

    private void IniciarComponentes() {
        nomeUsuario = findViewById(R.id.textNomeUsuario);
        emailUsuario = findViewById(R.id.textEmailUsuario);
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_treino = findViewById(R.id.bt_treino);
        bt_imc = findViewById(R.id.bt_imc);

    }


}

