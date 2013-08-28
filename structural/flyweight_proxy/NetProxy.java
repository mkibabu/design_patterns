// Purpose.  Proxy design pattern
// 1. Create a "wrapper" for a remote, or expensive, or sensitive target
// 2. Encapsulate the complexity/overhead of the target in the wrapper
// 3. The client deals with the wrapper
// 4. The wrapper delegates to the target
// 5. To support plug-compatibility of wrapper and target, create an interface

import java.io.*;   
import java.net.*;

interface SocketInterface {                // 5. To support plug-compatibility 
   String getMessage();                      //    between the wrapper and the
   void   sendMessage( String str );         //    target, create an interface
   void   dispose(); 
}

class NetProxy implements SocketInterface {  // 1. Create a "wrapper" for a
   private Socket         socket;            //    remote, or expensive, or
   private BufferedReader in;                //    sensitive target
   private PrintWriter    out;

   public NetProxy( String host, int port, boolean serverSide ) {
      try {
         if (serverSide) {
            ServerSocket server = new ServerSocket( port );
            socket = server.accept();           // 2. Encapsulate the complexi-
         } else                                 //    ty/overhead of the target
            socket = new Socket( host, port );  //    in the wrapper
         in  = new BufferedReader( new InputStreamReader(socket.getInputStream()));
         out = new PrintWriter( socket.getOutputStream(), true );
      } catch( IOException e ) { e.printStackTrace(); }
   }
   public String getMessage() {
      String str = null;
      try { str = in.readLine();
      } catch( IOException e ) { e.printStackTrace(); }
      return str;
   }
   public void sendMessage( String str ) {
      out.println( str );             // 4. The wrapper delegates to the target
   }
   public void dispose() {
      try { socket.close();
      } catch( IOException e ) { e.printStackTrace(); }
   }  
}

