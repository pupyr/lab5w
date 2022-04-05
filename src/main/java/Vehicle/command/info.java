package Vehicle.command;

import Vehicle.Root;

public class info extends AbsCommand
{
    @Override
    public void execute() {
        System.out.println("Тип коллекции-" + Root.getRoot().getClass() + "\nДата инициализации-" + Root.getDate() + "\nКол-во элементов-" + Root.getRoot().size());
    }
}