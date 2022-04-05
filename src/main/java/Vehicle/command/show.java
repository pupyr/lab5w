package Vehicle.command;

import Vehicle.Root;

public class show extends AbsCommand
{
    @Override
    public void execute() {
        System.out.println(Root.write(0));
    }
}