import java.io.*;
class mod_prods extends vali_date
{
	public static void mod(int cte)throws Exception
	{
		try
		{
				if(cte==1)
				{
					System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
				}

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pr=new PrintWriter(new FileWriter("temp.dat"));
			char ch='e';
			int ch1=0;
			do
			{
				cls();
				int ind=0;
				System.out.println("\t\t\t\t  MODIFY PRODUCTS");
				System.out.println("--------------------------------------------------------------------------------");
				boolean flg4=false;
				String pid="emp";
				do
				{
					vali_date.typ();
					System.out.print("\n\t\t\t  Enter ProductID: ");
					pid=br.readLine();
					BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
					String str1=fr.readLine();

					while(str1!=null)
					{
						String[] tmp=str1.split(",");
						if(pid.equals(tmp[0]))
						{
							flg4=true;
							break;
						}

						str1=fr.readLine();
					}
					fr.close();
				}while(flg4==false);

				BufferedReader fr1=new BufferedReader(new FileReader("products.dat"));
				boolean flgch=true;
				do
				{
					System.out.println("\n\t\t\t  What would you like to modify?:");
					System.out.println("\t\t\t  1) Cost");
					System.out.println("\t\t\t  2) Quantity");
					System.out.println("\t\t\t  3) Back to Stock Menu");
					System.out.println("\t\t\t  4) Exit");
					System.out.print("\n\t\t\t    Enter Choice: ");

					try
					{
						ch1=Integer.parseInt(br.readLine());
					}
					catch(Exception e)
					{
						flgch=false;
						System.out.println("\t\t\t  Enter Valid Choice");
					}
					switch(ch1)
					{
						case 1: ind=8;
						break;
						case 2: ind=9;
						break;
						case 3: mainstore.menu(0);
						break;
						case 4: System.exit(0);
						break;
					}
				}while(ch1<1||ch1>4||flgch==false);
				System.out.print("\n\t\t\t  Enter new value: ");
				double nval=0;
				int nval1=0;
				if(ind==8)
				{
					nval=Double.parseDouble(br.readLine());
				}
				if(ind==9)
				{
					nval1=Integer.parseInt(br.readLine());
				}
				do
				{
					System.out.print("\n\t\t\t  Are you sure you want to modify this?(y/n)");
					ch=(char)br.read();
					br.readLine();
					ch=Character.toLowerCase(ch);
				}while(ch!='y'&&ch!='n');
				if(ch=='y')
				{
					String str=fr1.readLine();
					boolean flg=false;
					while(str!=null)
					{
						String[] tmp=str.split(",");
						if(tmp[0].compareTo(pid)!=0)
						{
							pr.println(str);
						}
						else
						{
							if(nval!=0)
							{
								tmp[ind]=str.valueOf(nval);
							}
							else if(nval1!=0)
							{
								tmp[ind]=str.valueOf(nval1);
							}
							for(int i=0;i<tmp.length;i++)
							{
								if(i!=tmp.length-1)
								{
									pr.print(tmp[i]+",");
								}
								else
								{
									pr.print(tmp[i]);
								}
								}
								pr.println();
								flg=true;
							}
						str=fr1.readLine();
					}
					if(flg==false)
					{
						System.out.println("\n\t\t\t  Product Not Found");
					}
				}
			fr1.close();
			pr.close();
			File f1=new File("products.dat");
			File f2=new File("temp.dat");
			f1.delete();
			f2.renameTo(f1);
			do
			{
				System.out.print("\n\t\t\t  Modify more Records?(y/n)");
				ch=vali_date.valid();
			}while(ch!='y'&&ch!='n');
		}while(ch=='y');

		mainstore.menu(0);
	}
	catch(Exception e)
	{
		mod_prods.mod(1);
	}
	}


	public static void modi(String prod,int q)throws Exception
	{
			BufferedReader fr1=new BufferedReader(new FileReader("products.dat"));
			PrintWriter pr1=new PrintWriter(new FileWriter("temp.dat"));
			String str=fr1.readLine();
			String temp="emp";
			int val=q;
			while(str!=null)
			{
				String[] tmp=str.split(",");
				if(tmp[0].compareTo(prod)!=0)
				{
					pr1.println(str);
				}
				else
				{
					int val2=Integer.parseInt(tmp[9]);
					tmp[9]=str.valueOf(val2-val);
					for(int i=0;i<tmp.length;i++)
					{
						if(i!=tmp.length-1)
						{
							pr1.print(tmp[i]+",");
						}
						else
						{
							pr1.print(tmp[i]);
						}
					}
					pr1.println();
				}
				str=fr1.readLine();
			}
			pr1.close();
			fr1.close();
			File f1=new File("products.dat");
			File f2=new File("temp.dat");
			f1.delete();
			f2.renameTo(f1);
	}


}