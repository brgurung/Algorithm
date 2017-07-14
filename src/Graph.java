import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class Graph {

	enum VertexStatus
	{
		UNDISCOVERED,
		DISCOVERED,
		PROCESSED
	}

	private class Vertex
	{
		int index;
		char label;
		VertexStatus status;
		
		Vertex(int index, char label)
		{
			this.index = index;
			this.label = label;
			status = VertexStatus.UNDISCOVERED;
		}
	}


	private class Edge
	{
		Vertex adjVertex;
		int weight;
	}
	
	List<List<Edge>> adjList;
	List<Vertex> vertexList;
	Vertex[] parent;
	int numOfVertices;
	int numOfEdges;
	boolean direction;
	static final int MAX_VERTICES = 20;
	
	public Graph()
	{
		adjList = new ArrayList<>();
		vertexList = new ArrayList<>();
		parent = new Vertex[MAX_VERTICES];
		direction = false;
		numOfVertices = 0;
		numOfEdges = 0;
	}
	
	void addVertex(char label)
	{
		Vertex v = new Vertex(numOfVertices, label);
		vertexList.add(v);
		adjList.add(new LinkedList<Edge>());
		numOfVertices++;
	}
	
	void setDirection(boolean flag)
	{
		direction = flag;
	}
	
	void addEdge(int srcIndex, int destIndex)
	{
		Edge e = new Edge();
		
		e.adjVertex = vertexList.get(destIndex);
		adjList.get(srcIndex).add(e);
		numOfEdges++;
		
		if (direction == false)
		{
			Edge eRev = new Edge();
			eRev.adjVertex = vertexList.get(srcIndex);
			adjList.get(destIndex).add(eRev);
			numOfEdges++;
		}
		
	}
	
	void displayGraph()
	{
		for (Vertex v : vertexList)
		{
			System.out.printf("%nVertex - %c %n", v.label );
			System.out.printf("Links: ");
			for (Edge e : adjList.get(v.index))
			{
				System.out.printf("%c ->", e.adjVertex.label);
			}
		}
	}
	

/*
	void breadthFirstSearch()
	{
		Queue<Vertex> vertexQueue = new LinkedList<>();
		
		vertexQueue.offer(vertexList.get(0));
		
		while (!vertexQueue.isEmpty())
		{
			Vertex curVertex = vertexQueue.poll();
			
			if (curVertex.isProcessed == false)
			{
				curVertex.isProcessed = true;
				//System.out.println("Debug: Current Vertex: " + Character.toString(curVertex.label));
				List<Edge> curEdgeList = adjList.get(curVertex.index);
			
				for (Edge e : curEdgeList)
				{
					Vertex adjVertex = e.adjVertex;
					//System.out.println("Debug: Adjacent: " + Character.toString(adjVertex.label));
					if (adjVertex.isProcessed == false)
					{
						System.out.printf("%c%c%n", curVertex.label, adjVertex.label);
						//System.out.println("Pushing into queue: " + adjVertex.label);
						vertexQueue.offer(adjVertex);
					}
				}
			}
		}
	}
*/
	
	void breadthFirstSearch()
	{
		Queue<Vertex> vertexQueue = new LinkedList<>();
		
		vertexQueue.offer(vertexList.get(0));
		
		while (!vertexQueue.isEmpty())
		{
			Vertex curVertex = vertexQueue.poll();
			
			curVertex.status = VertexStatus.PROCESSED;
			//System.out.println("Debug: Current Vertex: " + Character.toString(curVertex.label));
			List<Edge> curEdgeList = adjList.get(curVertex.index);
			
			for (Edge e : curEdgeList)
			{
				Vertex adjVertex = e.adjVertex;
				//System.out.println("Debug: Adjacent: " + Character.toString(adjVertex.label));
				if (adjVertex.status == VertexStatus.UNDISCOVERED)
				{
					adjVertex.status = VertexStatus.DISCOVERED;
					//System.out.println("Pushing into queue: " + adjVertex.label);
					vertexQueue.offer(adjVertex);
					parent[adjVertex.index] = curVertex;
				}
				
				if (adjVertex.status != VertexStatus.PROCESSED)
				{
					System.out.printf("%c%c%n", curVertex.label, adjVertex.label);
					
				}
			}
		}
	}
	
	/*	
	void depthFirstSearch()
	{
		Deque<Vertex> vertexStack = new ArrayDeque<>();
		
		vertexStack.addFirst(vertexList.get(0));
		while (!vertexStack.isEmpty())
		{
			Vertex curVertex = vertexStack.peekFirst();
			List<Edge> edgeList = adjList.get(curVertex.index);
			boolean isAdjAllDone = true;

			for (Edge e: edgeList)
			{
				Vertex adjVertex = e.adjVertex;
				
				if (adjVertex.status == VertexStatus.UNDISCOVERED)
				{
					adjVertex.status = VertexStatus.DISCOVERED;
					vertexStack.addFirst(adjVertex);
					parent.set(adjVertex.index, curVertex);
					isAdjAllDone = false;
					break;
				}
			}
			
			if (isAdjAllDone == true)
			{
				curVertex.status = VertexStatus.PROCESSED;
				vertexStack.removeFirst();
			}

		}
	}
*/

    void depthFirstSearch(Vertex startVertex)
    {
		// early termination
	
    	//System.out.printf("%nVertex: %c%n", startVertex.label);
		startVertex.status = VertexStatus.DISCOVERED;
		
		List<Edge> edgeList = adjList.get(startVertex.index);
		
		for (Edge e : edgeList)
		{
			Vertex adjVertex = e.adjVertex;
			
			if (adjVertex.status == VertexStatus.UNDISCOVERED)
			{
				System.out.printf("%c%c%n", startVertex.label, adjVertex.label);
				parent[adjVertex.index] = startVertex;
				depthFirstSearch(adjVertex);
			}
			else if (adjVertex.status != VertexStatus.PROCESSED)
			{
				// process the edge
				//System.out.printf("%nEdge: %c %c%n", startVertex.label, adjVertex.label);
			}
		}
		
		// once all the outgoing edges are done for vertex
		startVertex.status = VertexStatus.PROCESSED;
    }

    boolean hasCycle(Vertex startVertex)
    {

    	boolean result = false;
    	startVertex.status = VertexStatus.DISCOVERED;
    	List<Edge> edgeList = adjList.get(startVertex.index);

    	for (Edge e: edgeList)
    	{
    		Vertex adjVertex = e.adjVertex;
    		if (adjVertex.status == VertexStatus.UNDISCOVERED)
    		{
    			parent[adjVertex.index] = startVertex;
    			result = hasCycle(adjVertex);
  			}
    		else
    		{
    			if (parent[adjVertex.index] != startVertex)
    			{
    				result = true;
    			}
    		}
    		
    		if (result == true)
    			break;
    	}
    	
    	return result;
    }

    boolean hasRouteUtil(int startIndex, int destIndex)
    {
    	boolean result = false;

    	Vertex v = vertexList.get(startIndex);
    
    	v.status = VertexStatus.DISCOVERED;

    	List<Edge> edgeList = adjList.get(startIndex);
    	
    	for (Edge e: edgeList)
    	{
    		Vertex adjVertex = e.adjVertex;
    		Vertex destVertex = vertexList.get(destIndex);
    		
    		//System.out.printf("%nadj: %c dest: %c%n", adjVertex.label, destVertex.label);
			if (adjVertex.label == destVertex.label)
			{
				//System.out.println("Found it!");
				result = true;
				break;
			}

    		if (adjVertex.status == VertexStatus.UNDISCOVERED)
    		{

  				result = hasRouteUtil(adjVertex.index, destVertex.index);
    		}
    	}

    	return result;
    }

    boolean hasRoute(int startIndex, int destIndex)
    {
    	if ((startIndex < 0) || (destIndex < 0))
    	{
    		return false;
    	}

        if ((vertexList.get(startIndex) == null) || (vertexList.get(destIndex) == null))
        {
        	return false;
        }

        return hasRouteUtil(startIndex, destIndex);
    }

    void resetGraph()
    {
    	for(Vertex v: vertexList)
    	{
    		v.status = VertexStatus.UNDISCOVERED;
    	}
    	
    	Arrays.fill(parent, null);
   	
    }
    
    public static void main(String[] args)
	{
		Graph myGraph = new Graph();
		
		myGraph.addVertex('A');
		myGraph.addVertex('B');
		myGraph.addVertex('C');
		myGraph.addVertex('D');
		myGraph.addVertex('E');
		myGraph.addVertex('F');
		myGraph.addVertex('G');
		myGraph.addVertex('H');

		myGraph.setDirection(true);

		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 2);
		myGraph.addEdge(0, 5);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(1, 3);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(1, 5);
		myGraph.addEdge(2, 4);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(3, 5);
		myGraph.addEdge(5, 6);
		myGraph.addEdge(7, 6);
		
		myGraph.displayGraph();
		

		System.out.printf("%nHas Route from A to H: %b %n%n", myGraph.hasRoute(0, 7));
		System.out.printf("%nHas Route from A to F: %b %n%n", myGraph.hasRoute(0, 5));
		
		System.out.printf("%n%n");
		System.out.println("BFS output: ");
		myGraph.breadthFirstSearch();
		
		
		myGraph.resetGraph();

		System.out.println("DFS output: ");
		myGraph.depthFirstSearch(myGraph.vertexList.get(0));
		
		System.out.printf("%n%n");
		myGraph.resetGraph();
		boolean result = myGraph.hasCycle(myGraph.vertexList.get(0));
		System.out.println("Has Cycle: " + result);
	}
}
