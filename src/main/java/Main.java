import Vehicle.IO;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.util.NoSuchElementException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) throws ParserConfigurationException, SAXException {

        try{
            IO.call(args[0]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("¬ведите им€ файла в командную строку");
        }
    }
}