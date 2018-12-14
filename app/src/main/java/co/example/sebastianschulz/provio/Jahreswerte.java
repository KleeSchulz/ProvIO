package co.example.sebastianschulz.provio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Jahreswerte extends AppCompatActivity {

    TextView pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Allgemein.activityPlaceholder = Jahreswerte.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jahreswerte);
        pro = (TextView)findViewById(R.id.tv_produkt);
        pro.setText((int) TinyDBHelper.gebeDouble(TinyDBHelper.Fixum));
    }
}
