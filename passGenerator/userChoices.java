package passGenerator;

import java.io.Console;
import java.util.Scanner;

public class userChoices {
	
	Scanner ne= new Scanner(System.in);
	private boolean isCreatePass=false;
	private boolean isPassStrengthCheck=false;
	private int passLength=8;
	private boolean isNum=false;
	private boolean isSymbols=false;
	private StringBuilder fomo=new StringBuilder();
	
	private generator generator;
	public String userIp()
	{
		
		isCreatePass=ne.nextBoolean();
		if(isCreatePass)
		{
			System.out.println("Provide pass length (default-8) /n");
			passLength=ne.nextInt();
			ne.nextLine();
			System.out.println("Do u want Nums in ur pass? - true/false (default-false) /n");
			isNum= ne.nextBoolean();
			System.out.println("Do u want Symbols in ur pass? - true/false (default-false) /n");
			isSymbols= ne.nextBoolean();
			
//			for(int i=0;i<100;i++)
//			{
//				System.out.println();
//			}
			
			return createPass( passLength,  isCreatePass,  isNum, isSymbols);
			
		}
		else
		{
			Console console=System.console();
			if(console ==null)
			{
				System.out.println("Console is not available..");
				System.exit(1);
			}
			System.out.println("Provide Pass to validate strength: /n");
			validatePass(new String(console.readPassword("password")));
		}
		ne.close();
	}
	
	private final String createPass(int passLength, boolean isCreatePass, boolean isNum,boolean isSymbols)
	{
		return generator.generatePass(passLength, isCreatePass, isNum, isSymbols);
	}
	
	private final String validatePass(String pass)
	{
		return "";
	}
}
