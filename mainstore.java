import java.io.*;
class mainstore extends vali_date
{
	public static void pass()
	{
		String pass="password";
		Console console=System.console();
		if(console==null)
		{
			System.out.println("Couldn't get Console Instance");
			System.exit(0);
		}
		char []passwordArray=console.readPassword("\t\t\t\tPassword: ");
		String pwd=new String(passwordArray);
		if(pass.compareTo(pwd)==0)
		{
			try
			{
				mainstore.menu(0);
			}
			catch(Exception e)
			{
				mainstore.pass();
			}
		}
		else
		{
			System.out.println("Incorrect Password");
			mainstore.pass();
		}
	}
	public static void menu(int cte)throws Exception
	{
		System.out.println("menu enter cte:"+cte);
		try
		{
			System.out.println("menu try");
				cls();
				
				if(cte==1)
				{
					System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
				}
				int ch=0;
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("\t\t\t   WELCOME TO THE COMPUTER STORE");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t  Menu:");
				System.out.println("\n\t\t\t       1) Stock");
				System.out.println("\t\t\t       2) Transactions");
				System.out.println("\t\t\t       3) Exit");

				boolean flg1=true;
				do
				{
					try
					{
						System.out.print("\n\t\t\t    Enter Choice: ");
						ch=Integer.parseInt(br.readLine());
					}
					catch(NumberFormatException e)
					{
						System.out.println("\t\t\t  Enter Valid Choice");
						flg1=false;
					}
					switch(ch)
					{
						case 1:mainstore.stockmenu(0);
						break;
						case 2:mainstore.transactionsmenu(0);
						break;
						case 3:System.exit(0);
					}
				}while(ch>0||ch<3||flg1==false);
		}
		catch(Exception e)
		{
			System.out.println("menu exception");
			mainstore.menu(1);
		}
	}
	public static void stockmenu(int cte1)throws Exception
	{
		try
		{
			cls();
			if(cte1==1)
			{
					System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}

			int ch=0;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" \t\t\t\t STOCK");
			System.out.println("--------------------------------------------------------------------------------");
			boolean flg1=true;
			do
			{
				System.out.println("\t\t\t\t  Menu:");
				System.out.println("\n\t\t\t       1) Add Products");
				System.out.println("\t\t\t       2) Delete Products");
				System.out.println("\t\t\t       3) View Products");
				System.out.println("\t\t\t       4) Modify Products");
				System.out.println("\t\t\t       5) Back");
				System.out.println("\t\t\t       6) Exit");


				try
				{
					System.out.print("\n\t\t\t    Enter Choice: ");
					ch=Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("\t\t\t  Enter Valid Choice");
					flg1=false;
				}
				switch(ch)
				{
					case 1:add_prods.add();
					break;
					case 2:del_prods.del(0);
					break;
					case 3:vw_prods.vw(0);
					break;
					case 4:mod_prods.mod(0);
					break;
					case 5:mainstore.menu(0);
					break;
					case 6:System.exit(0);
					break;
				}
			}while(ch>0&&ch<6||flg1==false);
		}
		catch(Exception e)
		{
			mainstore.stockmenu(1);
		}
	}
	public static void transactionsmenu(int cte2)throws Exception
	{
		try
		{
			cls();
			if(cte2==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}

			int ch=0;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\t\t\t	TRANSACTIONS");
			boolean flg2=true;
			System.out.println("--------------------------------------------------------------------------------");
			do
			{
				System.out.println("\t\t\t\t  Menu:");
				System.out.println("\n\t\t\t      1) New Transaction");
				System.out.println("\t\t\t      2) View Transactions");
				System.out.println("\t\t\t      3) Back to Mainmenu");
				System.out.println("\t\t\t      4) Exit");

				try
				{
					System.out.print("\n\t\t\t    Enter Choice: ");
					ch=Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("\t\t\t  Enter Valid Choice");
					flg2=false;
				}
				switch(ch)
				{
					case 1:add_trans.adtr(0);
					break;
					case 2:vw_trans.vw(0);
					break;
					case 3:mainstore.menu(0);
					break;
					case 4:System.exit(0);
					break;
				}
			}while(ch>0&&ch<4||flg2==false);
		}
		catch(Exception e)
		{
			mainstore.transactionsmenu(1);
		}
	}
	public static void main(String[] args)throws Exception
	{
		mainstore.pass();
	}
}