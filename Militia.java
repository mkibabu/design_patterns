
/* 
 * Abstract base class for the army
 */
public abstract class Militia 
{
	/*
	 * Return the total amount of ammunition owned by this instance.
	 */
	abstract int getAmmoCount();
	
	/*
	 * Add the provided amount of ammunition to this instance.
	 */
	abstract void addAmmo(int ammo);
	
	/*
	 * Print out some details about this instance.
	 */
	abstract void printDetails(int depth);
}
