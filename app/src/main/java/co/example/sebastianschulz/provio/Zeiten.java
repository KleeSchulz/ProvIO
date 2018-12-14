package co.example.sebastianschulz.provio;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Zeiten extends AppCompatActivity {

    Button btn_gehalt_zeit, btn_stunden;
    EditText et_gehalt, et_stunden;
    TextView tv_letzerbetrag2, tv_gerarbeitet, tv_verkauf, tv_produkt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeiten);
        //Zuweisung
        Allgemein.activityPlaceholder = Zeiten.this;
        et_gehalt = (EditText) findViewById(R.id.et_betrag);
        tv_letzerbetrag2 = (TextView) findViewById(R.id.tv_letzerbetrag);
        btn_gehalt_zeit = (Button) findViewById(R.id.btn_betrag);
        et_stunden = (EditText) findViewById(R.id.et_stunden);
        btn_stunden = (Button) findViewById(R.id.btn_stunden_zeiten);
        tv_verkauf = (TextView) findViewById(R.id.tv_verkauf);
        tv_gerarbeitet = (TextView) findViewById(R.id.tv_gearbeitet);
        tv_produkt = (TextView) findViewById(R.id.tv_produkt);

        //summmieren der Verkäufe
        btn_gehalt_zeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double betrag = 0;

                if (et_gehalt.getText() != null && et_gehalt.getText().length() > 0) {
                    betrag = TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufeMonat) + Double.parseDouble(et_gehalt.getText().toString());
                    TinyDBHelper.setzeDouble(TinyDBHelper.VerkaufeMonat, betrag);
                    ladestatistik();
                }
            }
        });
        //Summieren Arbeitszeiten
        btn_stunden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double stunden = 0;
                if (et_stunden.getText() != null && et_stunden.getText().length() > 0) {
                    stunden = TinyDBHelper.gebeDouble(TinyDBHelper.ArbeitszeitMonat) + Double.parseDouble(et_stunden.getText().toString());
                    TinyDBHelper.setzeDouble(TinyDBHelper.ArbeitszeitMonat, stunden);
                    ladestatistik();
                }
            }
        });
    }

    public void ladestatistik() {
        tv_gerarbeitet.setText(Double.toString(TinyDBHelper.gebeDouble(TinyDBHelper.ArbeitszeitMonat)));
        tv_verkauf.setText(Double.toString(TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufeMonat)));
        String x = Double.toString(Rechnen.produktivität());
        tv_produkt.setText(x);

    }
    //Erstellen des Menüs Monatswerte überschreiben
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.loesche_monatswerte,menu);
        return true;
    }
    //Übershreiben des Monats
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new AlertDialog.Builder(Zeiten.this)
            .setTitle(getResources().getString(R.string.monatueberschreiben))
            .setMessage(getResources().getString(R.string.monatuberschreibenlang))
            .setPositiveButton(getResources().getString(R.string.ja), new DialogInterface.OnClickListener() {
                @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TinyDBHelper.setzteMonat(TinyDBHelper.VerkaufJahr,TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufJahr));
                        TinyDBHelper.setzeDouble(TinyDBHelper.ArbeitszeitMonat, 1.0);
                        TinyDBHelper.setzeDouble(TinyDBHelper.VerkaufeMonat,0.0);
                        ladestatistik();
                    }
                })
            .setNegativeButton(getResources().getString(R.string.nein), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                    }
                }).create().show();
        return true;
    }
}