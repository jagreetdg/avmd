public class UnexpectedAbortionException extends RuntimeException
{
    public static int errorCount = 0;
    String str="";
    public UnexpectedAbortionException()
    {
        super();
        errorCount++;
    }
    public UnexpectedAbortionException(String s)
    {
        super();
        str = s+"\n";
        errorCount++;
    }
    public String toString()
    {
        return (str+"An Unexpected Error Occured Which Caused The Current Operation To Terminate");
    }
}