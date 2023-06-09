import java.io.*;
class del_prods extends vali_date
{
	public static void del(int cte)throws Exception
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
			BufferedReader fr=new BufferedReader(new FileReader("products.dat"));
			PrintWriter pr=new PrintWriter(new FileWriter("temp.dat",true));
			char ch='o';
			do
			{
				cls();
				String pid="as";
				System.out.println("\t\t\t\t	Delete Products");
				System.out.println("--------------------------------------------------------------------------------\n\n");
				vali_date.typ();
				System.out.print("\n\t\t\t  Enter Product ID for deletion: ");
				String proid=br.readLine();
				String str=fr.readLine();
				char ch1='l';
				do
				{
					System.out.print("\t\t\tAre you sure you wish to delete this record?(y/n): ");
					ch1=vali_date.valid();
				}while(ch1!='y'&&ch1!='n');
				if(ch1=='y')
				{
					boolean flg=false;
					while(str!=null)
					{
						String[] tmp=str.split(",");
						if(tmp[0].compareTo(proid)!=0)
						{
							pr.println(str);
						}
						else
						{
							flg=true;
						}
						str=fr.readLine();
					}
					if(flg==false)
					{
						System.out.println("\n\t\t\t  Product Not Found");
					}
				}
					do
					{
						System.out.print("\n\n\t\t\t Delete more Records?(y/n): ");
						ch=vali_date.valid();
					}while(ch!='y'&&ch!='n');
			}while(ch=='y');
			pr.close();
			fr.close();
			File f1=new File("products.dat");
			File f2=new File("temp.dat");
			f1.delete();
			f2.renameTo(f1);
			mainstore.menu(0);
		}
		catch(Exception e)
		{
			del_prods.del(1);
		}
	}
}

