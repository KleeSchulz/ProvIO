package co.example.sebastianschulz.provio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hauptmenue extends AppCompatActivity {

    Button btn_arbeit, btn_zeigeStunden, btn_provision, btn_umsatz, btn_einstellung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hauptmenue);

        btn_arbeit = (Button)findViewById(R.id.btn_arbeit);
        btn_arbeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hauptmenue.this,Zeiten.class));
            }
        });
        btn_zeigeStunden = (Button)findViewById(R.id.btn_zeigeStunden);
        //Todo zeige Statistiken Monat
        btn_provision = (Button)findViewById(R.id.btn_Prov);
        //Todo zeige Gehalt und Statistiken
        btn_umsatz = (Button)findViewById(R.id.btn_umsatz);
        //todo zeige Jahresstatistik
        btn_einstellung = (Button)findViewById(R.id.btn_einstellung);
        btn_einstellung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hauptmenue.this, Einstellungen.class));
            }
        });

    }
}
