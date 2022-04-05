package Vehicle.command;

import Vehicle.Root;
import java.util.Iterator;

public class removeMinMax extends AbsCommand implements Iterator
{
    int index=0;
    Long i;
    int size;
    boolean b;

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Long next() {
        b=true;
        while (b) {
            ++i;
            for ( Long l : Root.getRoot().keySet()) {
                if (l.equals(i)) {
                    b=false;
                    ++index;
                    break;
                }
            }
        }
        return i;
    }

    @Override
    public void remove() {
        Root.getRoot().remove(i);
    }

    @Override
    public void execute3( String s,  Long l) {
        index = 0;
        i = 0L;
        size = Root.getRoot().size();
        if (s.equals("min")) {
            while (hasNext()) {
                if (l > next()) {
                    remove();
                }
            }
        }
        if (s.equals("max")) {
            while (hasNext()) {
                if (l < next()) {
                    remove();
                }
            }
        }
    }
}