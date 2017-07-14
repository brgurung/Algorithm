import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

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
	}
	
	List<List<Edge>> adjList;
	List<Vertex> vertexList;
	Vertex[] parent;
	int numOfVertices;
	boolean direction;
	
	public TopologicalSort()
	{
		adjList = new ArrayList<>();
		vertexList = new ArrayList<>();
		direction = true;
		numOfVertices = 0;
	}
	
	void addVertex(char label)
	{
		Vertex v = new Vertex(numOfVertices, label);
		vertexList.add(v);
		adjList.add(new LinkedList<Edge>());
		numOfVertices++;
	}
	
	void addEdge(int srcIndex, int destIndex)
	{
		Edge e = new Edge();
		
		e.adjVertex = vertexList.get(destIndex);
		adjList.get(srcIndex).add(e);
	}

	///////////////////////////////////////////////////////////////////////////
	// Project Dependencies
	
	boolean getDepChainUtil(Vertex startVertex, List<Vertex> depList)
	{
		if (startVertex == null)
		{
			return true;
		}
		
		List<Edge> edgeList = adjList.get(startVertex.index);
		startVertex.status = VertexStatus.DISCOVERED;
		
		for (Edge e : edgeList)
		{
			Vertex adjVertex = e.adjVertex;
			
			// if already in discovered state, there must be a cycle
			if (adjVertex.status == VertexStatus.DISCOVERED)
			{
				return false;
			} 
			else if (adjVertex.status == VertexStatus.UNDISCOVERED)
			{
				boolean retVal = getDepChainUtil(adjVertex, depList);
				if (retVal == false)
				{
					return false;
				}
			}
				
		}
		
		depList.add(startVertex);
		startVertex.status = VertexStatus.PROCESSED;
		
		return true;
	}

	List<Vertex> getDepChain()
	{
		if (numOfVertices <= 0)
		{
			return null;
		}
		
		List<Vertex> depList = new ArrayList<>();

		for (int i = 0; i < numOfVertices; i++)
		{
			Vertex v = vertexList.get(i);
			
			if (v.status != VertexStatus.PROCESSED)
			{
				boolean retVal = getDepChainUtil(v, depList);
				if (retVal == false)
				{
					return null;
				}
			}
		}
		
		return depList;
	}
	////////////////////////////////////////////////////////////////////////
	
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
	
	
    public static void main(String[] args)
	{
		TopologicalSort myGraph = new TopologicalSort();
		
		myGraph.addVertex('A');
		myGraph.addVertex('B');
		myGraph.addVertex('C');
		myGraph.addVertex('D');
		myGraph.addVertex('E');
		myGraph.addVertex('F');

		myGraph.addEdge(3, 0);
		myGraph.addEdge(1, 5);
		myGraph.addEdge(3, 1);
		myGraph.addEdge(0, 5);
		myGraph.addEdge(2, 3);
		
		myGraph.displayGraph();
		
		List<Vertex> depList = myGraph.getDepChain();
		
		System.out.println("Dependency List: ");
		for (Vertex v : depList)
		{
			System.out.printf("%c ", v.label);
		}
		
	}
}
