package co.example.sebastianschulz.provio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatistikMonat extends AppCompatActivity {

    TextView tv_provjanein,tv_gesamtgehalt,tv_einnahemenprov,tv_monatmehr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Zeiten zeiten = new Zeiten();
        Allgemein.activityPlaceholder = StatistikMonat.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik_monat);
        tv_provjanein = (TextView)findViewById(R.id.tv_bekommen);
        tv_gesamtgehalt =(TextView)findViewById(R.id.tv_gesamtgehalt);
        tv_einnahemenprov = (TextView)findViewById(R.id.tv_einnahmenProv);
        tv_monatmehr = (TextView)findViewById(R.id.tv_mehrGehalt);

        tv_provjanein.setText(Double.toString(Rechnen.errchenenVerkauf()));
        if (Rechnen.gehaltunterschied()){
            tv_provjanein.setText("Super! Du bekommst diesen Monat deine Provison");
            tv_gesamtgehalt.setText("Du hast Einnahmen von " + Rechnen.gehaltausgabe() + " durch Provision und Fixum.");
            tv_einnahemenprov.setText("Sie haben Einnahmen " + Rechnen.gewinnProv() +" € durch Verkauf. Sie bekommen " + Rechnen.gebeProzent() + " %.");
            tv_monatmehr.setText("Sie haben diesen Monat " + Rechnen.errechnegewinnprov() + " € mehr zur Verfügung.");
        }
        else {
            tv_provjanein.setText("Schade! Diesen Monats gibt's leider keine Provison");
            tv_gesamtgehalt.setText("Diesen Monat bekommst du dein Grundgehalt von " + Rechnen.gehaltausgabe() + " €.");
            tv_einnahemenprov.setText("Sie hätten Einnahmen von " + Rechnen.gewinnProv() +" € durch Verkauf. ");
            tv_monatmehr.setText("Sie haben nur " + Rechnen.gebeProzent() + " % bekommen, da sie eine Stundenproduktivität von" + Rechnen.produktivität());
        }

    }
}
