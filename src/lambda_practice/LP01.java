package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LP01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        printAll(list);
    }
//---------------------------------------------------------------------------------------------------------
// S1:listi aralarinda bosluk birakarak yazdiriniz

    public static void printAll(List<Integer> list){
        list.stream().forEach(t->System.out.print(t + " "));
    }

//---------------------------------------------------------------------------------------------------------
    public static void print(int a){
        System.out.print(a+ " ");
    }

//---------------------------------------------------------------------------------------------------------
//S2: sadece negatif olanlari yazdir
    public static void negative(List<Integer> list){
        list.stream().filter(t->t<0).forEach(LP01::print);
    }

//---------------------------------------------------------------------------------------------------------
//S3: pozitif olanlardan yeni bir liste olustur
    public static void positive(List<Integer> list){
        list.stream().filter(t->t>0).forEach(LP01::print);
    }







}
