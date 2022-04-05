package Vehicle.command;

import Vehicle.Vehicle;

public class Developer
{
    private static boolean scriptStart=false;
    IntCommand help;
    IntCommand info;
    IntCommand show;
    IntCommand creator;
    IntCommand clear;
    IntCommand script;
    IntCommand numOfWheels;
    IntCommand print;
    IntCommand min;
    IntCommand delete;

    public static boolean isScriptStart() {
        return Developer.scriptStart;
    }

    public static void setScriptStart(final boolean scriptStart) {
        Developer.scriptStart = scriptStart;
    }

    public Developer(IntCommand help, IntCommand info, IntCommand show, IntCommand creator, IntCommand clear, IntCommand script, IntCommand numOfWheels, IntCommand print, IntCommand min, IntCommand delete) {
        this.help = help;
        this.info = info;
        this.show = show;
        this.creator = creator;
        this.clear = clear;
        this.script = script;
        this.numOfWheels = numOfWheels;
        this.print = print;
        this.min = min;
        this.delete = delete;
    }

    public void help() {
        this.help.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public void info() {
        this.info.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public void show() {
        this.show.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public void clear() {
        this.clear.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public Vehicle creator() {
        return this.creator.execute1();
    }

    public void script(String s) {
        this.script.execute2(s);
    }

    public void numOfWheels() {
        this.numOfWheels.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public void print() {
        this.print.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public void min() {
        this.min.execute();
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

    public void deleteMin(String s,Long l) {
        this.delete.execute3(s, l);
        if (!Developer.scriptStart) {
            System.out.println("Команда успешно выполнена");
        }
    }

}