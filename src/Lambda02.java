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
    }

//---------------------------------------------------------------------------------------------------------
// Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul). // streamdeki(akis) cift sayilari filtreledim 4 2 6
                map(t->t*t).  // 16 4 36  --> stream icerisindeki elemanlari baska degerlere donusturur
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
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // eger sonuc tek bir deger ise o zaman reduce() terminal operatoru kullanilir
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
        Optional<Integer> max = sayi.stream().
                filter(Lambda01::ciftBul).
                map(a->a*a).
                reduce(Integer::max);  //Math::max a gore daha hizli calisir
        System.out.println("max = " + max); //max = Optional[36]
    }

//---------------------------------------------------------------------------------------------------------
// Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elemanlarinToplamiPrint(List<Integer> sayi){
        int toplam = sayi.
                stream().
                reduce(0,(a,b) -> a+b);
        System.out.println("toplam = " + toplam); //toplam = 43

    }








}

