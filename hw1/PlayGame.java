import java.lang.*;
import java.util.*;
import java.io.*;
public class PlayGame extends Player{
		public static void main(String[] var)
		{
				MyRandom op = new MyRandom();
				Player[] play = new Player[4];
				for(int i = 0; i < 4; i++)
						play[i] = new Player();
				System.out.println("Deal Cards");
				for(int i = 0; i < 54; i++)
				{
						int which = op.ran(4);
						while(true)
						{
								if((which == 3) && (play[which].toomuch(3)))
										which = 0;
								else if((which == 2) && (play[which].toomuch(2)))
										which++;
								else if((which == 1) && (play[which].toomuch(1)))
										which++;
								else if((which == 0) && (play[which].toomuch(0)))
										which++;
								else
								{
										play[which].take(i);
										break;
								}
						}
				}
				for(int i = 0; i < 4; i++)
						play[i].show(i);
				System.out.println("Drop Cards");
				for(int i = 0; i < 4; i++)
						play[i].drop();
				for(int i = 0; i < 4; i++)                                                                              
						play[i].show(i);
				System.out.println("Game Start");
				//	int per[4] = {0, 1, 2, 3};
				int[] to = {1, 2, 3, 0};
				int[] from = {3, 0, 1, 2};
				if(wonppl(play) != 0)
				{
						for(int i = 0; i <= 3; i++)
								if(play[i].won())
								{
										to[from[i]] = to[i];
										from[to[i]] = from[i];
								}
				}
				while(wonppl(play) < 3)
				{
						String ans;
						for(int i = 0; i <= 3; i++)
						{
								if(play[i].won())
										continue;
								ans = play[i].suck(play[to[i]]);
								play[i].mysort();
								play[i].drop();
								System.out.println("Player" + i + " draws a card from Player" + (to[i]) + " " + ans);
								play[i].show(i);
								play[to[i]].show(to[i]);
								if(play[i].won() && play[to[i]].won())
								{
										System.out.println("Player" + i + " and Player" + (to[i]) + " win");
										if(wonppl(play) == 2)
										{
												System.out.println("Basic game over");
												System.out.println("Continue");
												to[from[i]] = to[to[i]];
												from[to[to[i]]] = from[i];
										}
								}
								else if(play[i].won())
								{
										System.out.println("Player" + i + " wins");
										if(wonppl(play) == 1)
										{
												System.out.println("Basic game over");
												System.out.println("Continue");
										}
										to[from[i]] = to[i];                                                    
										from[to[i]] = from[i];
								}
								else if(play[to[i]].won())
								{
										System.out.println("Player" + to[i] + " wins");
										if(wonppl(play) == 1)
										{
												System.out.println("Basic game over");
												System.out.println("Continue");
										}
										to[i] = to[to[i]];
										from[to[to[i]]] = i;
								}
								if(wonppl(play) == 3)
										break;
						}
				}
				System.out.println("Bonus game over");
		}
		public static void balence(Player[] play , int[] per, int[] to)
		{
				int x = 0;
				int y = 0;
				int ppl = (4 - wonppl(play));
				if(ppl == 3)
				{
						for(int i = 0; i <= 3; i++)
						{
								if(!(play[per[i]].won()))
										per[x++] = i;
						}
				}
		}
		public static void play(Player[] play, int ppl, int[] per, int[] to)
		{
				while(wonppl(play) == (4 - ppl))
				{
						String ans;                                                                                     
						for(int i = 0; i <= ppl; i++)
						{
								ans = play[i].suck(play[to[i]]);
								play[i].mysort();
								play[i].drop();
								System.out.println("Player" + i + " draws a card from Player" + (to[i]) + " " + ans);
								play[i].show(i);
								play[to[i]].show(to[i]);
								if(play[i].won() || play[to[i]].won())
										break;
						}
						if(wonppl(play) != (4 - ppl))
								break;
				}
		}
		public static int wonppl(Player[] play)
		{
				int ans = 0;
				for(int i = 0; i < 4; i++)
						if(play[i].won())
								ans++;
				return ans;
		}
		/*	String hash(int num)
			{
			String[] card = 
			{                                                                                                
			"R0", "B0",
			"C2", "D2", "H2", "S2", "C3", "D3", "H3", "S3", "C4", "D4", "H4", "S4",
			"C5", "D5", "H5", "S5", "C6", "D6", "H6", "S6", "C7", "D7", "H7", "S7",
			"C8", "D8", "H8", "S8", "C9", "D9", "H9", "S9", "C10", "D10", "H10", "S10",
			"CJ", "DJ", "HJ", "SJ", "CQ", "DQ", "HQ", "SQ", "CK", "DK", "HK", "SK", "CA", "DA", "HA", "SA"
			};
			return card[num];
			}*/
}
