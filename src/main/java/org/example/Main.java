package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int V = 5; // количество вершин
        double minDensity = 0.2; // минимальная плотность
        double maxDensity = 0.8; // максимальная плотность

        RandomGraphGenerator graphGenerator = new RandomGraphGenerator();
        Graph<Integer> graph = graphGenerator.generateGraph(V, false, minDensity, maxDensity); // генерация неориентированного графа с случайной плотностью

        System.out.println("Граф:");
        for (int i = 0; i < V; i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            for (int neighbor : neighbors) {
// Вывод всех рёбер графа
                System.out.println(i + " - " + neighbor);
            }
        }

        System.out.println("\nОбход в глубину (DFS):");
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.depthFirstSearch(0);
        System.out.println();

// Тест методов класса Graph
        System.out.println("\nТестирование класса Graph:");
        Graph<Integer> testGraph = new Graph<>(4);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);
        testGraph.addEdge(1, 2);
        testGraph.addEdge(2, 3);

        System.out.println("Список смежности:");
        for (int i = 0; i < testGraph.getVerticesCount(); i++) {
            System.out.println(i + " -> " + testGraph.getNeighbors(i));
        }

        testGraph.removeEdge(1, 2);
        System.out.println("\nПосле удаления ребра (1, 2):");
        for (int i = 0; i < testGraph.getVerticesCount(); i++) {
            System.out.println(i + " -> " + testGraph.getNeighbors(i));
        }

// Тест метода generateGraph
        System.out.println("\nТестирование класса RandomGraphGenerator:");
        RandomGraphGenerator testGenerator = new RandomGraphGenerator();
        Graph<Integer> randomGraph = testGenerator.generateGraph(6, true, 0.5, 0.7); // генерируем случайный граф с плотностью между 0.5 и 0.7

        System.out.println("Случайно сгенерированный граф:");
        for (int i = 0; i < randomGraph.getVerticesCount(); i++) {
            List<Integer> neighbors = randomGraph.getNeighbors(i);
            for (int neighbor : neighbors) {
// Вывод всех рёбер случайно сгенерированного графа
                System.out.println(i + " - " + neighbor);
            }
        }
    }
}