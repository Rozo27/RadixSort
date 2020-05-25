import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static ArrayList<Integer> RadixSort(ArrayList<Integer> a){
        ArrayList<Queue<Integer>> numbers=new ArrayList<>();
        for(int j=0;j<=9;j++){
            numbers.add(new ArrayDeque<Integer>());
        }
        for(int i=1;i<=4;i++){
            for(int k=0;k<=9;k++){
                for(int j=0;j<a.size();j++){
                    int cop=a.get(j);
                    switch (i){
                        case 1:cop=cop%10;
                            break;
                        case 2:cop=cop/10%10;
                            break;
                        case 3:cop=cop/100%10;
                            break;
                        case 4:cop=cop/1000;
                            break;
                    }
                    if(cop==k){
                        numbers.get(k).offer(a.get(j));
                    }
                }
            }
            ArrayList<Integer> b=new ArrayList<>();
            for(int j=0;j<=9;j++){
                while(numbers.get(j).isEmpty()==false){
                    b.add(numbers.get(j).poll());
                }
            }
            a=b;
        }
        return a;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(1000);a.add(4);a.add(25);a.add(319);a.add(88);a.add(51);a.add(3430);a.add(8471);a.add(701);a.add(1);
        a.add(2989);a.add(657);a.add(713);
        a=RadixSort(a);
        System.out.println(a.size());
        for(int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");

    }
}
