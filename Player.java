import java.util.*;
import java.io.*;
class Player extends MyRandom{
		public Vector<Integer> own = new Vector<Integer>();
		public void take(int card)
		{
				this.own.add(card);
		}
		public void show(int who)
		{
				System.out.print("Player" + who + ":");
				//	Iterator<Integer> it = this.iterator();
				//	while(it.hasNext())
				//			System.out.print(" " + this.hash(it.next()));
				for(int i = 0; i < this.own.size(); i++)
						System.out.print(" " + this.hash(this.own.get(i)));
				System.out.println();
		}
		public boolean toomuch(int op)
		{
				if(op <= 1)
				{
						if(this.own.size() == 14)
								return true;
						else 
								return false;
				}
				else
				{
						if(this.own.size() == 13)
								return true;
						else 
								return false;
				}
		}
		public void mysort(){
				int last = this.own.lastElement();
				if(last < this.own.get(0))
				{
						this.own.add(0, last);
						this.own.removeElementAt((this.own.size() - 1));
				}
				else if(last < this.own.get(this.own.size() - 2)){
						for(int i = 0; i < (this.own.size() - 1); i++)
						{
								if(last > this.own.get(i) && last < this.own.get(i + 1))
										this.own.add(i + 1, last);
						}
						this.own.removeElementAt((this.own.size() - 1));
				}
		}
		public void drop(){
				for(int i = 0; i < (this.own.size() - 1); i++)
				{
						if(this.own.get(i) <= 1)
								continue;
						else if(((this.own.get(i) - 2) / 4) == ((this.own.get(i + 1) - 2) / 4))
						{
								this.own.removeElementAt(i);
								this.own.removeElementAt(i);
								i--;
						}
				}
		}
		public String suck(Player B)                                                                               
		{
				MyRandom op = new MyRandom();
				int ans = op.ran(B.own.size());
				String card = hash(B.own.get(ans));
				this.take(B.own.get(ans));
				B.own.removeElementAt(ans);
				return card;
		}
		public boolean won(){
				return(this.own.isEmpty());
		}
		public  String hash(int num)                                                                                     
		{
				String[] card = 
				{
						"R0", "B0",
						"C2", "D2", "H2", "S2", "C3", "D3", "H3", "S3", "C4", "D4", "H4", "S4",
						"C5", "D5", "H5", "S5", "C6", "D6", "H6", "S6", "C7", "D7", "H7", "S7",
						"C8", "D8", "H8", "S8", "C9", "D9", "H9", "S9", "C10", "D10", "H10", "S10",
						"CJ", "DJ", "HJ", "SJ", "CQ", "DQ", "HQ", "SQ", "CK", "DK", "HK", "SK", "CA", "DA", "HA", "SA"
				};
				return(card[num]);
		}
}
