package com.pcloud.backtrack;

import java.util.HashMap;
import java.util.Map;

/**
 * Xét bàn cờ có kích thước tổng quát nxn. Một quân hậu có thể ăn được các quân khác nằm trên ô cùng hàng cùng cột hoặc cùng đường chéo.
 * Hãy tìm cách sếp các quân hậu vào bàn cờ sao cho không có quân nào ăn quân nào.
 */
public class QueenProblem {
    /**
     *        N
     *  W           E
     *        S
     */

    private int N;
    /**
     * cols[i] = true néu cột i còn tự do.
     */
    private boolean[] cols;

    /**
     * row + col = Const. rPc.get(i) = true nếu đường chéo NE-SW còn tự do.
     */
    private Map<Integer, Boolean> rPc = new HashMap<Integer, Boolean>();

    /**
     * row - col = Const. rMc.get(i) = true nếu đường chéo NW-SE còn tự do.
     */
    private Map<Integer, Boolean> rMc = new HashMap<Integer, Boolean>();

    private int[] results;


    public static void main(String[] args) {
        QueenProblem p = new QueenProblem();
        p.solve(8);
    }

    private void init(int n) {
        this.N = n;
        cols = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            cols[i] = true;
        }
        for (int i = 2; i <= 2 * N; i++) {
            rPc.put(i, Boolean.TRUE);
        }
        for (int i = 1-N; i <= N-1; i++) {
            rMc.put(i, Boolean.TRUE);
        }

        results = new int[N + 1];
    }

    public void solve(int n) {
        init(n);
        tryPutRow(1);
    }

    private void tryPutRow(int row) {
        for (int col = 1; col <= N; col++) {
            if (cols[col] && rPc.get(row + col) && rMc.get(row - col)) {
                // Thử đặt quân hậu vào hàng row cột col
                results[row] = col;

                if (row == N) {
                    // print result
                    printResult();
                } else {
                    // Mark col, 2 diagonal lines
                    cols[col] = false;
                    rPc.put(row + col, Boolean.FALSE);
                    rMc.put(row - col, Boolean.FALSE);

                    tryPutRow(row + 1); // Try put next row

                    // Unmark col, 2 diagonal lines
                    cols[col] = true;
                    rPc.put(row + col, Boolean.TRUE);
                    rMc.put(row - col, Boolean.TRUE);
                }
            }
        }
    }

    private void printResult() {
        for (int row = 1; row <= N; row++) {
            System.out.printf("(%d, %d);", row, results[row]);
        }
        System.out.println();
    }
}
