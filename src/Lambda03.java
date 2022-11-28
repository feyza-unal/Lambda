import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec",
                "küşleme","arabAşı","waffle","künefe"));
        alfBykTekrarsiz(menu);
        System.out.println();
        charSayisiTersTekrarsiz(menu);
        System.out.println();
        charSayisiKcktenByge(menu);
        System.out.println();
        harfSayisiKontrol(menu);



    }

//---------------------------------------------------------------------------------------------------------
// Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrarsiz(List<String> yemek){
        yemek.
                stream().
                map(String::toUpperCase). //buyuk harf
                sorted(). //dogal siralama (a-z)
                distinct(). // tekrarsiz olmasini sagladi
                forEach(t-> System.out.print(t + " "));
    }

//---------------------------------------------------------------------------------------------------------
// Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void charSayisiTersTekrarsiz(List<String> ikram){
        ikram.
                stream().
                map(String::length). // kelimelerin uzunlugu, akisi guncelledim
                sorted(Comparator.reverseOrder()). //ters sirali
                distinct().
                forEach(Lambda01::yazdir);
    }

//---------------------------------------------------------------------------------------------------------
// Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void charSayisiKcktenByge(List<String> ikram){
        ikram.
                stream().
                sorted(Comparator.comparing(String::length)). //karakter sayisina gore sirala (k->b)
                forEach(Lambda01::yazdir);
    }
// ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
//*******************************************************************************************

//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

//---------------------------------------------------------------------------------------------------------
// Task-4 : List elelmmalarinin hepsinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisiKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanlari 7 ve 7den az harften olusuyor" :
                "list elemanlari 7 harften buyuk");
    }

//---------------------------------------------------------------------------------------------------------
// Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
        public static void wIleBaslayanElKontrol(List<String> ikram) {
            System.out.println(ikram.
                    stream().
                    noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                    "w ile yemek icat ettik");
        }

//---------------------------------------------------------------------------------------------------------
// Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
        public static void xIleBitenElKontrol(List<String> ikram) {
            System.out.println(ikram.
                    stream().
                    anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi mi biter");
        }

//---------------------------------------------------------------------------------------------------------
// Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEbBykElPrint (List<String> ikram){
        Stream<String> sonIsim =ikram.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).
                reversed()). //karakter sayisina gore tersten siralandi
                limit(1); //limit metodu kullanilarak sadece ilk eleman cagrildi (3 desek ilk 3u alirdi)
        System.out.println(sonIsim);
    }



















}

