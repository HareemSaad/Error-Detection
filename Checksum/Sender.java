import java.util.ArrayList;

public class Sender{

    static void calculateChecksum(CodeWord cd) {
        System.out.println("--------checksum---------");
        int size = cd.getOverHead().getChecksumSize();
        int carry = 0, sum = 0;
        String sums = "";
        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        ArrayList<Integer> s1 = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < size; i++) {
            index++;
            p1.add(cd.getDataWord().get(index));
        }
        for (int i = 0; i < size; i++) {
            index++;
            p2.add(cd.getDataWord().get(index));
        }
        //System.out.println("p1: " + p1);
        //System.out.println("p2: " + p2);

        for (int i = size-1; i >=0 ; i--) {
            sums = Integer.toBinaryString(p1.get(i) + p2.get(i) + carry);
            if (sums.length() == 1) {
                sum = sums.charAt(0);
                sum = sum - 48;
                carry = 0;
            } else {
                //System.out.println(sums);
                carry = sums.charAt(0);
                carry = carry - 48;
                sum = sums.charAt(1);
                sum = sum - 48;
            }
            s1.add(sum);
        }
        //System.out.println("s1: " + s1);
        while (carry!=0) {
            for (int j = 0; j < size ; j++) {
                sums = Integer.toBinaryString(s1.get(j) + carry);
                if (sums.length() == 1) {
                    sum = sums.charAt(0);
                    sum = sum - 48;
                    carry = 0;
                } else {
                    //System.out.println(sums);
                    carry = sums.charAt(0);
                    carry = carry - 48;
                    sum = sums.charAt(1);
                    sum = sum - 48;
                }
                //System.out.println(sum);
                s1.set(j, sum);
            }
        }
        //System.out.println("s1: " + s1);
        for (int i = 0; i < size; i++) {
            if (s1.get(i)==0) {
                cd.getOverHead().getChecksum().add(1);
            } else {
                cd.getOverHead().getChecksum().add(0);
            }
        }
    }

    static void send(CodeWord cd) {
        calculateChecksum(cd);
        System.out.println(cd.getDataWord());
        Medium.carry(cd);
        System.out.println(cd.getDataWord());
        Receiver.receive(cd);
    }
    public static void main(String[] args) {
        // String sums = Integer.toBinaryString(1 + 0 + 0);
        // System.out.println(sums);
        CodeWord cd = new CodeWord();    
        send(cd);
        //send(cd);
    }

}