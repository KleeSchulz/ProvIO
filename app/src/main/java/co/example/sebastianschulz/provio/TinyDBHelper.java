package co.example.sebastianschulz.provio;

public class TinyDBHelper {

    TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder );

    //werden bei Einstellungen gespeichert
    public static String Gehalt = "Fixum";
    public static String Fixum = "Gehalt";
    public static String ersteStaffelungProzent = "ersteStaffelungProzent";
    public static String zweiteStaffelungProzent = "zweiteStaffelungProzent";
    public static String dritteStaffelungProzent = "dritteStaffelungProzent";
    public static String letzteStaffelungProzent = "letzteStaffelungProzent";
    public static String ersteStaffelungStunde = "ersteStaffelungProzent";
    public static String zweiteStaffelungStunde = "zweiteStaffelungProzent";
    public static String dritteStaffelungStunde = "dritteStaffelungProzent";
    public static String letzteStaffelungStunde = "letzteStaffelungProzent";
    //werden bei Zeiten gespeichert
    public static String VerkaufMonat = "VerkaufMonat";
    public static String ArbeitszeitMonat = "ArbeitszeitMonat";


 public static void setzeDouble(String key, Double wert) {
     TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder);
     tinyDB.putDouble(key,wert);
    }
  public static double gebeDouble(String key){
     TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder);
     double wert = tinyDB.getDouble(key,0);
      return wert;
  }
}
