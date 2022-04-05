package Vehicle;

import java.io.*;
import java.util.Objects;
import Vehicle.command.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParserFactory;
import java.util.Date;

public class IO
{
    static String name;
    static String[] s=new String[6];
    static boolean b=false;
    static boolean bb=false;

    public static void save() {
        StringBuilder s = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n");
        s.append(Root.write(1));
        s.append("\n").append("</root>");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(IO.name))) {
            writer.write(String.valueOf(s));
            bb=true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void call( String s) throws ParserConfigurationException, SAXException {
        Root.setDate(new Date());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        try {
            if(!s.endsWith(".xml")){s+=".xml";}
            File file=new File("C:\\Users\\admin\\IdeaProjects\\lab5_1.8\\"+s);
            if(file.createNewFile()){
                IO.name= s;
                save();
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(s));
            parser.parse(bufferedInputStream, handler);
            IO.name = s;
            sort.sorting(true);
            IO.b = true;
        }
        catch (IOException | SAXException e) {
            System.out.println("В файле некорректные данные");
        }
        if (IO.b) {
            while(true) {
                try {
                    System.out.println("Введите команду");
                    String ss = reader.readLine();
                    String[] command = new String[0];
                    int i = 1;
                    while (true) {
                        try {
                            if (i == 1) {
                                command = ss.split(" ");
                                coma(command);
                            }
                            i = 0;
                            if (command[0].equals("exit")) {
                                System.out.println("работа с xml окончена");
                                reader.close();
                                System.exit(0);
                            }
                            System.out.println("Введите команду");
                            command = reader.readLine().split(" ");
                            coma(command);
                        } catch (NullPointerException e) {
                            System.out.println("Введен EoF(символ конца ввода).");
                            reader = new BufferedReader(new InputStreamReader(System.in));
                        }
                    }
                } catch (IOException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Введена пустая строка");
                }
            }
        }
    }

    public static void coma( String[] command) {
        IO.s[4] = command[0];
         Developer developer = new Developer(new help(),new info(),new show(),new ElementCreator(),new clear(),new script(),new numOfWheels(),new print_ascending(),new minById(),new removeMinMax());
         String s2 = Objects.requireNonNull(command)[0];
        switch (s2) {
            case "help": {
                developer.help();
                break;
            }
            case "info": {
                developer.info();
                break;
            }
            case "show": {
                developer.show();
                break;
            }
            case "insert": {
                try {
                    Root.add(Long.parseLong(command[1]), developer.creator());
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Введен неверный ключ и тело");
                }
                break;
            }
            case "update": {
                boolean b = true;
                try {
                    for ( Long l : Root.getRoot().keySet()) {
                        if (l == Long.parseLong(command[1])) {
                            Root.add(l, developer.creator());
                        }
                        b = false;
                    }
                    if (b) {
                        System.out.println("Введен неверный ключ");
                    }
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Введен неверный ключ и тело");
                }
                if(!Developer.isScriptStart()) System.out.println("Команда успешно выполнена");
                break;
            }
            case "remove_key": {
                try {
                    boolean b = true;
                    for ( Long l : Root.getRoot().keySet()) {
                        if (l == Long.parseLong(command[1])) {
                            Root.getRoot().remove(Long.parseLong(command[1]));
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        System.out.println("Введен неверный ключ");
                    }else{
                        if(!Developer.isScriptStart()) System.out.println("Команда успешно выполнена");
                    }
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Введен неверный ключ");
                }
                break;
            }
            case "clear": {
                developer.clear();
                break;
            }
            case "save": {
                save();
                if(bb) System.out.println("Команда успешно выполнена");
                bb=false;
                break;
            }
            case "execute_script": {
                try {
                    developer.script(command[1]);
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Введено неверное имя файла");
                }
                break;
            }
            case "history": {
                for ( String s1 : IO.s) {
                    if (s1 != null) {
                        System.out.println(s1);
                    }
                }
                if(!Developer.isScriptStart()) System.out.println("Команда успешно выполнена");
                break;
            }
            case "average_of_number_of_wheels": {
                developer.numOfWheels();
                break;
            }
            case "min_by_id": {
                developer.min();
                break;
            }
            case "print_ascending": {
                developer.print();
                break;
            }
            case "remove_lower_key": {
                try {
                    developer.deleteMin("min", Long.parseLong(command[1]));
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Введен неверный ключ");
                }
                break;
            }
            case "remove_greater_key": {
                try {
                    developer.deleteMin("max", Long.parseLong(command[1]));
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Введен неверный ключ");
                }
                break;
            }
            default: {
                System.out.println("Введена несуществующая команда. Введите help для справки.");
                break;
            }
        }
        for (int i = 0; i < 5; ++i) {
            IO.s[i] = IO.s[i + 1];
        }
    }

}