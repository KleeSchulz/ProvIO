package co.example.sebastianschulz.provio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Einstellungen extends AppCompatActivity {

    //todo Hardstrings durch Stringxml ersetzen
    Button btn_safe;
    EditText et_gehalt, et_fixum, et_ersteProzent,et_ersteGehalt, et_zweiteProzent,et_zweiteGehalt, et_dritteProzent, et_dritteGehalt,et_letzteProzent, et_letzteGehalt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);
        Allgemein.activityPlaceholder = Einstellungen.this;
    //Zuweisung
        et_gehalt = (EditText) findViewById(R.id.et_gehalt);
        et_fixum = (EditText) findViewById(R.id.et_fixum);
        et_ersteProzent = (EditText) findViewById(R.id.et_ersteProzent);
        et_ersteGehalt = (EditText) findViewById(R.id.et_ersteStunde);
        et_zweiteProzent = (EditText) findViewById(R.id.et_zweiteProzent);
        et_zweiteGehalt = (EditText) findViewById(R.id.et_zweiteStunde);
        et_dritteProzent = (EditText) findViewById(R.id.et_dritteProzent);
        et_dritteGehalt = (EditText) findViewById(R.id.et_dritteStunde);
        et_letzteProzent = (EditText) findViewById(R.id.et_letzteProzent);
        et_letzteGehalt = (EditText) findViewById(R.id.et_letzterGehalt);
    //Lade Werte bei öffnen Acticty
        ladeWerte();

        btn_safe = (Button)findViewById(R.id.btn_safe);
        btn_safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_gehalt.getText() !=null && et_gehalt.getText().length()>0
                    && et_fixum.getText() !=null && et_fixum.getText().length()>0
                    && et_ersteProzent.getText() !=null && et_ersteProzent.getText().length()>0
                    && et_ersteGehalt.getText() !=null && et_ersteGehalt.getText().length()>0
                    && et_zweiteProzent.getText() !=null && et_zweiteProzent.getText().length()>0
                    && et_zweiteGehalt.getText() !=null && et_zweiteGehalt.getText().length()>0
                    && et_dritteProzent.getText() !=null && et_dritteProzent.getText().length()>0
                    && et_dritteGehalt.getText() !=null && et_dritteGehalt.getText().length()>0
                    && et_letzteProzent.getText() !=null && et_letzteProzent.getText().length()>0
                    && et_letzteGehalt.getText() !=null && et_letzteGehalt.getText().length()>0
                    ){

                        TinyDBHelper.setzeDouble(TinyDBHelper.Gehalt, Double.parseDouble(et_gehalt.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.Fixum,Double.parseDouble(et_fixum.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.ersteStaffelungProzent,Double.parseDouble(et_ersteProzent.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.ersteStaffelungStunde,Double.parseDouble(et_ersteGehalt.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.zweiteStaffelungProzent,Double.parseDouble(et_zweiteProzent.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.zweiteStaffelungStunde,Double.parseDouble(et_zweiteGehalt.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.dritteStaffelungProzent,Double.parseDouble(et_dritteProzent.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.dritteStaffelungStunde,Double.parseDouble(et_dritteGehalt.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.letzteStaffelungProzent,Double.parseDouble(et_letzteProzent.getText().toString()));
                        TinyDBHelper.setzeDouble(TinyDBHelper.letzteStaffelungStunde,Double.parseDouble(et_letzteGehalt.getText().toString()));
                        ladeWerte();
                        Allgemein.toastshort(Einstellungen.this,"Daten wurden gespeichert");
                        ladeWerte();
                }
                else {
                         Allgemein.toastshort(Einstellungen.this,"Felder dürfen nicht leer sein!");
                }
            }
        });
    }

    //Lade Werte
    public void ladeWerte(){
        Double wert = TinyDBHelper.gebeDouble(TinyDBHelper.Gehalt);
        et_gehalt.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.Fixum);
        et_fixum.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.ersteStaffelungProzent);
        et_ersteProzent.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.ersteStaffelungStunde);
        et_ersteGehalt.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.zweiteStaffelungProzent);
        et_zweiteProzent.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.zweiteStaffelungStunde);
        et_zweiteGehalt.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.dritteStaffelungProzent);
        et_dritteProzent.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.dritteStaffelungStunde);
        et_dritteGehalt.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.letzteStaffelungProzent);
        et_letzteProzent.setText(wert.toString());
        wert = TinyDBHelper.gebeDouble(TinyDBHelper.letzteStaffelungStunde);
        et_letzteGehalt.setText(wert.toString());
    }
}
