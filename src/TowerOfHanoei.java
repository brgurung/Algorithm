
public class TowerOfHanoei {

	public enum poles
	{A, B, C};

	public void towerOfHanoei(int numberOfDisks, poles src, poles dest, poles extra)
	{
		if (numberOfDisks > 0)
		{
			towerOfHanoei(numberOfDisks - 1, src, extra, dest);
			System.out.printf("%nMoving Disk from POLE-%s to POLE-%s %n", src.toString(), dest.toString());
			towerOfHanoei(numberOfDisks - 1, extra, dest, src);
		}
	}
	
	public static void main(String[] args)
	{
		TowerOfHanoei tower = new TowerOfHanoei();
		tower.towerOfHanoei(5, poles.A, poles.C, poles.B);
	}
}
