package Vehicle.command;

public class print_ascending extends AbsCommand
{
    @Override
    public void execute() {
        sort.sorting(false);
    }
}