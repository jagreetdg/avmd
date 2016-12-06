public class MaxLimitReachedException extends Exception
{
    public String toString()
    {
        return "Maximum Limit For Current Variable Is Reached";
    }
}