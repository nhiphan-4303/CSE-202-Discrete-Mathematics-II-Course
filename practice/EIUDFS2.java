package practice;

import java.util.*;

public class EIUDFS2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Vertex[] graph = readGraph();
        dfs(graph[0]);
        System.out.println(sb);
    }

    public static void dfs(Vertex v) {
        v.visited = true;
        sb.append(v.id + " ");

        for (Vertex u : v.adjList) {
            if (!u.visited) {
                dfs(u);
            }
        }
    }

    public static Vertex[] readGraph() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            vertices[u].addAdjList(vertices[v]);
            vertices[v].addAdjList(vertices[u]);
        }

        for (Vertex v : vertices) {
            v.adjList.sort((a, b) -> a.id - b.id);
        }
        return vertices;
    }

    public static class Vertex {
        int id;
        boolean visited;
        ArrayList<Vertex> adjList = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addAdjList(Vertex v) {
            adjList.add(v);
        }
    }
}
