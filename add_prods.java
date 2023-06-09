import java.io.*;
class add_prods extends vali_date
{
	public static int extra()throws Exception
	{
		int a=0;
		BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
		String str="emp";
		try
		{
			str=fr.readLine();
		}
		catch(IOException e)
		{
			BufferedReader fr3=new BufferedReader(new FileReader("products.dat"));
			fr3.close();
		}

		if(str==null)
		{
			a=1;
		}
		while(str!=null)
		{
			String []str1=str.split(",");
			String temp=str1[0];
			a=Integer.parseInt(temp.substring(2))+1;
			str=fr.readLine();
		}
		fr.close();
		return a;
	}

	public static void add()throws Exception
	{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int pno=add_prods.extra();

		PrintWriter pr=new PrintWriter(new FileWriter("products.dat",true));
		char ch1='b';
		do
		{
			cls();
			int ch=0;
			String pid="as";
			boolean flgc=true;

			do
			{
				cls();
				System.out.println("\t\t\t\t  ADD PRODUCTS");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("\n\t\t\t\t  Type of Product:");
				System.out.println("\n\t\t\t  1) Laptop");
				System.out.println("\t\t\t  2) Desktop Computer");
				System.out.println("\t\t\t  3) Keyboard");
				System.out.println("\t\t\t  4) Mouse");
				System.out.println("\t\t\t  5) Back to Stock Menu");
				System.out.println("\t\t\t  6) Exit");
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
					case 1: pid="lp";
					break;
					case 2: pid="dc";
					break;
					case 3: pid="kb";
					break;
					case 4: pid="ms";
					break;
					case 5: mainstore.menu(0);
					break;
					case 6: System.exit(0);
					break;
				}
			}while(ch<0||ch>6||flgc==false);

			String comname="empty";
			String col="empty";
			String scrrs="empty";
			double prowt=0.0;
			double scrsz=0.0;
			double rm=0.0;
			double stg=0.0;
			double cst=0.0;
			int qt=0;
			boolean flg1=true;
			boolean flg2,flg3=false;
			do
			{

				try
				{
					do
					{
						System.out.print("\n\t\t\t  Enter Company:");
						comname=br.readLine();
						flg2=vali_date.valn(comname);
					}while(flg2==false);

					do
					{
						System.out.print("\n\t\t\t  Enter Colour: ");
						col=br.readLine();
						flg3=vali_date.valn(col);
					}while(flg3==false);

					boolean flgq=true;
					do
					{
						flgq=true;
						try
						{
							System.out.print("\n\t\t\t  Enter Weight in grams(without unit): ");
							prowt=Double.parseDouble(br.readLine());
						}
						catch(NumberFormatException o)
						{
							System.out.println("\t\t\tEnter Valid Number\n");
							flgq=false;
						}
					}while(prowt<0||flgq==false);

					scrsz=0.0;
					rm=0.0;
					stg=0.0;
					scrrs="";

					if(pid=="lp"||pid=="dc")
					{
						boolean flgq1=true;
						do
						{
							flgq1=true;
							try
							{
								System.out.print("\n\t\t\t  Enter Screen Size: ");
								scrsz=Double.parseDouble(br.readLine());
							}
							catch(NumberFormatException o)
							{
								System.out.println("\t\t\tEnter Valid Number\n");
								flgq1=false;
							}
						}while(scrsz<0||flgq1==false);

						boolean flgscr=true;
						do
						{
							flgscr=true;
							System.out.print("\n\t\t  Enter Screen Resolution(height pixels x width pixels): ");
							scrrs=br.readLine();
							flgscr=vali_date.valf(scrrs);
						}while(flgscr==false);

						boolean flgq2=true;
						do
						{
							flgq2=true;
							try
							{
								System.out.print("\n\t\t\t  Ram: ");
								rm=Double.parseDouble(br.readLine());
							}
							catch(NumberFormatException o)
							{
								System.out.println("\t\t\tEnter Valid Number\n");
								flgq2=false;
							}
						}while(rm<0||flgq2==false);
						boolean flgq3=true;
						do
						{
							flgq3=true;
							try
							{
								System.out.print("\n\t\t\t  Enter Storage: ");
								stg=Double.parseDouble(br.readLine());
							}
							catch(NumberFormatException o)
							{
								System.out.println("\t\t\tEnter Valid Number\n");
								flgq3=false;
							}
						}while(stg<0||flgq3==false);
					}

					boolean flgq4=true;
					do
					{
						flgq4=true;
						try
						{
							System.out.print("\n\t\t\t  Enter Price: ");
							cst=Double.parseDouble(br.readLine());
						}
						catch(NumberFormatException o)
						{
							System.out.println("\t\t\tEnter Valid Number\n");
							flgq4=false;
						}
					}while(cst<0||flgq4==false);

					boolean flgq5=true;
					do
					{
						flgq5=true;
						try
						{
							System.out.print("\n\t\t\t  Quantity: ");
							qt=Integer.parseInt(br.readLine());
						}
						catch(NumberFormatException o)
						{
							System.out.println("\t\t\tEnter Valid Number\n");
							flgq5=false;
						}
					}while(qt<0||flgq5==false);
			}

			catch(Exception e)
			{
				flg1=false;
				System.out.println("\n\t\t\t  Enter Valid Values\n");
				add_prods.add();
			}
		}while(flg1=false);

			pr.print(pid+pno+",");

			pr.print(comname+",");

			pr.print(col+",");

			pr.print(prowt+",");

			if(pid=="kb"||pid=="ms")
			{
				for(int i=1;i<=4;i++)
				{
					pr.print("NA"+",");
				}
			}
			else
			{
				pr.print(scrsz+",");

				pr.print(scrrs+",");

				pr.print(rm+",");

				pr.print(stg+",");
			}

			pr.print(cst+",");

			pr.print(qt);

			pr.println();

			do
			{
				System.out.print("\n\t\t\t  Add more products?(y/n)");
				ch1=vali_date.valid();
			}while(ch1!='y'&&ch1!='n');
		}while(ch1=='y');

		pr.close();
		mainstore.menu(0);
	}

}