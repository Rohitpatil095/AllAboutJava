package passGenerator;

import java.io.Console;
import java.util.Scanner;

public class userChoices {
	
	protected Scanner ne= new Scanner(System.in);
	private boolean isCreatePass=false;
	private int passLength=8;
	private boolean isNum=false;
	private boolean isSymbols=false;
	private StringBuilder fomo=new StringBuilder();
	
	private generator generator;
	public String userIp()
	{
		System.out.println("Make ur choice :-");
		System.out.println("1)create pass \n 2)analyze pass strength \n");
		System.out.println("Type ur choice:- ");
		int choice= ne.nextInt();
		ne.nextLine();
		
		String defaultAnswer="";
		switch(choice)
		{	
			case(1):
				return askCreatePassQuestions();
			case(2):
				return askPassStrengthQuestions();
			default:
				defaultAnswer="U need to make a choice";
				break;
		}
		return defaultAnswer;
	}
	
	private final String askCreatePassQuestions()
	{
		System.out.println("Provide pass length (default-8) \n");
		passLength=ne.nextInt();
		ne.nextLine();
		System.out.println("Do u want Nums in ur pass? - true/false (default-false) \n");
		isNum= ne.nextBoolean();
		System.out.println("Do u want Symbols in ur pass? - true/false (default-false) \n");
		isSymbols= ne.nextBoolean();
		
		return createPass( passLength,  isCreatePass,  isNum, isSymbols);
	}
	

	private final String askPassStrengthQuestions()
	{
		Console console=System.console();
		if(console ==null)
		{
			System.out.println("Console is not available..");
			System.exit(1);
		}
		System.out.println("Provide Pass to validate strength: \n");
		return Integer.toString(validatePass(new String(console.readPassword("password"))));
		
	}
	
	
	private final String createPass(int passLength, boolean isCreatePass, boolean isNum,boolean isSymbols)
	{
		return generator.password(passLength, isCreatePass, isNum, isSymbols);
	}
	
	private final int validatePass(String pass)
	{
		strengthAnalyser sAnalyzer= new strengthAnalyser();
		return sAnalyzer.checkScore(pass);
	}
}
