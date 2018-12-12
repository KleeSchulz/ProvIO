package co.example.sebastianschulz.provio;

public class Rechnen {

    //erechnet die Stundenproduktivität
    public static double produktivität (){
        double produkt;
        produkt = Math.round((TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufeMonat)/TinyDBHelper.gebeDouble(TinyDBHelper.ArbeitszeitMonat)*100)/100.0);
        return produkt;
    }

    //gebe den höchsten Prozentwert aus
    public static double gebeProzent() {
        double produktivitaetStunde = produktivität();
        if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.letzteStaffelungStunde)) {
            return TinyDBHelper.gebeDouble(TinyDBHelper.ersteStaffelungProzent);
        }
        else if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.dritteStaffelungStunde)) {
            return TinyDBHelper.gebeDouble(TinyDBHelper.zweiteStaffelungProzent);
        }
        else if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.zweiteStaffelungStunde)) {
            return TinyDBHelper.gebeDouble(TinyDBHelper.dritteStaffelungProzent);
        }
        else
        {
            return  TinyDBHelper.gebeDouble(TinyDBHelper.letzteStaffelungProzent);
        }


    }
    //Errechen Fixum + Provison
    public static double errchenenVerkauf(){
        double betrag;
        betrag = TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufeMonat) * Rechnen.gebeProzent();
        betrag = Math.round(betrag*100)/100;
        return betrag;
    }

    //Errechne Gewinn Provison (errechneVerkauf - Gehalt)
    public static double errechnegewinnprov(){
        return errchenenVerkauf()-TinyDBHelper.gebeDouble(TinyDBHelper.Gehalt);
    }

    //Gebe Gewinn Provision aus
    public static double gewinnProv(){
        double gewinn = Math.round((errchenenVerkauf() - TinyDBHelper.gebeDouble(TinyDBHelper.Fixum)*100)/100);
        return gewinn;
    }

    //Gebe aus ob Gehalt Größer/Kleiner als Provision
    public static boolean gehaltunterschied (){
        boolean provison;
        if (errchenenVerkauf() >= TinyDBHelper.gebeDouble(TinyDBHelper.Gehalt)){
            provison = true;
        }
        else
        {
            provison = false;
        }
        return provison;
    }

    //Gebe Gesamtgehalt aus -> schauen ob Provision größer als Normgehalt
    public static double gehaltausgabe(){
        if (gehaltunterschied()){
            return errchenenVerkauf();
        }
        else {
            return TinyDBHelper.gebeDouble(TinyDBHelper.Gehalt);
        }
    }

    public static double durchschnittjahr(){
        /*
        Initalsiere Array -> von Tinydb
        double durchschnitt = 0;
        for (int i = 0,i<=array.length;i++ {
        durchschnitt = array.getElement[i] + durschnitt
        }
        durchschnitt = durchschnitt/array.length();
        return durchschnitt;
*/
        return 0.0;
    }
}
