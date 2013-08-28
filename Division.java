
import java.util.*;

/*
 * Represents a grouping of the militia
 */

public class Division extends Militia
{
	private ArrayList<Militia> soldiers;
	
	public Division()
	{
		soldiers = new ArrayList<Militia>();
	}
	/*
	 * Add militia to the division.
	 * Could add either a whole division or an individual soldier
	 */
	
	public void addMilitia(Militia s)
	{
		soldiers.add(s);
	}
	
	/*
	 * (non-Javadoc)
	 * @see phase1.Militia#printDetails(int)
	 */
	public void printDetails(int depth)
	{
		for (int i = 0; i < depth; ++i)
		{
			System.out.print("  ");
		}
		System.out.println("Division, Ammo Count = " + getAmmoCount());
		Iterator<Militia> itr = soldiers.iterator();
		while (itr.hasNext())
		{
			itr.next().printDetails(depth + 1);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see phase1.Militia#getAmmoCount()
	 */
	
	public int getAmmoCount()
	{
		int totalCount = 0;
		Iterator<Militia> itr = soldiers.iterator();
		while (itr.hasNext())
		{
			totalCount += itr.next().getAmmoCount();
		}
		return totalCount;
	}
	
	/*
	 * (non-Javadoc)
	 * @see phase1.Militia#addAmmo(int)
	 * Adds ammo equally across all militia contained in
	 * this division.
	 * For instance, if this division contains 3 militia, and we are
	 * adding 23 ammo, the ammo will be split such that 8 ammo is given
	 * to the first two militia, and 7 ammo is given to the last.
	 */
	public void addAmmo(int ammo)
	{	
		// do not add ammo to an empty division
		if(soldiers.size() == 0)
		{
			System.out.println("Division is empty. Cannot add ammo.");
			return;
		}
		
		int[] ammoToAdd = new int[soldiers.size()];
		
		int ammoPerGroup = ammo / soldiers.size();
		
		for (int i = 0; i < soldiers.size(); ++i)
		{
			ammoToAdd[i] = ammoPerGroup;
		}
		
		int remainder = ammo - ammoPerGroup * soldiers.size();
		
		// remainder is guaranteed to be less than soldiers.size()
		for (int i = 0; i < remainder; i++)
		{
			ammoToAdd[i] += 1;
		}
		
		for (int i = 0; i < soldiers.size(); ++i)
		{
			soldiers.get(i).addAmmo(ammoToAdd[i]);
		}
	}
}
	
