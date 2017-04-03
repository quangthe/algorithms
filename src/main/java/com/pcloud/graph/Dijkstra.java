package com.pcloud.graph;

import java.util.Arrays;

/**
 * Implement Dijkstra algorithm.
 */
public class Dijkstra {
    private int numberOfVertices;
    private int[][] graph;
    private boolean[] availableVertices;
    private int[] distances;

    private int startVertice;
    private int finishVertice;

    private int[] traces;

    private static final int MAXC = 1000000000;

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.init();
        dijkstra.run();
        dijkstra.output();
    }

    public void init() {
        int numberOfEdges = 8;
        int[] edge_from   = new int[]{0, 1, 1, 2, 2, 5, 4, 1};
        int[] edge_to     = new int[]{1, 2, 5, 3, 5, 4, 3, 5};
        int[] edge_weight = new int[]{1, 2, 20, 20, 3, 4, 5, 4};

        numberOfVertices = 6;
        startVertice = 0;
        finishVertice = 3;

        graph = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = MAXC;
                }
            }
        }

        distances = new int[numberOfVertices];
        Arrays.fill(distances, MAXC);
        // min distance from s to s is zero
        distances[startVertice] = 0;

        availableVertices = new boolean[numberOfEdges];
        // all vertice are available
        Arrays.fill(availableVertices, true);

        traces = new int[numberOfVertices];

        for (int i = 0; i < numberOfEdges; i++) {
            int startV = edge_from[i];
            int finishV = edge_to[i];
            graph[startV][finishV] = edge_weight[i];
        }
    }

    public void run() {
        while (true) {
            int u = chooseMinVertice();

            // stop finding if all vertices are fixed or found finishVertice
            if (u == -1 || u == finishVertice) break;

            // fix u
            availableVertices[u] = false;

            // optimize v
            for (int v = 0; v < numberOfVertices; v++) {
                // if still optimize v
                if (availableVertices[v] && distances[v] > distances[u] + graph[u][v]) {
                    distances[v] = distances[u] + graph[u][v];

                    // trace route
                    // from u can go to v (or u is parent of v)
                    traces[v] = u;
                }
            }
        }
    }

    private int chooseMinVertice() {
        int minC = MAXC;
        int u = -1;

        for (int i = 0; i < numberOfVertices; i++) {
            if (availableVertices[i] && distances[i] < minC) {
                minC = distances[i];
                u = i;
            }
        }
        return u;
    }

    private void output() {
        if (distances[finishVertice] == MAXC) {
            System.out.println("Route not found");
            return;
        }
        System.out.printf("Route: ");
        int f = finishVertice;
        int s = startVertice;
        while (f != s) {
            System.out.printf("%d <- ", f);
            f = traces[f];
        }
        System.out.printf(" %d\n", s);
        System.out.printf("Cost: %d", distances[finishVertice]);
    }
}
