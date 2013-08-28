
public class Soldier extends Militia
{
	protected int ammoCount;
	protected String type;
	
	
	public Soldier(String type, int ammo)
	{
		this.type = type;
		this.ammoCount = ammo;
	}
	
	public void printDetails(int depth)
	{
		for (int i = 0; i < depth; ++i)
		{
			System.out.print("  ");
		}
		System.out.println("Soldier (" + type + "), Ammo Count = " + ammoCount);
	}
	
	/*
	 * Increments the ammo
	 */
	public void addAmmo(int ammo)
	{
		ammoCount += ammo;
	}
	
	public int getAmmoCount()
	{
		return ammoCount;
	}
}
