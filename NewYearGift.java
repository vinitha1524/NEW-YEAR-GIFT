package EpamTask1;
import java.util.Scanner;
interface sortGift
{
	public void sortgift(int numGift,int candies[]);
}
class sort implements sortGift
{
	public void sortgift(int numGift,int candies[])
	{
		int temp=0;
		int d[]=new int[numGift];
		for(int i=0;i<numGift;i++)
		{
			d[i]=i+1;
		}
		for(int i=0;i<numGift;i++)
		{
			for(int j=i+1;j<numGift;j++)
			{
				if(candies[i]>candies[j])
				{
					temp=candies[i];
					candies[i]=candies[j];
					candies[j]=temp;
					temp=d[i];
					d[i]=d[j];
					d[j]=temp;
				}
			}
		}
		System.out.println("Sorted order:");
		for(int i=0;i<numGift;i++)
		{
			System.out.println("Gift "+d[i]);
		}
	}
}
abstract class Gift
{
	public abstract int chocweight(int numchoc);
	public abstract int sweetweight(int numsweet);
}
abstract class Choclates extends Gift
{
	int cweight=6;
	public int chocweight(int numchoc)
	{
		return(numchoc*cweight);
	}
}
class Sweets extends Choclates
{
	int sweight=4;
	public int sweetweight(int numsweet)
	{
		return(numsweet*sweight);
	}
}
public class NewYearGift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("enter number of children");
		int numGift=input.nextInt();
		int Gift[]=new int[numGift];
		Choclates dairymilk=new Sweets();
		Choclates kitkat=new Sweets();
		int tweight[]=new int[numGift];
		Sweets laddu=new Sweets();
		Sweets burfiee=new Sweets();
		int candies[]=new int[numGift];
		
		for(int i=0;i<numGift;i++)
		{
			int chocweight=0;
			int sweetweight=0;
			int numcandies=0;
			System.out.println("enter number of dairymik choclates in gift"+(i+1));
			int daichoc=input.nextInt();
			chocweight+=dairymilk.chocweight(daichoc);
			System.out.println("enter number of kitkat choclates in gift"+(i+1));
			int kitchoc=input.nextInt();
			chocweight+=kitkat.chocweight(kitchoc);
			System.out.println("enter number of laddus in gift"+(i+1));
			int numladdu=input.nextInt();
			sweetweight+=laddu.sweetweight(numladdu);
			System.out.println("enter number of burfee in gift"+(i+1));
			int numburfee=input.nextInt();
			sweetweight+=burfiee.sweetweight(numburfee);		
			tweight[i]=chocweight+sweetweight;
			numcandies=daichoc+kitchoc+numladdu+numburfee;
			candies[i]=numcandies;
		}
		System.out.println("Gift\tWeights\tCandies");
		for(int i=0;i<numGift;i++)
		{
			System.out.print((i+1)+"\t"+tweight[i]+"\t"+candies[i]+"\n");
		}
		System.out.println();
		sortGift s=new sort();
		s.sortgift(numGift,candies);

	}

}
