import java.util.ArrayList;

public class Receiver{
    static int calcRow(CodeWord cd) {
        int x = cd.getOverHead().getOriginalSize() / cd.getColumnSize();
        if (cd.getOverHead().getOriginalSize() % cd.getColumnSize() == 0) {
            return x;
        }
        return x + 1;
    }
   
    static void receive(CodeWord cd) {
        int index = -1, count;
        int col = cd.getColumnSize();
        int row = calcRow(cd);
        ArrayList<Integer> newRP = new ArrayList<>();
        ArrayList<Integer> newCP = new ArrayList<>();
        ArrayList<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(cd.getDataWord());
        mergeList.addAll(cd.getOverHead().getExtraBits());
        int[][] matrix = new int[row][col];
        //set data in matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                index++;
                matrix[i][j] = mergeList.get(index);
            }
        }

        //vertical
        for (int i = 0; i < col; i++) {
            count = 0;
            for (int k = 0; k < row; k++) {
                if (matrix[k][i] == 1) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                newCP.add(0);
            } else {
                newCP.add(1);
            }
        }

        //horizontal
        for (int i = 0; i < row; i++) {
            count = 0;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j]==1) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                newRP.add(0);
            } else {
                newRP.add(1);
            }
        }

        //print
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("col parity: " + newCP);
        System.out.println("row parity: " + newRP);

        //check
        for (int i = 0; i < newCP.size(); i++) {
            if(newCP.get(i) != cd.getOverHead().getColParity().get(i)){
                System.out.println("error found");
                return; 
            }
        }
        for (int i = 0; i < newRP.size(); i++) {
            if(newRP.get(i) != cd.getOverHead().getRowParity().get(i)){
                System.out.println("error found");
                return; 
            }
        }
        System.out.println("packet is error free");
        return;
    }
}