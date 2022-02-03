import java.util.Arrays;
class Graph{
    int vertex;
    int [][]graph;
    Graph(int value){
        graph=new int[value][value];
        vertex=value;
    }
    void addEdge(int vertex1,int vertex2,int value){
        if (vertex1>=vertex ||vertex2>=vertex ){
            System.out.println("Vertex number is greater than total vertex");
        }
        graph[vertex1][vertex2]=value;
        graph[vertex2][vertex1]=value;
    }
    void addDirectedEdge(int vertex1,int vertex2,int value){
        graph[vertex1][vertex2]=value;
    }
    void displayGraph(){
        System.out.println(Arrays.deepToString(graph));
    }
}
public class GraphJava {
    public static void main(String []s){
        int totalVertex=5;
        Graph graph=new Graph(totalVertex);
        graph.addEdge(1,2,10);
        graph.addEdge(2,3,10);
        graph.addEdge(1,4,10);
        graph.addEdge(3,1,10);
        graph.addEdge(2,2,10);
        graph.displayGraph();
    }
}

