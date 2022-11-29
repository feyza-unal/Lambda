import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
}
