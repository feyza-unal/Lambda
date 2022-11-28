import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println();
        tekKupPrint(sayi);
        System.out.println();
        ciftKarekokPrint(sayi);
        System.out.println();
        enBuyukPrint(sayi);
        System.out.println();
        structuredEnBuyukPrint(sayi);
        System.out.println();
        ciftKareEnBuyukPrint(sayi);
        System.out.println();
        elemanlarinToplamiPrint(sayi);
        System.out.println();
        ciftCarpimPrint(sayi);
        System.out.println();
        minBul(sayi);
        System.out.println();
        bestenBuyukMinTek(sayi);
        System.out.println();
        ciftKareSirala(sayi);
    }

//---------------------------------------------------------------------------------------------------------
// Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul). // streamdeki(akis) cift sayilari filtreledim 4 2 6
                map(t->t*t).  // 16 4 36  -->map() stream icerisindeki elemanlari baska degerlere donusturur
                forEach(Lambda01::yazdir);
    }

//---------------------------------------------------------------------------------------------------------
// Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin
    public static void tekKupPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2 != 0). // 11,-5,7,3,15
                map(t->(t*t*t)+1). //1332 -124 344 28 3376
                forEach(Lambda01::yazdir);
    }

//---------------------------------------------------------------------------------------------------------
// Task-3 : Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). // double
                forEach(t-> System.out.print(t+ " "));
    }

//---------------------------------------------------------------------------------------------------------
// Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void enBuyukPrint(List<Integer> sayi){
        Optional<Integer> maxSayi = sayi.  // optional-> reduce() methodu ile null p.exc. gelirse kod calismayi durdurur.
                // bunu onlemek icin optional kullanilir
                stream().
                reduce(Math::max); // eger sonuc tek bir deger ise o zaman reduce() terminal operatoru kullanilir. terminal
        // operatoru oldugu icin akis biter
        System.out.println(maxSayi); //Optional[15]
    }

// structured yapi ile cozelim
    public static void structuredEnBuyukPrint(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);
        for (int i = 0; i <sayi.size(); i++) {
            if (sayi.get(i)>max) max = sayi.get(i);
        }
        System.out.println("en buyuk sayi : " + max);
    }

//---------------------------------------------------------------------------------------------------------
// Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareEnBuyukPrint(List<Integer> sayi){
        System.out.println(sayi.stream().  // atama yapmadan direk yazdirdigimiz icin optional kullanmadik
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));  // "Integer::max" methodu, "Math::max"e gore daha hizli calisir.(Math class cok buyuk)
    }

//---------------------------------------------------------------------------------------------------------
// Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elemanlarinToplamiPrint(List<Integer> sayi){
        int toplam = sayi.
                stream().
                reduce(0,(a,b) -> a+b);
        System.out.println("toplam = " + toplam); //toplam = 43
    }
/*
    * a ilk degerini her zaman atanan degerden (ilk parametre) alır, bu örnekte 0 oluyor (sum=0 gibi etkisiz eleman atiyoruz)
    * b degerini her zamana  stream()'dan akısdan alır
    * a ilk degerinden sonraki her değeri action(işlem)'dan alır
*/
//---------------------------------------------------------------------------------------------------------
// Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarpimPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); //48      => method reference
        // Math::multiplyExact-> listedeki butun elemanlari carpip gonderir

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b));  //   => lambda expression
    }

//---------------------------------------------------------------------------------------------------------
// Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi){
        //1. yol method reference
        System.out.println(sayi.
                stream().
                reduce(Integer::min));  // Math::min

        //2. yol lambda expression
        System.out.println(sayi.
                stream().
                reduce(Lambda02::bulMin));
    }
    public static int bulMin(int a , int b) {

        return (a<b) ? a : b ;   // byMiracMin(4,9)
    }

//---------------------------------------------------------------------------------------------------------
// Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukMinTek(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(t -> (t > 5) && (t % 2 == 1)).
                reduce(Lambda02::bulMin));
    }


//---------------------------------------------------------------------------------------------------------
// Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareSirala(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).// sayıların karesi ile yeni bir akış oluşturdum
                sorted(). // akış içindeki sayıları natural-order olarak sıraladım
                forEach(Lambda01::yazdir); // akışdaki, sayıları ekrana yazdım
    }
}

