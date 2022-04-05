package Vehicle.command;


import Vehicle.Root;

public class numOfWheels extends AbsCommand
{
    @Override
    public void execute() {
        float f = 0.0f;
        int i = 0;
        for (Long l : Root.getRoot().keySet()) {
            if (Root.getRoot().get(l).getNumberOfWheels() != null) {
                f += Root.getRoot().get(l).getNumberOfWheels();
                ++i;
            }
        }
        System.out.println(f / i);
    }
}
