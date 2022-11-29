import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println(toplaTumu(5));
        System.out.println(ciftTopla(15));
        System.out.println(ilkXCiftTopla(15));
        System.out.println(toplaIlkXCift(15));
        System.out.println(ilkXpozitifTek(15));
        ikininIlkXKuvveti(3).
    }

//---------------------------------------------------------------------------------------------------------
//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x){
        int toplam = 0;
        for(int i = 0; i <= x; i++){
            toplam += i;
        }
        return toplam;
    }

    //functional
    public static int toplaTumu(int x){
        return IntStream.
                range(1,x+1). //1den xe kadar (x+1 dahil degil) degerler akisa alindi.
                sum(); // akistan gelen degerler toplandi.
    }

//---------------------------------------------------------------------------------------------------------
//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftTopla(int x){
        return IntStream.
                rangeClosed(1,x).
                filter(Lambda01::ciftBul).//1den xe kadar (x+1 dahil degil) degerler akisa alindi.
                sum(); // akistan gelen degerler toplandi.
    }

//---------------------------------------------------------------------------------------------------------
//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXCiftTopla(int x){
        return IntStream.
                rangeClosed(0,x*2).
                filter(Lambda01::ciftBul).
                sum();
    }

//2.yol
    public static int toplaIlkXCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2). //iterate ile dongu saglamis olduk
                // 2den baslar 2ser sonsuza kadar gider
                limit(x). //sonsuza kadar gitmesini onlemek icin sinir koyduk
                sum();
    }

//---------------------------------------------------------------------------------------------------------
//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXpozitifTek(int x) {
        return IntStream.
                iterate(1,t->t+2). //1 3 5.. tek sayilar urettik
                limit(x).
                sum();
    }

//---------------------------------------------------------------------------------------------------------
//TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvveti(int x){
        IntStream.
                iterate(2,t-> t*2).limit(). //2 4 8 16.. 2 nin kuvvetleri

    }
}
