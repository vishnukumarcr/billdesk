import java.io.*;
import java.util.*;
class itemDetails
{
		String itemName;
		int stockCount,cost;
		itemDetails(String itemName,int stockCount, int cost)
		{
			this.itemName = itemName;
			this.stockCount = stockCount;
			this.cost = cost;
		}
}
class billDetails{
	String itemName;
	int costPerItem,quantity,totalCost;
	billDetails(String itemName,int costPerItem,int quantity,int totalCost)
	{
		this.itemName=itemName;
		this.costPerItem=costPerItem;
		this.quantity=quantity;
		this.totalCost=totalCost;
	}
}
class stockAndBill
{
	static itemDetails[] totalItems = new itemDetails[10];
	static ArrayList<billDetails> bill = new ArrayList<billDetails>();
	stockAndBill()
	{
		this.totalItems=totalItems;
		totalItems[0] = new itemDetails("Apple",10,5);
		totalItems[1] = new itemDetails("Orange",10,6);
		totalItems[2] = new itemDetails("Grapes",10,7);
	}
	public static void deliveryItemAdd(int item, int quantity)
	{
		bill.add( new billDetails(totalItems[item-1].itemName,totalItems[item-1].cost,quantity,quantity*totalItems[item-1].cost));
	}
	public static void updateItemDetails(int item,int quantity)
	{
		totalItems[item-1].stockCount-=quantity;
	}
	public static int stockAvailable(int item)
	{
		return totalItems[item-1].stockCount;
	}
	public static void generateBill()
	{
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("		      Zoho Corporation");
		System.out.println("--------------------------------------------------------------");
		System.out.println("         	       Bill details");
		System.out.println("--------------------------------------------------------------");
		int billLength=bill.size();
		int totalCostOfBill=0;
		System.out.println("ItemName\tCostPerItem\tQuantity\tCost Details");
		System.out.println("--------------------------------------------------------------");
		for(int i=0;i<billLength;i++)
		{
			System.out.println(bill.get(i).itemName+"\t\t      "+bill.get(i).costPerItem+"\t\t  "+bill.get(i).quantity+"\t\t  "+bill.get(i).totalCost);
			totalCostOfBill+=bill.get(i).totalCost;
			System.out.println("--------------------------------------------------------------");
		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("Total Cost = \t\t\t\t\t"+totalCostOfBill);
		System.out.println("--------------------------------------------------------------");
		System.out.println("   	    Thanks for your visit");
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		newBill();
	}
	public static void newBill()
	{
		bill.clear();
	}
}
class totalFunction extends stockAndBill
{
	public static void displayMenu()
	{
		System.out.println("1.Apple");
		System.out.println("2.Orange");
		System.out.println("3.Grapes");
		System.out.println("press 0 to finish");
	}
	public static void getInput(Scanner scan)
	{
		int quantity=0,item=10;
		displayMenu();
		System.out.println();
		System.out.print("enter item number = ");
		item=scan.nextInt();
		while(item!=0)
		{
			System.out.print("enter quantity= ");
			quantity=scan.nextInt();
			if(stockAvailable(item)>=quantity)
			{
				updateItemDetails(item,quantity);
				deliveryItemAdd(item,quantity);		
			}
			else
			{
				System.out.println();
				System.out.println("enough stock not available");
				System.out.println("available stock is: "+stockAvailable(item));
				System.out.println();
			}
			displayMenu();
			System.out.println();
			System.out.print("enter item number = ");
			item=scan.nextInt();
		}
		generateBill();
	}
}
public class billdesk extends totalFunction
{
	public static final Scanner scan= new Scanner(System.in);
	public static void main(String[] args){
		new stockAndBill();
		while(true)
		{
		getInput(scan);
		}
	}
}
