package co.example.sebastianschulz.provio;

public class Rechnen {

    public static double produktivität (){
        double produkt;
        produkt = Math.round((TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufMonat)/TinyDBHelper.gebeDouble(TinyDBHelper.ArbeitszeitMonat)*100)/100.0);
        return produkt;
    }

    //Errechen Fixum + Provison
    public static double erchenenVerkauf(){
        double produktivitaetStunde = produktivität();
        double betrag = 0.0;
        if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.ersteStaffelungStunde)){
            betrag = TinyDBHelper.gebeDouble(TinyDBHelper.Fixum) + (TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufMonat)*TinyDBHelper.gebeDouble(TinyDBHelper.ersteStaffelungProzent));
        }
        if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.zweiteStaffelungStunde)){
            betrag = TinyDBHelper.gebeDouble(TinyDBHelper.Fixum) + (TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufMonat)*TinyDBHelper.gebeDouble(TinyDBHelper.zweiteStaffelungProzent));
        }
        if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.dritteStaffelungStunde)){
            betrag = TinyDBHelper.gebeDouble(TinyDBHelper.Fixum) + (TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufMonat)*TinyDBHelper.gebeDouble(TinyDBHelper.dritteStaffelungProzent));
        }
        if (produktivitaetStunde < TinyDBHelper.gebeDouble(TinyDBHelper.letzteStaffelungStunde)){
            betrag = TinyDBHelper.gebeDouble(TinyDBHelper.Fixum) + (TinyDBHelper.gebeDouble(TinyDBHelper.VerkaufMonat)*TinyDBHelper.gebeDouble(TinyDBHelper.letzteStaffelungProzent));
        }
        betrag = Math.round(betrag*100)/100;
        return betrag;
    }

    //Gebe Gewinn Provision aus
    public static double gewinnProv(){
        double gewinn = Math.round((erchenenVerkauf() - TinyDBHelper.gebeDouble(TinyDBHelper.Fixum)*100)/100);
        return gewinn;
    }

    //Gebe aus ob Gehalt Größer/Kleiner als Provision
    public static boolean gehaltunterschied (){
        boolean provison;
        if (erchenenVerkauf() > TinyDBHelper.gebeDouble(TinyDBHelper.Gehalt)){
            provison = true;
        }
        else
        {
            provison = false;
        }
        return provison;
    }
}
