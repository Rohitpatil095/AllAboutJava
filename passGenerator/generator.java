package passGenerator;
import java.util.Random;

public class generator {

    private static final String chars="ABCDEFGHIJKLMOPQRSTUVXYZabcdefghijklopqrstuvwxyz";
    private static final String symbols="~`!@#$%^&*-_:?";
    private static final String nums="0123456789";
    private StringBuilder str=new StringBuilder();
    private StringBuilder pass=new StringBuilder();
    
//    public generator()
//    {
//        generatePass(8, true, false, false);
//    }

//    public generator(int length, boolean isChars, boolean isNums, boolean isSymbols)
//    {
//        generatePass(length,isChars,isNums,isSymbols);
//    }

    public String password(int length,boolean isChars,boolean isNums,boolean isSymbols )
    {
    	return generatePass( length, isChars, isNums, isSymbols);
    }
    
    protected final String generatePass(int length, boolean isChars,boolean isNums,boolean isSymbols)
    {
        prepareStr(isChars,isNums,isSymbols);
        Random random= new Random();
        int ra=0;

        for(int i=0;i<length;i++)
        {
            ra=random.nextInt(str.length());
            pass.append(str.charAt(ra));
        }
        
        return pass.toString();
    }
    
    private final void prepareStr(boolean isChars,boolean isNums,boolean isSymbols)
    {

        if(isChars)
        {
            str.append(chars);
        }
        if(isNums)
        {
            str.append(nums);
        }
        if(isSymbols)
        {
            str.append(symbols);
        }
    }
}
