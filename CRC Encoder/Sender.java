import java.util.ArrayList;

public class Sender{

    static void calculateCRC(CodeWord cd) {
        //define remainder arraylist
        ArrayList<Integer> rem = new ArrayList<>();
        //divide

        //update remainder in overhead
    }

    static void send(CodeWord cd) {
        calculateCRC(cd);
        System.out.println(cd.getDivident());
        Medium.carry(cd);
        System.out.println(cd.getDivident());
        Receiver.receive(cd);
    }
    public static void main(String[] args) {
        // CodeWord cd = new CodeWord();
        // send(cd);
        ArrayList<Integer> rem = new ArrayList<>();
        rem.add(1);
        rem.add(0);
        rem.add(0);
        rem.add(1);
        rem.add(1);

        String s = rem.toString();
        System.out.println(s);

    }

}