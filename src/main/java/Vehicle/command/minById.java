package Vehicle.command;

import Vehicle.Root;

public class minById extends AbsCommand
{
    @Override
    public void execute() {
        if (Root.getRoot().size() > 0) {
            Long[] L = Root.getRoot().keySet().toArray(new Long[0]);
            Long l0 = L[0];
            for (Long i : Root.getRoot().keySet()) {
                if (l0 > i) {
                    l0 = i;
                }
            }
            System.out.println(Root.getRoot().get(l0).write(0));
        }
        else {
            System.out.println("Список пуст");
        }
    }
}