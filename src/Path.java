

public class Path {
	int startingPointIndex;
	int[] visitOrder;
	float distance;
	
	public Path(int startingPointIndex, int[] visitOrder, float distance) {
		this.startingPointIndex = startingPointIndex;
		this.visitOrder = visitOrder;
		this.distance = distance;
	}
	
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Path)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Path p = (Path) o; 
          
        // Compare the data members and return accordingly  
        return (this.startingPointIndex == p.startingPointIndex  &&  this.distance == p.distance);
    } 
	
	public int getStartingPointIndex() {
		return startingPointIndex;
	}

	public int[] getVisitOrder() {
		return visitOrder;
	}

	public float getDistance() {
		return distance;
	}
	
	
}
