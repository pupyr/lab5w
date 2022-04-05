package Vehicle.command;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import Vehicle.IO;
import java.util.Scanner;
import java.io.FileReader;
import java.util.List;

public class script extends AbsCommand
{
    static boolean recursion=false;
    static List<String> scriptName=new ArrayList<>();

    @Override
    public void execute2( String s) {
        try ( Scanner scanner = new Scanner(new FileReader(s))) {
            script.scriptName.add(s);
            int i = 0;
            while (scanner.hasNext()) {
                Developer.setScriptStart(true);
                 String[] ss = scanner.nextLine().split(" ");
                for ( String q : script.scriptName) {
                    if (ss.length > 1 && q.equals(ss[1])) {
                        ++i;
                    }
                }
                if (i == 0 && !script.recursion) {
                    IO.coma(ss);
                }
                else {
                    if (i != 0 && !script.recursion) {
                        System.out.println("¬веден рекурсивный скрипт с зацикливанием");
                        script.recursion = true;
                        break;
                    }
                }
            }
            if (!script.recursion) {
                System.out.println("скрипт успешно выполнен");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("¬ведите верное им€ скрипта");
        }
        Developer.setScriptStart(false);
    }


}