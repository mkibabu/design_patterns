
/*
 * Creates a Soldier object of different user-defined types.
 */

public class SoldierFactory
{
	public Soldier createSoldier(String type)
	{
		if(type.equalsIgnoreCase("Spy"))
			return new Spy();
		else if (type.equalsIgnoreCase("Foot"))
			return new FootSoldier();
		else
		{
			System.out.println("Error: Invalid soldier type");
			return null;
		}
	}
}
