import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/*
public class Database
{
	private static Database instance;
	ArrayList<Account> account = new ArrayList<Account>();

	public static Database getInstance()
	{
		if(instance==null)
		{
			instance=new Database();
		}
		return instance;
	}
	
	Account getAccount(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
	Account getAccount(String n, String p)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n) && account.get(i).getPIN().equals(p))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
	void addNewAccount(Account ac)
	{
		this.account.add(ac);
	}
	
	boolean isAccountNumberUnique(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n))
			{
				return false;
			}
		}
		
		return true;
	}
	
	void saveData()
	{
		String key=Long.toString(System.currentTimeMillis());
		//String key=Character.toString('1');
		try
		{
			Encryption encr=new Encryption();
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("AccountList.txt")));
			bw.write(key+'\n');
			for(int i=0;i<account.size();i++)
			{
				bw.write(encr.encrypt(String.valueOf(account.get(i)),key));
				System.out.println(account.get(i));
			}
			bw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("saved");
	}
	
	void printAccounts()
	{
		/*for(int i=0;i<account.size();i++)
		{
			System.out.println(account.get(i).getAccuntNo() +" "+ account.get(i).getPIN());
		}
	}
	
	void loadData()
	{
		try
		{
			//BufferedReader br = new BufferedReader(new FileReader(new File("AccountList.txt")));
			FileReader fr = new FileReader("AccountList.txt");
			Encryption encr=new Encryption();
			String type,datastr="",key="";
			int i;
			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
			//key=Character.toString((char)1);
			while ((i = fr.read()) != (int)'\n')
            	if(i!=13)
					key+=(char)i;
			/*System.out.println("\nReached after key: "+key+" \nlen = "+key.length());
			for(int si=0;si<key.length();si++)
			{
				System.out.println((int)key.charAt(si));
			}
			i=-1;
			System.out.println(key);
			while ((i = fr.read()) != -1)
            	datastr+=(char)i;
			/*System.out.println(datastr+"\n\n");
			for(int si=0;si<datastr.length();si++)
			{
				System.out.println((int)datastr.charAt(si));
			}
			System.out.println("\n\n");
			//datastr=encr.decrypt(datastr,key);
			System.out.println(datastr);
			/*for(int si=0;si<datastr.length();si++)
			{
				System.out.println((int)datastr.charAt(si));
			}
			int c=0;
			String data[]=datastr.split("\n");
			/*for(int si=0;si<data[0].length();si++)
			{
				System.out.println((int)data[0].charAt(si));
			}
			System.out.println("Hello "+data.length);
			while(c<data.length && data.length>1 )
			{
				type=data[c++];
				Account ac;
				if(type.equals(String.valueOf(Account.SAVINGS_ACCOUNT)))
				{
					ac=new SavingsAccount(data[c++],data[c++],Double.parseDouble(data[c++]),
							new UserInformation(data[c++], data[c++], data[c++], data[c++], data[c++],
									data[c++], data[c++], data[c++], df.parse(data[c++])));
					ac.isActivated=Boolean.getBoolean(data[c++]);
				}
				else
				{
					ac=new CurrentAccount(data[c++],data[c++],Double.parseDouble(data[c++]),
							new UserInformation(data[c++], data[c++], data[c++], data[c++], data[c++],
									data[c++], data[c++], data[c++], df.parse(data[c++])));
					ac.isActivated=Boolean.getBoolean(data[c++]);
				}
				addNewAccount(ac);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{	
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Database
{
	private static Database instance;
	ArrayList<Account> account = new ArrayList<Account>();

	public static Database getInstance()
	{
		if(instance==null)
		{
			instance=new Database();
		}
		return instance;
	}
	
	Account getAccount(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
	Account getAccount(String n, String p)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n) && account.get(i).getPIN().equals(p))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
	void addNewAccount(Account ac)
	{
		this.account.add(ac);
	}
	
	boolean isAccountNumberUnique(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n))
			{
				return false;
			}
		}
		
		return true;
	}
	
	void saveData()
	{
		//String key=Character.toString('1');
		try
		{
			Encryption encr=new Encryption();
			String key=Long.toString(System.currentTimeMillis()),encstr="";
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("AccountList.txt")));
			bw.write(key+'\n');
			for(int i=0;i<account.size();i++)
			{
				encstr+=String.valueOf(account.get(i));
				//System.out.println(account.get(i));
			}
			encstr=encr.encrypt(encstr,key);
			bw.write(encstr);
			bw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("saved");
	}
	
	void printAccounts()
	{
		/*for(int i=0;i<account.size();i++)
		{
			System.out.println(account.get(i).getAccuntNo() +" "+ account.get(i).getPIN());
		}*/
	}
	
	void loadData()
	{
		try
		{
			//BufferedReader br = new BufferedReader(new FileReader(new File("AccountList.txt")));
			FileReader fr = new FileReader("AccountList.txt");
			Encryption encr=new Encryption();
			String type,datastr="",key="";
			int i;
			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
			//key=Character.toString((char)1);
			/*System.out.println("\nReached after key: "+key+" \nlen = "+key.length());
			for(int si=0;si<key.length();si++)
			{
				System.out.println((int)key.charAt(si));
			}*/
			i=fr.read();
			while (i!=-1 && i!='\n')
            {	key+=(char)i;
				i=fr.read();}
			while ((i = fr.read()) != -1)
            	datastr+=(char)i;
			/*System.out.println(datastr+"\n\n");
			for(int si=0;si<datastr.length();si++)
			{
				System.out.println((int)datastr.charAt(si));
			}
			System.out.println("\n\n");*/
			//datastr=encr.decrypt(datastr,key);
			datastr=encr.decrypt(datastr,key);
			//System.out.println(datastr);
			/*for(int si=0;si<datastr.length();si++)
			{
				System.out.println((int)datastr.charAt(si));
			}*/
			int c=0;
			String data[]=datastr.split("\n");
			/*for(int si=0;si<data[0].length();si++)
			{
				System.out.println((int)data[0].charAt(si));
			}
			System.out.println("Hello "+data.length);*/
			while(c<data.length && data.length>1 )
			{
				type=data[c++];
				Account ac;
				if(data[c]!=""){
				if(type.equals(String.valueOf(Account.SAVINGS_ACCOUNT)))
				{
					ac=new SavingsAccount(data[c++],data[c++],Double.parseDouble(data[c++]),
							new UserInformation(data[c++], data[c++], data[c++], data[c++], data[c++],
									data[c++], data[c++], data[c++], df.parse(data[c++])));
					ac.isActivated=Boolean.getBoolean(data[c++]);
				}
				else
				{
					ac=new CurrentAccount(data[c++],data[c++],Double.parseDouble(data[c++]),
							new UserInformation(data[c++], data[c++], data[c++], data[c++], data[c++],
									data[c++], data[c++], data[c++], df.parse(data[c++])));
					ac.isActivated=Boolean.getBoolean(data[c++]);
				}
				addNewAccount(ac);
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{	
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
