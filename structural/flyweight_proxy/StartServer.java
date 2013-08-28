/*
 * This file contains the main function to start the network server.
 * The network server enters an infinite loop and handles any network
 * requests that are sent to it.
 */

public class StartServer
{
	public static void main(String[] args)
	{
		ServerNetworkServer server = new ServerNetworkServer();
		server.start(new Server());
	}
}
