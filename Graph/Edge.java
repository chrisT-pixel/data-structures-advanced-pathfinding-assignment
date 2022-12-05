package Graph;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents a path, or connection, between two nodes.
 * Originally created for Data Structures, SP2 2017.
 * Reworked for Data Structures Advanced, SP5 2022
 * @author James Baumeister
 * @author Daniel Ablett
 * @version 5.0
 */
public class Edge implements Serializable {
	private Node fromNode;
	private Node toNode;
	private double weight;
	
	/**
	 * @param node1
	 * @param node2
	 */
	public Edge(Node fromNode, Node toNode) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		weight = this.calculateWeight();
	}
	
	public Node getFromNode() {
		return fromNode;
	}
	
	public void setFromNode(Node node1) {
		this.fromNode = node1;
	}
	
	public Node getToNode() {
		return toNode;
	}
	
	public void setToNode(Node node2) {
		this.toNode = node2;
	}
	
	/**
	 * Calculates the weight of travel from one node to another,
	 * taking into account each node's elevation.
	 * The weight should be calculated as:
	 * w(e) = d(p1, p2) * |(e1 - e2)|
	 * where e1 is the elevation of the "from" node, and
	 * e2 is the elevation of the "to" node. d is a
	 * function that calculates the euclidean distance
	 * between two 2D points, p1 and p2.
	 */
	
	//w(e) = d(n1,p2) × (0.001+abs(e1 - e2))


	protected double calculateWeight() {
		
		//get elevations 
		double fromElevation = fromNode.getElevation();
		double toElevation = toNode.getElevation();
		double elevationDifference = toElevation - fromElevation;
		
		//get positions 
		Position fromPosition = fromNode.getPosition();
		Position toPosition = toNode.getPosition();
		double distance = fromPosition.distance(toPosition);
		
		double weight = distance * (0.001 + Math.abs(elevationDifference));
		return Math.abs(weight);
		
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "Edge{" +
				"fromNode=" + fromNode +
				", toNode=" + toNode +
				", weight=" + weight +
				'}';
	}
}
