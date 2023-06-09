import java.io.*;
class vw_trans extends vali_date
{
	public static void vw(int cte)throws Exception
	{
		BufferedReader fr1=new BufferedReader(new FileReader("products.dat"));
		try
		{
			String str2=fr1.readLine();
		}
		catch(IOException e)
		{
			PrintWriter pr=new PrintWriter(new FileWriter("products.dat"));
		}
		fr1.close();
		try
		{
			if(cte==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int ch=0;
			boolean flgc=true;
			do
			{

				cls();
				System.out.println("\t\t\t\t  View Transactions	");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("\n\t\t\t  View By:");
				System.out.println("\t\t\t  1) Customer");
				System.out.println("\t\t\t  2) Product");
				System.out.println("\t\t\t  3) Cost");
				System.out.println("\t\t\t  4) Back to Stock Menu");
				System.out.println("\t\t\t  5) Exit");
				System.out.print("\n\t\t\t    Enter Choice: ");
				try
				{
					ch=Integer.parseInt(br.readLine());
				}
				catch(Exception e)
				{
					flgc=false;
				}
				switch(ch)
				{
					case 1:vw_trans.nm(0);
					break;
					case 2:vw_trans.prd(0);
					break;
					case 3:vw_prods.cst(0);
					break;
					case 4:mainstore.menu(0);
					break;
					case 5:System.exit(0);
					break;
				}
			}while(ch<1||ch>6||flgc==false);
		}
		catch(Exception e)
		{
			vw_trans.vw(1);
		}
	}


	public static void nm(int cte2)throws Exception
	{
		try
		{
			if(cte2==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}
			cls();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("transacs.dat"));
			char ch=0;
			System.out.println("\t\t\t\t  View By Customer Name");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("\n\t\t\t  Enter Name: ");
			String nm=br.readLine();
			String str=fr.readLine();
			boolean flg=false;

			while(str!=null)
			{
				String[] tmp=str.split(",");
				if(tmp[2].compareTo(nm)==0)
				{
					System.out.println("\n\t\t\tSr. No: "+tmp[0]+"\n\n\t\t\tDate: "+tmp[1]+"\n\n\t\t\tFirst Name: "+tmp[2]+"\n\n\t\t\tLast Name: "+tmp[3]+"\n\n\t\t\tProductID: "+tmp[4]+"\n\n\t\t\tPrice: "+tmp[5]+"\n\n\t\t\tQuantity: "+tmp[6]);
					System.out.println();
					flg=true;
					str=fr.readLine();
				}
				str=fr.readLine();
			}
			if(flg==false)
			{
				System.out.println("Customer not found");
			}
			do
			{
				System.out.print("\n\t\t\t  View more Records?(y/n)");
				ch=vali_date.valid();
			}while(ch!='y'&&ch!='n');
			if(ch=='y')
			{
				vw_trans.vw(0);
				cte2=1;
			}
			if(ch=='n')
			{
				mainstore.menu(0);
			}
		}
		catch(Exception e)
		{
			vw_trans.nm(1);
		}
	}
	public static void prd(int cte3)throws Exception
	{
		try
		{
			if(cte3==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}
			cls();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("transacs.dat"));
			char ch='e';
			System.out.println("\t\t\t\t  View By Product");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("\n\t\t\t  Enter ProductID: ");
			String id=br.readLine();
			String str=fr.readLine();
			boolean flg=false;

			while(str!=null)
			{
				String[] tmp=str.split(",");
				if(tmp[3].compareTo(id)==0)
				{
					System.out.println("\n\t\t\tSr. No: "+tmp[0]+"\n\n\t\t\tDate: "+tmp[1]+"\n\n\t\t\tFirst Name: "+tmp[2]+"\n\n\t\t\tLast Name: "+tmp[3]+"\n\n\t\t\tProductID: "+tmp[4]+"\n\n\t\t\tPrice: "+tmp[5]+"\n\n\t\t\tQuantity: "+tmp[6]);
					System.out.println();
					flg=true;
					str=fr.readLine();
				}
				str=fr.readLine();
			}
			if(flg==false)
			{
				System.out.println("\n\t\t\t  Transaction not found");
			}
			do
			{
				System.out.print("\n\t\t\t  View more Records?(y/n)");
				ch=vali_date.valid();
			}while(ch!='y'&&ch!='n');
			if(ch=='y')
			{
				vw_trans.vw(0);
			}
			if(ch=='n')
			{
				mainstore.menu(0);
			}
		}
		catch(Exception e)
		{
			vw_trans.prd(1);
		}
	}

	public static void cst(int cte4)throws Exception
	{
		try
		{
			if(cte4==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}
			cls();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("transacs.dat"));
			char ch='e';
			System.out.println("\t\t\t\t  View By Cost");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("\n\t\t\t  Enter Cost: ");
			double c=Double.parseDouble(br.readLine());
			String str=fr.readLine();
			String cst=str.valueOf(c);

			boolean flg=false;

			while(str!=null)
			{
				String[] tmp=str.split(",");
				if(tmp[5].compareTo(cst)!=0)
				{
					System.out.println("\n\t\t\tSr. No: "+tmp[0]+"\n\n\t\t\tDate: "+tmp[1]+"\n\n\t\t\tFirst Name: "+tmp[2]+"\n\n\t\t\tLast Name: "+tmp[3]+"\n\n\t\t\tProductID: "+tmp[4]+"\n\n\t\t\tPrice: "+tmp[5]+"\n\n\t\t\tQuantity: "+tmp[6]);
					System.out.println();
					flg=true;
					str=fr.readLine();
				}
				str=fr.readLine();
			}
			if(flg==false)
			{
				System.out.println("\n\t\t\t  Transaction not found");
			}
			do
			{
				System.out.print("\n\t\t\t  View more Records?(y/n)");
				ch=vali_date.valid();
			}while(ch!='y'&&ch!='n');
			if(ch=='y')
			{
				vw_trans.vw(0);
			}
			if(ch=='n')
			{
				mainstore.menu(0);
			}
		}
		catch(Exception e)
		{
			vw_trans.cst(1);
		}
	}
}

