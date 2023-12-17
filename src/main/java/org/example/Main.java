package org.example;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int V = 5; // количество вершин
        double minDensity = 0.2; // минимальная плотность
        double maxDensity = 0.8; // максимальная плотность

        RandomGraphGenerator graphGenerator = new RandomGraphGenerator();
        Graph<Integer> graph = graphGenerator.generateGraph(V, false, minDensity, maxDensity); // генерация неориентированного графа с случайной плотностью

        System.out.println("Граф:");
        for (int i = 0; i < V; i++) {
            Iterator<Integer> neighborsIterator = graph.getNeighborsIterator(i);
            while (neighborsIterator.hasNext()) {
                int neighbor = neighborsIterator.next();
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
            Iterator<Integer> neighborsIterator = testGraph.getNeighborsIterator(i);
            System.out.print(i + " -> ");
            while (neighborsIterator.hasNext()) {
                System.out.print(neighborsIterator.next() + " ");
            }
            System.out.println();
        }

        testGraph.removeEdge(1, 2);
        System.out.println("\nПосле удаления ребра (1, 2):");
        for (int i = 0; i < testGraph.getVerticesCount(); i++) {
            Iterator<Integer> neighborsIterator = testGraph.getNeighborsIterator(i);
            System.out.print(i + " -> ");
            while (neighborsIterator.hasNext()) {
                System.out.print(neighborsIterator.next() + " ");
            }
            System.out.println();
        }

        // Тест метода generateGraph
        System.out.println("\nТестирование класса RandomGraphGenerator:");
        RandomGraphGenerator testGenerator = new RandomGraphGenerator();
        Graph<Integer> randomGraph = testGenerator.generateGraph(6, true, 0.5, 0.7); // генерируем случайный граф с плотностью между 0.5 и 0.7

        System.out.println("Случайно сгенерированный граф:");
        for (int i = 0; i < randomGraph.getVerticesCount(); i++) {
            Iterator<Integer> neighborsIterator = randomGraph.getNeighborsIterator(i);
            System.out.print(i + " -> ");
            while (neighborsIterator.hasNext()) {
                System.out.print(neighborsIterator.next() + " ");
            }
            System.out.println();
        }
    }
}
