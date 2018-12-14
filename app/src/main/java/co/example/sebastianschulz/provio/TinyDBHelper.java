package co.example.sebastianschulz.provio;

import java.util.ArrayList;

public class TinyDBHelper {

    TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder );

    //werden bei Einstellungen gespeichert
    public static String Gehalt = "Fixum";
    public static String Fixum = "Gehalt";
    public static String ersteStaffelungProzent = "ersteStaffelungProzent";
    public static String zweiteStaffelungProzent = "zweiteStaffelungProzent";
    public static String dritteStaffelungProzent = "dritteStaffelungProzent";
    public static String letzteStaffelungProzent = "letzteStaffelungProzent";
    public static String ersteStaffelungStunde = "ersteStaffelungStunde";
    public static String zweiteStaffelungStunde = "zweiteStaffelungStunde";
    public static String dritteStaffelungStunde = "dritteStaffelungStunde";
    public static String letzteStaffelungStunde = "letzteStaffelungStunde";
    //werden bei Zeiten gespeichert
    public static String VerkaufeMonat = "VerkaufMonat";
    public static String ArbeitszeitMonat = "ArbeitszeitMonat";
    //Jahresdurchschnitt
    public static String VerkaufJahr = "VerkaufJahr";

 public static void setzeDouble(String key, Double wert) {
     TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder);
     tinyDB.putDouble(key,wert);
    }
  public static double gebeDouble(String key){
     TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder);
     double wert = tinyDB.getDouble(key,0);
      return wert;
  }

  public static ArrayList gebeArraydouble(String key){
        TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder);
        ArrayList<Double>werte = tinyDB.getListDouble(key);

        return werte;
  }

  public static int gebeAnzahlArray(String key){
     int anzahl = 0;
     anzahl = gebeArraydouble(key).size();
     return anzahl;
  }

  public static void setzteMonat(String key,double monatswert){
     TinyDB tinyDB = new TinyDB(Allgemein.activityPlaceholder);
      ArrayList<Double>jahreswert = gebeArraydouble(key);
      if (jahreswert.size()>11){
          jahreswert.remove(0);
      }
      jahreswert.add(monatswert);
      tinyDB.putListDouble(key,jahreswert);
  }
}
