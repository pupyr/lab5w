package Vehicle.command;

import Vehicle.Root;

public class info extends AbsCommand
{
    @Override
    public void execute() {
        System.out.println("��� ���������-" + Root.getRoot().getClass() + "\n���� �������������-" + Root.getDate() + "\n���-�� ���������-" + Root.getRoot().size());
    }
}