package Vehicle.command;

import Vehicle.Vehicle;

public interface IntCommand
{
    void execute();

    Vehicle execute1();

    void execute2( String p0);

    void execute3( String p0,  Long p1);
}