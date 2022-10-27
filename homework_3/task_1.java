package com.bean.knightcruise;

import java.util.Scanner;

public class KnightCruise2 {
    static final int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 }; 
    static final int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static final int N = 8;
    static int[][] chessboard = new int[N][N];

    static int wayOut(int x, int y) {
        int count = 0;
        int tx, ty, i;
        if (x < 0 || x > 7 || y < 0 || y > 7 || chessboard[x][y] != 0) {
            return 9;
        }
        for (i = 0; i < N; i++) {
            tx = x + dx[i];
            ty = y + dy[i];
            if (tx > -1 && tx < 8 && ty > -1 && ty < 8 && chessboard[tx][ty] == 0)
                count++;
        }
        return count;
    }

    static void sort(Direction[] next) {
        int i, j, index;
        Direction temp = null;
        for (i = 0; i < N; i++) {
            index = i;
            for (j = i + 1; j < N; j++) {
                if (next[index].wayOutNum > next[j].wayOutNum)
                    index = j;
            }
            if (i != index) {
                temp = next[i];
                next[i] = next[index];
                next[index] = temp;
            }
        }
    }

    static void move(int x, int y, int step) {
        int i, j;
        int tx, ty;
        if (step == N * N) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    System.out.printf("%3d", chessboard[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        Direction[] next = new Direction[N];

        for (i = 0; i < N; i++) {
            Direction temp = new Direction();
            temp.x = x + dx[i];
            temp.y = y + dy[i];
            next[i] = temp;
            next[i].wayOutNum = wayOut(temp.x, temp.y);
        }

        sort(next);

        for (i = 0; i < N; i++) {
            tx = next[i].x;
            ty = next[i].y;
            chessboard[tx][ty] = step;
            move(tx, ty, step + 1);
            chessboard[tx][ty] = 0;
        }
    }

    public static void main(String[] args) {
        int i, j;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                chessboard[i][j] = 0;
            }
        }
        System.out.println(«Введите координаты исходной позиции лошади (0-7):»);
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        chessboard[x][y] = 1;
        move(x, y, 2);
    }
}