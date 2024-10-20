import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Graph lot = new Graph();

        // Add nodes (Locations)
        lot.addNode("LotA");
        lot.addNode("MainRoad1");
        lot.addNode("Entrance1");

        lot.addNode("LotB");
        lot.addNode("MainRoad2");
        lot.addNode("Entrance2");

        lot.addNode("EventVenue");

        // Add edges (roads between nodes, with weigh signifying if they are busy/far away from exit)
        lot.addEdge("MainRoad1", "Entrance1", 10);
        lot.addEdge("MainRoad2", "Entrance2", 10);
        lot.addEdge("MainRoad1", "Entrance2", 30);
        lot.addEdge("MainRoad2", "Entrance2", 35);

        lot.addEdge("LotA", "LotB", 5);
        lot.addEdge("LotB", "LotA", 5);

        lot.addEdge("Entrance1", "LotA", 5);
        lot.addEdge("Entrance2", "LotB", 5);
        lot.addEdge("Entrance1", "EventVenue", 25);
        lot.addEdge("Entrance2", "EventVenue", 30);

        lot.addEdge("LotA", "EventVenue", 5);
        lot.addEdge("LotB", "EventVenue", 5);

        lot.addEdge("LotA", "Entrance1", 5);
        lot.addEdge("LotB", "Entrance2", 5);

        DjikstraAlgo djikstra = new DjikstraAlgo();
        Node startNode = lot.getNode("LotA");

        if (startNode == null) {
            System.out.println("Start Node NULL | Check graph initalizaiton.");
        } else {
            // Calculate the shortest paths from LotA
            Map<Node, Integer> distances = djikstra.calculateShortestPath(lot, startNode);

            // Print the distances
            for (Map.Entry<Node, Integer> entry : distances.entrySet()) {
                if (entry.getValue() > 2000) {
                    entry.setValue(0);
                }
                System.out.println("Distance from LotA to " + entry.getKey().getName() + ": " + entry.getValue());
            }
        }
    }
}
