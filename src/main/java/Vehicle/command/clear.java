package Vehicle.command;

import Vehicle.Root;

public class clear extends AbsCommand
{
    @Override
    public void execute() {
        Root.getRoot().clear();
    }
}
