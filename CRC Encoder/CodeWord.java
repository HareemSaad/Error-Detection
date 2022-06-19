import java.util.ArrayList;
import java.util.Scanner;

public class CodeWord {
    class OverHead {
        private final int dividentSize = 4;
        private final int divisorSize = 4;
        private ArrayList<Integer> remainder;
        private ArrayList<Integer> divisor;
        private final int remainderSize = 3;

        private OverHead() {
            remainder = new ArrayList<Integer>();
            divisor = new ArrayList<Integer>();
        }

        public int getDividentSize() {
            return dividentSize;
        }

        public int getDivisorSize() {
            return divisorSize;
        }

        public ArrayList<Integer> getRemainder() {
            return remainder;
        }

        public void setRemainder(ArrayList<Integer> remainder) {
            this.remainder = remainder;
        }

        public ArrayList<Integer> getDivisor() {
            return divisor;
        }

        public void setDivisor(ArrayList<Integer> divisor) {
            this.divisor = divisor;
        }

        public int getRemainderSize() {
            return remainderSize;
        }
    }
    
    private ArrayList<Integer> divident = new ArrayList<Integer>();
    private OverHead overHead;

    public CodeWord() {
        overHead = new OverHead();
        makeCodeWord();
    }

    private void makeCodeWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter divident");

        //add data
        for (int i = 0; i < overHead.dividentSize; i++){
            System.out.print("Enter new bit: ");
            divident.add(sc.nextInt());
        }
        System.out.println("Enter divisor");
        for (int i = 0; i < overHead.divisorSize; i++) {
            System.out.print("Enter new bit: ");
            overHead.getDivisor().add(sc.nextInt());
        }
        for (int i = 0; i < overHead.remainderSize; i++) {
            overHead.getRemainder().add(0);
        }
        divident.addAll(overHead.getRemainder());

        sc.close();
    }

    public ArrayList<Integer> getDivident() {
        return divident;
    }

    public OverHead getOverHead() {
        return overHead;
    }

    public static void main(String[] args) {
        CodeWord cd = new CodeWord();
        System.out.println(cd.divident);
        System.out.println(cd.overHead.divisor);
        System.out.println(cd.overHead.remainder);

    }
}
