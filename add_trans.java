import java.io.*;
class add_trans extends vali_date
{
	public static int extra()throws Exception
	{
		boolean fileflg=false;
		boolean flg=false;
		int a=0;
		File f=new File("transacs.dat");
		if(f.exists()==true)
		{
			fileflg=true;
		}
		else
		{
			flg=true;
			PrintWriter pr3=new PrintWriter(new FileWriter("transacs.dat"));
			pr3.close();
			a=1;
		}
		if(fileflg==true)
		{
			BufferedReader fr=new BufferedReader(new FileReader("transacs.dat"));

			String str=fr.readLine();

			if(str==null)
			{
				flg=true;
			}

			else
			{
				while(str!=null)
				{
					String []str1=str.split(",");
					a=Integer.valueOf(str1[0])+1;
					str=fr.readLine();
				}
			}
			fr.close();
		}
		return a;
	}

	public static void adtr(int cte)throws Exception
	{
		try
		{
			String prod="empty";
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pr=new PrintWriter(new FileWriter("transacs.dat",true));

			char ch='o';
			do
			{
				cls();
				if(cte==1)
				{
				System.out.println("\t\t\t\t  An Error Occured. Please Try Again\n");
				}

				int q=0;

				int serno=add_trans.extra();



				boolean flg=false;
				do
				{
					cls();
					System.out.println("\t\t\t\tADD TRANSACTIONS");
					System.out.println("--------------------------------------------------------------------------------\n\n");
					vali_date.typ();
					System.out.print("\n\t\t\t  Enter ProductID: ");
					prod=br.readLine();
					BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
					String str1=fr.readLine();
					String []tmp=new String[10];
					while(str1!=null)
					{
						String []tmp1=str1.split(",");
						tmp=tmp1;
						if(prod.equals(tmp[0]))
						{
							flg=true;
							break;
						}
						str1=fr.readLine();
					}
					fr.close();
				}while(flg==false);

				String dt=vali_date.val();

				String nm="empty";
				boolean fnmflg=true;
				do
				{

					System.out.print("\n\t\t\t  Enter First Name: ");
					nm=br.readLine();
					if(nm==null)
					{
						fnmflg=false;
					}
					else
					{
						fnmflg=vali_date.valn(nm);
					}

				}while(fnmflg==false);

				String lnm="empty";
				boolean lmflg=true;
				do
				{

					System.out.print("\n\t\t\t  Enter Last Name: ");
					lnm=br.readLine();
					lmflg=vali_date.valn(lnm);

				}while(lmflg==false);

				boolean flg1=true;

				flg1=true;

				try
				{
					BufferedReader fr3=new BufferedReader(new FileReader("products.dat"));
					String str2="em";
					int tp2=0;
					String[] tmp1=new String[10];
					do
					{
						String str28=fr3.readLine();
						String[] tmp=str28.split(",");
						int tp1=Integer.parseInt(tmp[9]);
						tp2=tp1;
						tmp1=tmp;
					}while(tmp1[0].equals(prod)==false);


					System.out.print("\n\t\t\t Available Quantity: "+tp2);
					System.out.print("\n\t\t\t  Enter Quantity: ");
					q=Integer.parseInt(br.readLine());

					fr3.close();
				}

				catch(NumberFormatException e)
				{
					flg1=false;
				}
				BufferedReader fr1=new BufferedReader(new FileReader("products.dat"));
				if(q<1)
				{
					flg1=false;
					System.out.println("\n\t\t\t  Invalid Quantity");
				}
				String str1=fr1.readLine();
				while(str1!=null)
				{
					String[] tmp=str1.split(",");
					int tp=Integer.parseInt(tmp[9]);
					if(prod.compareTo(tmp[0])==0)
					{
						if(tp<q)
						{
							flg1=false;
							System.out.println("\n\t\t\t  Invalid Quantity");
							fr1.close();
							pr.close();
							break;
						}
						else if(tp>=q)
						{
							fr1.close();


							double cst=1;
							BufferedReader fr2=new BufferedReader(new FileReader("products.dat"));

							String str=fr2.readLine();

							while(str!=null)
							{
								String []tmpq=str.split(",");

								if(tmp[0].compareTo(prod)!=0)
								{
									str=fr2.readLine();
								}
								else
								{
									cst=Double.parseDouble(tmpq[8]);
									break;
								}
								fr2.close();
							}
							double tocst=q*cst;


							pr.print(serno+",");
							pr.print(dt+",");
							pr.print(nm+",");
							pr.print(lnm+",");
							pr.print(prod+",");
							pr.print(q+",");
							pr.print(tocst);
							pr.println();

							pr.close();
							fr2.close();
							mod_prods.modi(prod,q);

							break;
						}
					}
					else
					{
						str1=fr1.readLine();
					}
				}

				do
				{
					System.out.print("\n\t\t\t  Add more transactions?(y/n)");
					ch=vali_date.valid();
				}while(ch!='y'&&ch!='n');
			}while(ch=='y');


		}
		catch(Exception e)
		{
			add_trans.adtr(1);

		}
	}
}
