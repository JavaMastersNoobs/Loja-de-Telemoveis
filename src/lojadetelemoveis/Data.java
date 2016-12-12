package lojadetelemoveis;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static lojadetelemoveis.Ler.umaString;
public class Data implements Serializable {
    private Date date;
    
    public Data()
    {
        date = new Date();
    }
    public Data(Date d)
    {
        date = d;
    }
    public String getData () 
    {
        return java.text.DateFormat.getDateInstance(DateFormat.SHORT).format(date);
    }
    
    public int nVendas (String d) 
    {
        int n = 0;
        return (n);
    }
    
}
