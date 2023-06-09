import java.io.*;
class vw_prods extends vali_date
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
				System.out.println("\t\t\t  An Error Occured. Please Try Again\n");
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
			int ch=0;
			do
			{
				cls();
				System.out.println("\t\t\t\t  VIEW PRODUCTS");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("\n\t\t\t  View By:");
				System.out.println("\t\t\t  1) Type");
				System.out.println("\t\t\t  2) Company");
				System.out.println("\t\t\t  3) Cost");
				System.out.println("\t\t\t  4) Back to Stock Menu");
				System.out.println("\t\t\t  5) Exit");
				System.out.print("\n\t\t\t    Enter Choice: ");
				ch=Integer.parseInt(br.readLine());
				switch(ch)
				{
					case 1:vw_prods.typ(0);
					break;
					case 2:vw_prods.comp(0);
					break;
					case 3:vw_prods.cst(0);
					break;
					case 4:mainstore.menu(0);
					break;
					case 5:System.exit(0);
					break;
				}
			}while(ch<1||ch>5);
		}
		catch(Exception e)
		{
			vw_prods.vw(1);
		}
	}

	public static void typ(int cte1)throws Exception
	{
		try
		{
			cls();
			if(cte1==1)
			{
					System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
			char ch='e';
			System.out.println("\t\t\t\t  View By ID");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("\n\t\t\t  Enter ID(eg lp1): ");
			String id=br.readLine();

			String str=fr.readLine();
			boolean flg=false;

			while(str!=null)
			{
				String[] tmp=str.split(",");
				if(tmp[0].compareTo(id)!=0)
				{
					str=fr.readLine();
				}
				else
				{
					System.out.println("\n\t\t\tProductID: "+tmp[0]+"\n\n\t\t\tColour: "+tmp[1]+"\n\n\t\t\tCompany: "+tmp[2]+"\n\n\t\t\tWeight: "+tmp[3]+"\n\n\t\t\tScreenSize: "+tmp[4]+"\n\n\t\t\tScreenResolution: "+tmp[5]+"\n\n\t\t\tRam: "+tmp[6]+"\n\n\t\t\tStorage: "+tmp[7]+"\n\n\t\t\tCost: "+tmp[8]+"\n\n\t\t\tQuantity: "+tmp[9]);
					flg=true;
					str=fr.readLine();
					System.out.println();
				}
			}
			if(flg==false)
			{
				System.out.println("\n\t\t\t  Product Not Found");
			}
			do
			{
				System.out.print("\n\t\t\t  View more Records?(y/n)");
				ch=vali_date.valid();;
			}while(ch!='y'&&ch!='n');
			if(ch=='y')
			{
				vw_prods.vw(0);
			}
			if(ch=='n')
			{
				mainstore.menu(0);
			}
		}
		catch(Exception e)
		{
			vw_prods.typ(1);
		}
	}
	public static void comp(int cte2)throws Exception
	{
		try
		{
			if(cte2==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}
			cls();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
			char ch='e';
			System.out.println("\t\t\t\t  View By Company");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("\n\t\t\t  Enter Company(eg dell): ");
			String id=br.readLine();
			id=id.toLowerCase();
			String str=fr.readLine();
			boolean flg=false;

			while(str!=null)
			{
				String[] tmp=str.split(",");
				if(tmp[1].compareTo(id)!=0)
				{
					str=fr.readLine();
				}
				else
				{
					System.out.println("\n\t\t\tProductID: "+tmp[0]+"\n\n\t\t\tColour: "+tmp[1]+"\n\n\t\t\tCompany: "+tmp[2]+"\n\n\t\t\tWeight: "+tmp[3]+"\n\n\t\t\tScreenSize: "+tmp[4]+"\n\n\t\t\tScreenResolution: "+tmp[5]+"\n\n\t\t\tRam: "+tmp[6]+"\n\n\t\t\tStorage: "+tmp[7]+"\n\n\t\t\tCost: "+tmp[8]+"\n\n\t\t\tQuantity: "+tmp[9]);
					flg=true;
					str=fr.readLine();
					System.out.println();
				}
			}
			if(flg==false)
			{
				System.out.println("\n\t\t\t  Product Not Found");
			}
		do
		{
			System.out.print("\n\t\t\t  View more Records?(y/n)");
			ch=vali_date.valid();
		}while(ch!='y'&&ch!='n');
		if(ch=='y')
		{
			vw_prods.vw(0);
		}
		if(ch=='n')
		{
			mainstore.menu(0);
		}
		}
		catch(Exception e)
		{
			vw_prods.comp(1);
		}
	}
	public static void cst(int cte3)throws Exception
	{
		try
		{
			if(cte3==1)
			{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
			}
			cls();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
			char ch='e';
			System.out.println("\t\t\t\t  View By Cost	");
			System.out.println("--------------------------------------------------------------------------------");
			double id=0;
			boolean flgid=true;
			do
			{
				flgid=true;
				try
				{
					System.out.print("\n\t\t\t  Enter Cost(eg 1000): ");
					id=Double.parseDouble(br.readLine());
				}
				catch(Exception e)
				{
					flgid=false;
				}
				cls();
			}while(flgid==false);
			String str=fr.readLine();
			boolean flg=false;

			while(str!=null)
			{
				String[] tmp=str.split(",");
				double tp=Double.parseDouble(tmp[8]);
				if(tp!=id)
				{
					str=fr.readLine();
				}
				else
				{
					System.out.println("\n\t\t\tProductID: "+tmp[0]+"\n\n\t\t\tColour: "+tmp[1]+"\n\n\t\t\tCompany: "+tmp[2]+"\n\n\t\t\tWeight: "+tmp[3]+"\n\n\t\t\tScreenSize: "+tmp[4]+"\n\n\t\t\tScreenResolution: "+tmp[5]+"\n\n\t\t\tRam: "+tmp[6]+"\n\n\t\t\tStorage: "+tmp[7]+"\n\n\t\t\tCost: "+tmp[8]+"\n\n\t\t\tQuantity: "+tmp[9]);
					flg=true;
					str=fr.readLine();
					System.out.println();
				}
			}
			if(flg==false)
			{
				System.out.println("\n\t\t\t  Product Not Found");
			}
			do
			{
				System.out.print("\n\t\t\t  View more Records?(y/n)");
				ch=vali_date.valid();
			}while(ch!='y'&&ch!='n');
			if(ch=='y')
			{
				vw_prods.vw(0);
			}
			if(ch=='n')
			{
				mainstore.menu(0);
			}
		}
		catch(Exception e)
		{
			vw_prods.cst(1);
		}
	}
}