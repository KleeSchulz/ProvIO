package co.example.sebastianschulz.provio;

public class Rechnen {

    public static double produktivität (){
        double produkt;
        produkt = Math.round((TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufMonat)/TinyDBHelper.gebeDouble(TinyDBHelper.ArbeitszeitMonat)*100)/100.0);
        return produkt;
    }
}
