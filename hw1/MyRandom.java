import java.util.*;
class MyRandom{
		public static int ran(int seed)
		{
				Random rannum = new Random();                               
				return (rannum.nextInt(seed));
		}
}
