import java.util.ArrayList;
import java.util.Scanner;

public class CodeWord {
    class OverHead {
        final private int Size = 16;
        final private int checksumSize = 8;
        private ArrayList<Integer> checksum;

        private OverHead() {
            checksum = new ArrayList<Integer>();
        }

        public int getSize() {
            return Size;
        }

        public int getChecksumSize() {
            return checksumSize;
        }

        public ArrayList<Integer> getChecksum() {
            return checksum;
        }

        public void setChecksum(ArrayList<Integer> checksum) {
            this.checksum = checksum;
        }

    }
    
    private ArrayList<Integer> dataWord = new ArrayList<Integer>();
    private OverHead overHead;

    public CodeWord() {
        overHead = new OverHead();
        makeCodeWord();
    }

    private void makeCodeWord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");

        //add data
        for (int i = 0; i < overHead.Size; i++){
            System.out.print("Enter new bit: ");
            dataWord.add(sc.nextInt());
        }
        sc.close();
    }

    public ArrayList<Integer> getDataWord() {
        return dataWord;
    }

    public OverHead getOverHead() {
        return overHead;
    }

    public static void main(String[] args) {
       
    }
}
