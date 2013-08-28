import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

class ButtonFactory
{
	private static Hashtable<String, Button> buttonHashtable =
		new Hashtable<String, Button>();
	private static ButtonListener buttonListener = new ButtonListener();
	
	public static Button makeButton(String num)
	{
		if (buttonHashtable.containsValue(num))
		{
			System.out.println("Button in cache");
			return (Button)buttonHashtable.get(num); // return an existing object
		}
		Button button = new Button(num);
		button.addMouseListener(buttonListener);
		buttonHashtable.put(num, button);
		return button;
	}
	
	public static void report()
	{
		System.out.print("size = " + buttonHashtable.size() + "	");
		for (java.util.Enumeration<String> e = buttonHashtable.keys(); e.hasMoreElements(); )
		{
			System.out.print(e.nextElement() + " ");
		}
		System.out.println();
	}  
}

class ButtonListener extends MouseAdapter
{
	private ServerProxy server = new ServerProxy();
	
	public void mouseClicked(MouseEvent e) 
	{
		Button button  = (Button) e.getSource();
		Component[] buttons = button.getParent().getComponents(); // frame returned by getParent()
 
		int i = 0;
		for ( ; i < buttons.length; i++)
		{
			if (button == buttons[i])
			{
		  	 break;
			}
		}
		
		// left click
		if (e.getModifiers() == InputEvent.BUTTON1_MASK)
		{
			int x = i % ButtonWindow.NUM;
			int y = i / ButtonWindow.NUM;
			System.out.println("Left (" + x + " " + y + ")");
			System.out.println("  Answer: " + server.computeDistance(x, y));
		}
		// right click
		else if (e.getModifiers() == InputEvent.BUTTON3_MASK)
		{
			String label = button.getLabel();
			int num = Integer.parseInt(label);
			System.out.println("Right " + label);
			System.out.println("  Answer: " + server.computeSquare(num));
		}
	}  
}

class ButtonWindow
{
	public static final int NUM = 25;
	public static final int RAN = 10;

	public static void main( String[] args )
	{
		Frame frame = new Frame( "Flyweight Demo" );
		// Handle the closing event (when the red X is clicked on the window)
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				e.getWindow().dispose();
			}
		});
		frame.setLayout( new GridLayout( NUM, NUM ) );
		for (int i=0; i < NUM; i++)
		{
			for (int j=0; j < NUM; j++)
			{
				frame.add( ButtonFactory.makeButton( 
					Integer.toString( (int)(Math.random()*RAN) ) ) );
			}
		}
		frame.pack();
		frame.setVisible(true);
		ButtonFactory.report();
	}
}
