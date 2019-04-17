public class Sum {
    public String sum (String str1, String str2)
    {
        try{
            Integer first = Integer.valueOf(str1);
            Integer second = Integer.valueOf(str2);
            Integer result =first+second;
            return String.valueOf(result);
        }catch (NumberFormatException e)
        {
            System.out.println(e);
        }
        return "NA";
    }
}
