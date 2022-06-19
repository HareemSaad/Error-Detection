import java.util.ArrayList;
import java.util.Scanner;

public class CodeWord {
    class OverHead {
        private int originalSize;
        private ArrayList<Integer> extraBits;
        private int extraBitsSize;
        private ArrayList<Integer> rowParity;
        private ArrayList<Integer> colParity;

        private OverHead(ArrayList<Integer> data, int columnSize) {
            originalSize = data.size();
            extraBits = new ArrayList<Integer>();
            rowParity = new ArrayList<Integer>();
            colParity = new ArrayList<Integer>();
            extraBitsSize = calculateExtraBitSize(this.originalSize, columnSize);
            addExtraBits();
        }

        public ArrayList<Integer> getRowParity() {
            return rowParity;
        }

        public void setRowParity(ArrayList<Integer> rowParity) {
            this.rowParity = rowParity;
        }

        public ArrayList<Integer> getColParity() {
            return colParity;
        }

        public void setColParity(ArrayList<Integer> colParity) {
            this.colParity = colParity;
        }

        public int getOriginalSize() {
            return originalSize;
        }

        public void setOriginalSize(int originalSize) {
            this.originalSize = originalSize;
        }

        public ArrayList<Integer> getExtraBits() {
            return extraBits;
        }

        public void setExtraBits(ArrayList<Integer> extraBits) {
            this.extraBits = extraBits;
        }

        public int getExtraBitsSize() {
            return extraBitsSize;
        }

        public void setExtraBitsSize(int extraBitsSize) {
            this.extraBitsSize = extraBitsSize;
        }

        private int calculateExtraBitSize(int dataSize, int columnSize) {
            int x = 0;
            if(dataSize % columnSize != 0) {
                while (true){
                    if(dataSize % columnSize == 0) {
                        break;
                    }
                    dataSize++;
                    x++;
                }
                //x = columnSize - x;
            }
            return x;
        }
    
        private void addExtraBits() {
            if (originalSize % columnSize != 0) {
                Scanner s = new Scanner(System.in);
                for (int i = 0; i < extraBitsSize; i++) {
                    System.out.print("Enter Extra Bit: ");
                    extraBits.add(s.nextInt());
                }
                s.close();
            }

            return;
        }
    }
    
    private final int columnSize = 5;
    private ArrayList<Integer> dataWord = new ArrayList<Integer>();
    private OverHead overHead;

    public CodeWord() {
        makeCodeWord();
    }

    private void makeCodeWord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bit size: ");
        int size = sc.nextInt();

        //add data
        for (int i = 0; i < size; i++){
            System.out.print("Enter new bit: ");
            dataWord.add(sc.nextInt());
        }
        overHead = new OverHead(dataWord, columnSize);
        sc.close();
    }

    public int getColumnSize() {
        return columnSize;
    }

    public ArrayList<Integer> getDataWord() {
        return dataWord;
    }

    public OverHead getOverHead() {
        return overHead;
    }

    public static void main(String[] args) {
        CodeWord cd1 = new CodeWord();
        for (int i = 0; i < cd1.overHead.getOriginalSize(); i++) {
            System.out.print(cd1.dataWord.get(i) + " "); 
        }
        for (int i = 0; i < cd1.overHead.extraBitsSize; i++) {
            System.out.print(cd1.overHead.getExtraBits().get(i) + " "); 
        }
    }
}
