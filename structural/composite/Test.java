
public class Test
{
	public static void main(String[] args)
	{
		// create new factory
		SoldierFactory factory = new SoldierFactory();
		
		// create soldiers
		Soldier soldier1 = factory.createSoldier("Foot");
		Soldier soldier2 = factory.createSoldier("Foot");
		Soldier soldier3 = factory.createSoldier("Spy");
		Soldier soldier4 = factory.createSoldier("Spy");
		Soldier soldier5 = factory.createSoldier("Spy");
		Soldier soldier6 = factory.createSoldier("Spy");
		
		// create divisions and add soldiers
		Division division1 = new Division();
		division1.addMilitia(soldier1);
		division1.addMilitia(soldier3);
		division1.addMilitia(soldier4);
		
		Division division2 = new Division();
		division2.addMilitia(soldier2);
		division2.addMilitia(soldier5);
		
		// Create the division that contains the entire army
		Division rootDivision = new Division();
		
		// add divisions and soldiers to the army structure
		rootDivision.addMilitia(division1);
		rootDivision.addMilitia(division2);
		rootDivision.addMilitia(soldier6);
		
		// print out the initial army stats
		rootDivision.printDetails(0);
		System.out.println();
		System.out.println("**********************************");
		System.out.println();
		
		// Add ammo to the entire army
		System.out.println("Adding 23 ammo");
		rootDivision.addAmmo(23);
		
		// Print out the new army stats
		rootDivision.printDetails(0);
	}
}
