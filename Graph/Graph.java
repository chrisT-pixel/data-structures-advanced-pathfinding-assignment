package Graph;

import java.io.FileInputStream;
import GUI.GraphLoader;
import java.io.ObjectInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Represents a non-directional graph where each vertex
 * is a Node object. Connections between nodes are based
 * on the cartesian coordinate system.
 * @author James Baumeister on 30/4/17
 */
public class Graph {
	
	final int NUM_NODES = 100;
	
	/**
	 * Connects all nodes, building their E, W, S, N, NE, SE, NW, SW edges,
	 * in that order. The nodes should form a 10x10 square grid, and the array
	 * is such that every i'th node % 10 = 9 is a right edge.
	 * See the assignment specification for more information.
	 * @param nodes An array of Node objects to be connected
	 * @return An array of connected Node objects
	 */
	public void connectNodes(Node[] nodes) {
		
		
		
		for(int i = 0; i < NUM_NODES; i++) {
			
			//central nodes that need 8 edges
			if(i > 9 && i % 10 != 0 && i % 10 != 9 && i < 90) {
				
				Edge edge1 = new Edge(nodes[i], nodes[i + 1]); //E
				Edge edge2 = new Edge(nodes[i], nodes[i - 1]); //W
				Edge edge3 = new Edge(nodes[i], nodes[i + 10]); //S
				Edge edge4 = new Edge(nodes[i], nodes[i - 10]); //N
				Edge edge5 = new Edge(nodes[i], nodes[i - 9]); //NE
				Edge edge6 = new Edge(nodes[i], nodes[i + 11]); //SE
				Edge edge7 = new Edge(nodes[i], nodes[i - 11]); //NW
				Edge edge8 = new Edge(nodes[i], nodes[i + 9]); //SW
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge1);
				edges.add(edge2);
				edges.add(edge3);
				edges.add(edge4);
				edges.add(edge5);
				edges.add(edge6);
				edges.add(edge7);
				edges.add(edge8);
				nodes[i].setEdges(edges);
				
			}
			
			if(i == 0) { //top left node
				
				Edge edge1 = new Edge(nodes[i], nodes[i + 1]); //E
				Edge edge3 = new Edge(nodes[i], nodes[i + 10]); //S
				Edge edge6 = new Edge(nodes[i], nodes[i + 11]); //SE
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge1);
				edges.add(edge3);
				edges.add(edge6);
				nodes[i].setEdges(edges);
			
			}
			
			if(i == 9) { //top right node
				
				Edge edge2 = new Edge(nodes[i], nodes[i - 1]); //W
				Edge edge3 = new Edge(nodes[i], nodes[i + 10]); //S
				Edge edge8 = new Edge(nodes[i], nodes[i + 9]); //SW
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge2);
				edges.add(edge3);
				edges.add(edge8);
				nodes[i].setEdges(edges);
			
			}
			
			if(i == 90) { //bottom left node
				
				Edge edge1 = new Edge(nodes[i], nodes[i + 1]); //E
				Edge edge4 = new Edge(nodes[i], nodes[i - 10]); //N
				Edge edge5 = new Edge(nodes[i], nodes[i - 9]); //NE
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge1);
				edges.add(edge4);
				edges.add(edge5);
				nodes[i].setEdges(edges);
			
			}
			
			if(i == 99) { //bottom right node
				
				Edge edge2 = new Edge(nodes[i], nodes[i - 1]); //W
				Edge edge4 = new Edge(nodes[i], nodes[i - 10]); //N
				Edge edge7 = new Edge(nodes[i], nodes[i - 11]); //NW
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge2);
				edges.add(edge4);
				edges.add(edge7);
				nodes[i].setEdges(edges);
			
			}
			
			if(i > 0 && i < 9) { //top row - don't go north!
				
				Edge edge1 = new Edge(nodes[i], nodes[i + 1]); //E
				Edge edge2 = new Edge(nodes[i], nodes[i - 1]); //W
				Edge edge3 = new Edge(nodes[i], nodes[i + 10]); //S
				Edge edge6 = new Edge(nodes[i], nodes[i + 11]); //S
				Edge edge8 = new Edge(nodes[i], nodes[i + 9]); //SW
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge1);
				edges.add(edge2);
				edges.add(edge3);
				edges.add(edge6);
				edges.add(edge8);
				nodes[i].setEdges(edges);
				
			}
			
			if(i > 90 && i < 99) { //bottom row - don't go south!
				
				Edge edge1 = new Edge(nodes[i], nodes[i + 1]); //E
				Edge edge2 = new Edge(nodes[i], nodes[i - 1]); //W
				Edge edge4 = new Edge(nodes[i], nodes[i - 10]); //N
				Edge edge5 = new Edge(nodes[i], nodes[i - 9]); //NE
				Edge edge7 = new Edge(nodes[i], nodes[i - 11]); //NW
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge1);
				edges.add(edge2);
				edges.add(edge4);
				edges.add(edge5);
				edges.add(edge7);
				nodes[i].setEdges(edges);
				
			}
			
			if(i > 0 && i % 10 == 0 && i < 90) { //far left row - don't go west!
				
				Edge edge1 = new Edge(nodes[i], nodes[i + 1]); //E
				Edge edge3 = new Edge(nodes[i], nodes[i + 10]); //S
				Edge edge4 = new Edge(nodes[i], nodes[i - 10]); //N
				Edge edge5 = new Edge(nodes[i], nodes[i - 9]); //NE
				Edge edge6 = new Edge(nodes[i], nodes[i + 11]); //SE
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge1);
				edges.add(edge3);
				edges.add(edge4);
				edges.add(edge5);
				edges.add(edge6);
				nodes[i].setEdges(edges);
			
			}
			
			if(i > 9 && i % 10 == 9 && i < 90) { //far right row - don't go east!
				
				Edge edge2 = new Edge(nodes[i], nodes[i - 1]); //W
				Edge edge3 = new Edge(nodes[i], nodes[i + 10]); //S
				Edge edge4 = new Edge(nodes[i], nodes[i - 10]); //N
				Edge edge7 = new Edge(nodes[i], nodes[i - 11]); //NW
				Edge edge8 = new Edge(nodes[i], nodes[i + 9]); //SW
				ArrayList<Edge> edges = new ArrayList<Edge>();
			
				edges.add(edge2);
				edges.add(edge3);
				edges.add(edge4);
				edges.add(edge7);
				edges.add(edge8);
				nodes[i].setEdges(edges);
				
			}
			
			
		}
		
		
	}
	
	/**
	 * Performs a breadth-first search of the graph and returns the shortest
	 * path from one node to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	
	public Node[] breadthFirstSearch(Node start, Node target) {
		
		Queue<Node> theQueue = new ArrayDeque<>();
	
		var identified = new boolean[NUM_NODES];
		
		//all nodes are not identified at init
		for(int i = 0; i < NUM_NODES; i++) {
			identified[i] = false;
		}
		
		Node[] nodes = GUI.GraphLoader.getNodes();
		int startIndex = Arrays.asList(nodes).indexOf(start);
		
		//holds parents and predecessors
		Map<Node, Node> parentNodes = new HashMap<Node, Node>();
		
		identified[startIndex] = true;
	
		theQueue.add(start);
		
		while(!theQueue.isEmpty()) {
			
			Node current = theQueue.remove();
			
			ArrayList<Edge> edges = current.getEdges();
			
			//examine each neighbor node
			for(int i = 0; i < edges.size(); i++) {
				
				Edge theEdge = edges.get(i);
				Node neighbour = theEdge.getToNode();
				int neighbourIndex = Arrays.asList(nodes).indexOf(neighbour);
				
				if(identified[neighbourIndex] == false) {
					
					//node has now been identified 
					identified[neighbourIndex] = true;
					
					//add to parent, predecessor hashmap
					parentNodes.put(neighbour, current);
					
					theQueue.add(neighbour);
					
					if(current.equals(target)) {
					
						break; //target found 
					}
					
				}
				
				
			}
			
		}
		
		//construct path from parent, predecessor hashmap
		List<Node> shortestPath = new ArrayList<>();
	    Node node = target;
	    
	    while(node != null) {
	        shortestPath.add(node);
	        node = parentNodes.get(node);
	    }
	    
	    Collections.reverse(shortestPath);
	    
	    //convert path to array
	    Node[] shortestPathArr = new Node[shortestPath.size()];
	    shortestPathArr = shortestPath.toArray(shortestPathArr);
		
		return shortestPathArr;
		
	}
	
	/**
	 * Performs a depth-first search of the graph and returns the first-found
	 * path from one node to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	public Node[] depthFirstSearch(Node start, Node target) {
		
		//holds nodes that have already been explored 
		boolean visited[] = new boolean[NUM_NODES];
		
		//holds parent nodes and predecessors
		Map<Node, Node> parentNodes = new HashMap<Node, Node>();
		
		//init recursive call 
		return depthFirstSearch(start, target, visited, parentNodes);
		
	}
	
	private Node[] depthFirstSearch(Node current, Node target, boolean visited[], Map<Node, Node> parentNodes) {
		
		Node[] nodes = GUI.GraphLoader.getNodes();
		
		int currentIndex = Arrays.asList(nodes).indexOf(current);
		
		visited[currentIndex] = true;
		
		ArrayList<Edge> edges = current.getEdges();
		
		for(int i = 0; i < edges.size(); i++) {
			
			Edge theEdge = edges.get(i);
			Node neighbour = theEdge.getToNode();
			int neighbourIndex = Arrays.asList(nodes).indexOf(neighbour);
			
			if(visited[neighbourIndex] == false) {
				
				//add to parent, predecessor hashmap
				parentNodes.put(neighbour, current);
				
				//recursively perform DFS with nodes not yet explored
				depthFirstSearch(nodes[neighbourIndex], target, visited, parentNodes);
				
			}
			
			
		}
		
		//construct path from parent, predecessor hashmap
		List<Node> shortestPath = new ArrayList<>();
	    Node node = target;
	    
	    while(node != null) {
	        shortestPath.add(node);
	        node = parentNodes.get(node);
	    }
	    
	    Collections.reverse(shortestPath);
	    
	    //convert path to array
	    Node[] shortestPathArr = new Node[shortestPath.size()];
	    shortestPathArr = shortestPath.toArray(shortestPathArr);
		return shortestPathArr;
		
	}
		
	/**
	 * Performs a search of the graph using Dijkstra's algorithm, which takes into
	 * account the edge weight. It should return the least-costly path from one node
	 * to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	
	public Node[] dijkstrasSearch(Node start, Node target) {
		
		//represents to and from paths
		Map<Node, Node> cameFrom = new HashMap<Node, Node>(); 
		
		//node with a 'cost so far' value used to determine if it should be added to frontier and 
		//when it should be removed from frontier and explored
		Map<Node, Double> costSoFar = new HashMap<Node, Double>(); 
		
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(5, new Comparator<Node>() {
			
			public int compare(Node n1, Node n2) { //priority is based on lowest cost so far
		        
				double n1Cost = costSoFar.get(n1);
		        double n2Cost = costSoFar.get(n2);
		        
		        if (n1Cost > n2Cost) {
                    return 1;
		        }
		        
		        else {
		        	return -1;
		        }
		        
		    }
		});
		
		frontier.add(start); 
		cameFrom.put(start, null); // start node comes from nowhere
		costSoFar.put(start, 0.0); // start node has no cost so far
		
		while(!frontier.isEmpty()) {
			
			Node current = frontier.poll();
			
			if(current.equals(target)) {
				break; //goal found
			}
			
			ArrayList<Edge> edges = current.getEdges();
			
			for(int i = 0; i < edges.size(); i++) {
				
				Edge theEdge = edges.get(i);
				Node toNode = theEdge.getToNode();
				
				double newCost = costSoFar.get(current) + theEdge.calculateWeight();
				
				//add to frontier if not yet explored or node has lower total cost
				if(!costSoFar.containsKey(toNode) || newCost < costSoFar.get(toNode)) {
					
					costSoFar.put(toNode, newCost);
					frontier.add(toNode);
					
					cameFrom.put(toNode, current);
				
				}
			
			}
			
			
		
		}
		
		int i = 0; //init vars to construct path from came to/came from map
		int length = cameFrom.size();
		Node prev = null;
		
		ArrayList<Node> pathList = new ArrayList<Node>();
		
		for (Node n : cameFrom.keySet()) {
		    	
			if(n.equals(target)) { //follow bread crumb path back to start
				
				pathList.add(n);
				prev = cameFrom.get(target);
				
				while(i < length) {
					
					pathList.add(prev);
					prev = cameFrom.get(prev);
					
					if(prev.equals(start)) {
						pathList.add(prev);
						break; //start found - no further search required
					}
					
					i++;
					
				}
			}
			
			
		}
		
		
		Collections.reverse(pathList);
	    
	    Node[] shortestPathArr = new Node[pathList.size()];
	    shortestPathArr = pathList.toArray(shortestPathArr);
		return shortestPathArr;
		
	}
	
	
	
	/**
	 * Searches for an edge from the source node to the destination.
	 * @param source The source, or first, node
	 * @param destination The destination, or second, node
	 * @return The edge between the nodes, or null if not found
	 */
	public Edge getEdge(Node source, Node destination) {
		
		ArrayList<Edge> edges = source.getEdges();
		
		for(int i = 0; i < edges.size(); i++) {
			if(destination.equals(edges.get(i).getToNode())) {
				return edges.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * From an array of Node objects, this calculates the total cost of
	 * travelling from the first to last nodes.
	 * @param vertices An array of Node objects representing a path
	 * @return The total cost of travel
	 */
	public double calculateTotalWeight(Node[] vertices) {
		
		if(vertices[0].equals(vertices[vertices.length - 1])) {
			return 0.0;
		}
		
		double totalWeight = 0.0;
		double currentWeight = 0.0;

		for(int i = 0; i < vertices.length; i++) {
			
			ArrayList<Edge> edges = vertices[i].getEdges();
			
			Node nextNode = vertices[i + 1];
			
			for(int j = 0; j < edges.size(); j++) {
				
				if(edges.get(j).getToNode().equals(nextNode)) {
				
					currentWeight = edges.get(j).calculateWeight();
					totalWeight = totalWeight + currentWeight;
					
				}
			}
			
			if(i == vertices.length - 2) { //we have processed the last node so return 
				
				return totalWeight;
			
			}
			
		}
		
		return totalWeight; //this won't run - odd behavior - related to unit test set up?
	}




}
