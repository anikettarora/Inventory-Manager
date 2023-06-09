import java.io.*;
import java.text.*;
import java.util.*;
class vali_date
{
	public static void cls()throws Exception
	{
		//new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		System.out.print("\033[H\033[2J");  
    	System.out.flush(); 
	}
	public static String val()
	{
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		String dt=dateFormat.format(date);
		String dt1="k";
		try
		{
			String y=dt.substring(0,4);
			String m=dt.substring(5,7);
			String d=dt.substring(8,10);
			dt1=d+"/"+m+"/"+y;
		}
		catch(Exception e)
		{
			System.out.println("Invalid Date");
		}
		return dt1;
	}

	 public static boolean valn(String name)
	{
		int l=name.length();
		boolean flg=false;
		if(l==0)
		{
			flg=true;;
		}

		for(int i=0;i<l;i++)
		{
			char a=name.charAt(i);
			if(Character.isLetter(a)==false)
			{
				flg=true;
			}
		}
		if(flg==false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean valf(String scrs)
	{
		boolean flg=true;
		int xcnt=0;
		if(scrs.length()<3)
		{
			flg=false;
		}
		if(Character.isDigit(scrs.charAt(0))==false||Character.isDigit(scrs.charAt(scrs.length()-1))==false)
		{
			flg=false;
		}
		for(int i=1;i<scrs.length()-1;i++)
		{

			if(Character.isDigit(scrs.charAt(i))==false&&scrs.charAt(i)!='x')
			{
				flg=false;
				break;
			}
			if(scrs.charAt(i)=='x')
			{
				xcnt++;

			}

		}
		if(xcnt!=1)
		{
			flg=false;
		}
		return flg;
	}
	public static char valid()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char ch='y';
		boolean b=true;
		do
		{
			b=true;
			String sch=br.readLine();
			sch=sch.toLowerCase();
			if(sch.length()>1)
			{
				System.out.print("\t\tPlease enter either 'y' or 'n'");
				b=false;
			}
			else if(sch.length()==1)
			{
				if(sch.charAt(0)=='y' || sch.charAt(0)=='n')
				{
					b=true;
					ch=sch.charAt(0);
				}
				else
				{
					System.out.print("Please enter either 'y' or 'n'");
					b=false;
				}
			}
		}while(b==false);
		return ch;
	}

	public static void typ()throws Exception
	{

			BufferedReader fr=new BufferedReader(new FileReader("products.dat"));

			String str=fr.readLine();

			while(str!=null)
			{
				String []tmp=str.split(",");
				System.out.println("\n\t\t\tProductID: "+tmp[0]);
				str=fr.readLine();
				System.out.println();
			}
			fr.close();
	}
}

