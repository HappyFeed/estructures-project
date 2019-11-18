package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Graph<T> {

	public final static int NILL= 100;
	
    public class Node {
        public T value;
        public Map<Integer, Integer> edges;

        public Node(T value) {
            this.value = value;
            edges = new HashMap<>();
        }
        
        public T getValue() {
        	return value;
        }
    }

    public List<Node> nodes;

    public boolean directed;
    public int numNodes = 0;
    public int numEdges = 0;

    public Graph() {
        this(false);
    }

    public Graph(boolean directed) {
        nodes = new ArrayList<>();
        this.directed = directed;
    }

    public List<Node> getNodes(){
    	return nodes;
    }
    
    public void addNode(T value) {
    	int a= NILL;
    	for (int i = 0; i < a; i++) {
    		int v=(int) value;
			if(v==i) {
				nodes.add(i,new Node(value));
			}else {
				nodes.add(null);
			}
		}
        
    }

    public void connect(int i, int j, int weight) {
        nodes.get(i).edges.put(j, weight);
        if (!directed)
            nodes.get(j).edges.put(i, weight);
    }

    public class DijkstrasNode extends Node {
        int dist = -1;
        boolean visited = false;
        DijkstrasNode previous;

        public DijkstrasNode(T value) {
            super(value);
        }

        public DijkstrasNode(Node node) {
            super(node.value);
            this.edges = node.edges;
        }
    }

    public void processBFS(int source, BiConsumer<Node, Integer> consumer) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nodes.size()];
        q.add(source);
        while (!q.isEmpty()) {
            int id = q.poll();
            if (visited[id])
                continue;
            visited[id] = true;
            Node n = nodes.get(id);
            consumer.accept(n, id);
            for (int c: n.edges.keySet())
                q.add(c);
        }
    }

    public void processDFS(int source, BiConsumer<Node, Integer> consumer) {
        Stack<Integer> q = new Stack<>();
        boolean[] visited = new boolean[nodes.size()];
        q.push(source);
        while (!q.isEmpty()) {
            int id = q.pop();
            if (visited[id])
                continue;
            visited[id] = true;
            Node n = nodes.get(id);
            consumer.accept(n, id);
            for (int c: n.edges.keySet())
                q.add(c);
        }
    }

    public List<DijkstrasNode> dijkstras(int source) {
        List<DijkstrasNode> djk = nodes.stream().map(DijkstrasNode::new).collect(Collectors.toList());
        djk.get(source).dist = 0;
        PriorityQueue<DijkstrasNode> q = new PriorityQueue<>((i, j) -> i.dist - j.dist);
        q.add(djk.get(source));
        int visitCount = 0;
        while (!q.isEmpty() && visitCount < djk.size()) {
            DijkstrasNode n = q.poll();
            if (n.visited)
                continue;
            n.visited = true;
            visitCount++;
            for (int child : n.edges.keySet()) {
                DijkstrasNode cn = djk.get(child);
                if (!cn.visited && (cn.dist == -1 || n.dist + n.edges.get(child) < cn.dist)) {
                    if (cn.dist != -1)
                        q.remove(cn);
                    cn.dist = n.dist + n.edges.get(child);
                    cn.previous = n;
                    q.add(cn);
                }
            }
        }
        return djk;
    }
    
    public ArrayList<Node> vertex(){   	
    	ArrayList<Node> a= new ArrayList<Node>();
    	for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i)!=null) {
				a.add(nodes.get(i));
			}
		}
    	return a;
    }
    
    public void floydWarshall(){    
    	ArrayList<Node> a=vertex();
        int dist[][] = new int[a.size()][a.size()]; 
        int i, j, k; 
        for (i = 0; i < a.size(); i++) {
            for (j = 0; j < a.size(); j++) {        	
                int v= (int) a.get(j).getValue();
                if(i==j){
                	dist[i][j] =0;
                }else if(a.get(i).edges.containsKey(v)) {
                	dist[i][j] = a.get(i).edges.get(v);
                }else {
                	dist[i][j] =NILL;
                }
            }		    
        }

        for (k = 0; k < a.size(); k++) 
        { 
            for (i = 0; i <a.size(); i++) 
            { 
                for (j = 0; j <a.size(); j++) 
                { 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 

        printSolution(dist);
    }
    
    public void printSolution(int dist[][]) { 
    	ArrayList<Node> a=vertex();
        for (int i=0; i<a.size(); ++i) 
        { 
            for (int j=0; j<a.size(); ++j) 
            { 
                if (dist[i][j]==NILL) 
                    System.out.print("N"); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println();
        } 
    }
} 