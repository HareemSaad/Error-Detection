import java.util.ArrayList;

public class Sender{

    static int calcRow(CodeWord cd) {
        int x = cd.getOverHead().getOriginalSize() / cd.getColumnSize();
        if (cd.getOverHead().getOriginalSize() % cd.getColumnSize() == 0) {
            return x;
        }
        return x + 1;
    }
   
    static void calculateParity(CodeWord cd) {
        int index = -1, count;
        int col = cd.getColumnSize() + 1;
        int row = calcRow(cd) + 1;
        ArrayList<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(cd.getDataWord());
        mergeList.addAll(cd.getOverHead().getExtraBits());
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (i == row - 1) {
                continue;
            }
            for (int j = 0; j < col; j++) {
                if (j == col-1){
                    continue;
                }
                index++;
                matrix[i][j] = mergeList.get(index);
            }
        }

        //vertical
        for (int i = 0; i < col; i++) {
            count = 0;
            for (int k = 0; k < row; k++) {
                if (k == row - 1) {
                    if (count % 2 == 0) {
                        matrix[k][i] = 0;
                    } else {
                        matrix[k][i] = 1;
                    }
                    continue;
                }
                if (matrix[k][i] == 1) {
                    count++;
                }
            }
        }

        //horizontal
        for (int i = 0; i < row; i++) {
            count = 0;
            for (int j = 0; j < col; j++) {
                if (j == col - 1) {
                    if (count % 2 == 0) {
                        matrix[i][j] = 0;
                    } else {
                        matrix[i][j] = 1;
                    }
                    continue;
                }
                if (matrix[i][j]==1) {
                    count++;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        //submit row and col paraties in overhead
        for (int i = 0; i < row; i++) {
            cd.getOverHead().getRowParity().add(matrix[i][col - 1]);
        }
        for (int i = 0; i < col; i++) {
            cd.getOverHead().getColParity().add(matrix[row - 1][i]);
        }
        return;
    }

    static void send(CodeWord cd) {
        calculateParity(cd);
        System.out.println(cd.getDataWord());
        Medium.carry(cd);
        System.out.println(cd.getDataWord());
        Receiver.receive(cd);
    }
    public static void main(String[] args) {
        CodeWord cd = new CodeWord();
        send(cd);
    }

}