package lojadetelemoveis;
import java.text.DateFormat;
import java.util.Date;
public class Data {
    private final Date date = new Date();
    String data = java.text.DateFormat.getDateInstance(DateFormat.LONG).format(date);
    
    public String getData () 
    {
        return (data);
    }
    
    public int nVendas (String d) 
    {
        int n = 0;
        return (n);
    }
}
