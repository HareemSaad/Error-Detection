import java.util.ArrayList;

public class Medium {
    public static void carry(CodeWord cd) {
        System.out.println("--------medium---------");
        int Random = (int)(Math.random()*6);
        //System.out.println(Random);
        while (Random!=0) {
            int random_place = (int)(Math.random()*cd.getOverHead().getSize());
            //System.out.println(random_place);
            if(cd.getDataWord().get(random_place) == 0) {
                cd.getDataWord().set(random_place, 1);
            } else {
                cd.getDataWord().set(random_place, 0);
            }
            Random--;
        }
    }
    public static void main(String[] args) {
        ArrayList<Character> x = new ArrayList<>();
        x.add('a');
        x.add('b');
        x.add('c');
        x.set(2, 'd');
        System.out.println(x);

    }
}
