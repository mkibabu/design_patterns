import java.util.Hashtable;

/*
 * The interface that each server object should use.
 */
interface ServerInterface
{
	/*
	 * Compute the squared result of the provided argument.
	 * This corresponds to the right-mouse click.
	 */
	int computeSquare(int num);
	
	/*
	 * Compute the Euclidean distance between the provided 2D point
	 * and the point (0, 0).
	 * This corresponds to the left-mouse click.
	 */
	double computeDistance(int x, int y);
}

/*
 * This server proxy caches previous answers to the computeSquare function
 * so that any matching requests in the future can be immediately returned
 * (as opposed to re-querying the network).
 */
class ServerProxy implements ServerInterface
{
	/*
	 * The hastable used to store the previous answers.
	 */
	private static Hashtable<Integer, Integer> squareHashtable =
		new Hashtable<Integer, Integer>();
	
	private ServerInterface server = new ClientNetworkServer();
	
	/*
	 * Check to see if the answer has already been computed and stored.
	 * If it is, return it. Otherwise, send a request over the network.
	 */
	public int computeSquare(int num)
	{
		if (squareHashtable.containsKey(num))
		{
			System.out.println("computeSquare: cached");
			return squareHashtable.get(num); // return an existing object
		}
		System.out.println("computeSquare: network");
		int answer = server.computeSquare(num);
		squareHashtable.put(num, answer);
		return answer;
	}
	
	/*
	 * Send a request over the network to compute the distance.
	 */
	public double computeDistance(int x, int y)
	{
		System.out.println("computeDistance: network");
		return server.computeDistance(x, y);
	}
}

/*
 * This class exposes the ServerInterface but wraps up a NetProxy to
 * use a network for communication.
 */
class ClientNetworkServer implements ServerInterface
{
	private NetProxy net = new NetProxy("152.23.57.202", 9876, false); // false means client side	
	
	public int computeSquare(int num)
	{
		net.sendMessage("computeSquare");
		net.sendMessage(Integer.toString(num));
		return Integer.parseInt(net.getMessage());
	}
	
	public double computeDistance(int x, int y)
	{
		net.sendMessage("computeDistance");
		net.sendMessage(Integer.toString(x));
		net.sendMessage(Integer.toString(y));
		return Double.parseDouble(net.getMessage());
	}
}

/*
 * This class is responsible for receiving network requests over the network.
 * It wraps up a NetProxy object, and passes any requests to a provided
 * ServerInterface object.
 */
class ServerNetworkServer
{
	public void start(ServerInterface srv) 
	{
		NetProxy net = new NetProxy("152.23.57.202", 9876, true);// true means server side
		String method, param, param2;
		while(true)
		{
			method = net.getMessage();
			if (method.equals("computeSquare"))
			{
				param = net.getMessage();
				int label = Integer.parseInt(param);
				System.out.println("  server asked to compute square... "+param);
				net.sendMessage(Integer.toString(srv.computeSquare(label))); 
			}
			else if (method.equals("computeDistance"))
			{
				param = net.getMessage();
				param2 = net.getMessage();
				int x = Integer.parseInt(param);
				int y = Integer.parseInt(param2);
				System.out.println("  server asked to compute distance... "+param+" "+param2);
				net.sendMessage(Double.toString(srv.computeDistance(x, y)));
			 }
		 }
	}
}

/*
 * This class exposes the ServerInterface and is actually responsible for
 * computing the values of the functions.
 */
public class Server implements ServerInterface
{  
	public int computeSquare(int num)
	{
		return num * num;
	}
	
	public double computeDistance(int x, int y)
	{
		return Math.sqrt(x * x + y * y);
	}
}
