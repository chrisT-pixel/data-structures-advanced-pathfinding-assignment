package Graph;

import java.io.Serializable;
import java.util.Objects;

/**
 * A 2D vector class for various mathematical operations.
 * Originally created for Data Structures, SP2 2017.
 * Reworked for Data Structures Advanced, SP5 2022
 * @author James Baumeister
 * @author Daniel Ablett
 * @version 1.1
 */
public class Position implements Serializable {
	
	private static final long serialVersionUID = -389063105557046178L;
	
	public double x;
	public double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calculates the euclidean distance between two 2D points.
	 * The formula is:
	 * d(p, q) = sqrt ( (qx - px)^2 + (qy - py)^2 )
	 * @param v2 The second point
	 * @return The distance between the points
	 */
	public double distance(Position v2) {
		
		double firstVal = v2.x - this.x;
		double secondVal = v2.y - this.y;
		
		double FirstValSquared = Math.pow(firstVal, 2);
		double SecondValSquared = Math.pow(secondVal, 2);
		
		double theDistance = Math.sqrt(FirstValSquared + SecondValSquared);
	
		return theDistance;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

	@Override
	public String toString() {
		return "Vector{" +
				"x = " + x +
				", y = " + y +
				'}';
	}
}
