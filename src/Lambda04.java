import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
/*
 TASK :
 fields --> Universite (String)
            bolum (String)
            ogrcSayisi (int)
            notOrt (int)
            olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
*/
/*
     Pojo(Plain Old Java Object) Class nedir
     1)Variable ları private olan (Encapsulation yapılmış olan)
     2)Bir parametresiz birde parametreli Constructor olan
     3)Getter ve Setter methodlar olan
     4)toString() methodu olan
     Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
*/
    public static void main(String[] args) {
        University u01 = new University("bogazici","matematik",571,93);
        University u02 = new University("itu","matematik",600,81);
        University u03 = new University("istanbul","hukuk",1400,71);
        University u04 = new University("marmara","bil muh",1080,77);
        University u05 = new University("odtu","gemi muh",333,74);

        List<University> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));
        System.out.println(notOrt74tenBykUni(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println();
        matBolumSayisi(unv);
        System.out.println();
        System.out.println(enBykNot(unv));
        System.out.println();
        System.out.println(enKckNotOrt(unv));


    }

//---------------------------------------------------------------------------------------------------------
//task 01--> butun unv. lerin notOrt'larinin 74' den buyuk old kontrol eden pr create ediniz.
    public static boolean notOrt74tenBykUni(List<University> unv){
        return unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }

//---------------------------------------------------------------------------------------------------------
//task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini kontrol eden pr create ediniz.

    public static boolean matBolumVarMi(List<University> unv){
        return unv.
                stream().
                anyMatch(t->t.getBolum().toLowerCase().contains("mat")); //bolum isimleri alindi
                // bolum isimleri kucuk harfe cevrildi. "mat" kelimesi var mi kontrol edildi
    }
//---------------------------------------------------------------------------------------------------------
//task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<University> ogrSayisiBykSirala (List<University> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(University::getOgrcSayisi).reversed()). // universiteler öğrenci sayısına göre tersden sıralandı
                collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }

//---------------------------------------------------------------------------------------------------------
//task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<University> unv){
        return (int) unv. // int yazmak yerine method data tipini long da yapabiliriz ama memory'i yormak istemeyiz
                stream().
                filter(t->t.getBolum().contains("mat")). //bolumu mat olan unv. sectim
                count(); //secilen uni sayisini aldim
    }

//---------------------------------------------------------------------------------------------------------
//task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt enBykNot(List<University> unv){ //int yaptigimiz method data tipi
        return unv.                                                     //OptionalInt oldu cunku null deger gelebilecegi icin cte verdi
                stream().
                filter(t->t.getOgrcSayisi()>550).
                mapToInt(t->t.getNotOrt()). //mapToInt() kullandigimiz icin int degerler gelecek. int methodlari da geliyor
                max(); // mapToInt methoduyla geldi

    }

//---------------------------------------------------------------------------------------------------------
//task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt enKckNotOrt(List<University> unv) {
        return unv.
                stream().
                filter(t->t.getOgrcSayisi()<1050).
                mapToInt(t->t.getNotOrt()).
                min();
    }



}

