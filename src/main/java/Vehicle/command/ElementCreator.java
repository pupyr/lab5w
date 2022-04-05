package Vehicle.command;

import Vehicle.FuelType;
import Vehicle.VehicleType;
import java.util.Date;
import Vehicle.Coordinates;
import Vehicle.Root;
import java.util.Scanner;
import Vehicle.Vehicle;

public class ElementCreator extends AbsCommand
{
    String s;
    Vehicle vehicle;
    Long Lmax;

    public ElementCreator() {
        this.vehicle = new Vehicle();
        this.Lmax = 0L;
    }

    @Override
    public Vehicle execute1() {
        Scanner scanner = new Scanner(System.in);
        for (Long l : Root.getRoot().keySet()) {
            if (this.Lmax < Root.getRoot().get(l).getId()) {
                this.Lmax = Root.getRoot().get(l).getId();
            }
        }
        this.vehicle.setId(this.Lmax + 1L);
        System.out.println("¬ведите им€");
        while (true) {
            this.s = scanner.nextLine();
            if (!this.s.equals("")) {
                break;
            }
            System.out.println("неверный тип данных");
        }
        this.vehicle.setName(this.s);
        System.out.println("¬ведите координаты");
        Coordinates coordinates = new Coordinates();
        System.out.println("¬ведите x");
        while (true) {
            this.s = scanner.nextLine();
            try {
                coordinates.setX(Float.parseFloat(this.s));
                if (Float.parseFloat(this.s) < 286.0f) {
                    break;
                }
                System.out.println("х должен быть меньше 286");
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных");
            }
        }
        System.out.println("¬ведите y");
        while (true) {
            this.s = scanner.nextLine();
            try {
                coordinates.setY(Double.parseDouble(this.s));
                if (Double.parseDouble(this.s) < 53.0) {
                    break;
                }
                System.out.println("у должен быть меньше 53");
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных");
            }
        }
        this.vehicle.setCoordinates(coordinates);
        this.vehicle.setCreationDate(new Date());
        System.out.println("¬ведите силу двигател€");
        while (true) {
            this.s = scanner.nextLine();
            try {
                if (this.s.equals("")) {
                    this.vehicle.setEnginePower(null);
                }
                else if (Float.parseFloat(this.s) > 0.0f) {
                    this.vehicle.setEnginePower(Float.parseFloat(this.s));
                }
                else {
                    System.out.println("сила двигател€ должна быть больше 0");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных");
                continue;
            }
            break;
        }
        System.out.println("¬ведите кол-во колес");
        while (true) {
            this.s = scanner.nextLine();
            try {
                if (this.s.equals("")) {
                    this.vehicle.setNumberOfWheels(null);
                }
                else if (Integer.parseInt(this.s) > 0) {
                    this.vehicle.setNumberOfWheels(Integer.parseInt(this.s));
                }
                else {
                    System.out.println("кол-во колес должно быть больше 0");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных");
                continue;
            }
            break;
        }
        System.out.println("¬ведите тип транспорта:\n    CAR,\n    PLANE,\n    DRONE,\n    MOTORCYCLE,\n    SPACESHIP");
        while (true) {
            this.s = scanner.nextLine();
            if (this.s.equals("")) {
                this.vehicle.setType(null);
                break;
            }
            if (this.s.equals("CAR") | this.s.equals("PLANE") | this.s.equals("DRONE") | this.s.equals("MOTORCYCLE") | this.s.equals("SPACESHIP")) {
                this.vehicle.setType(VehicleType.valueOf(this.s));
                break;
            }
            System.out.println("неверный тип данных");
        }
        System.out.println("¬ведите тип топлива\n    ELECTRICITY,\n    NUCLEAR,\n    ANTIMATTER");
        while (true) {
            this.s = scanner.nextLine();
            if (this.s.equals("ELECTRICITY") | this.s.equals("NUCLEAR") | this.s.equals("ANTIMATTER")) {
                break;
            }
            System.out.println("неверный тип данных");
        }
        this.vehicle.setFuelType(FuelType.valueOf(this.s));
        if (!Developer.isScriptStart()) {
            System.out.println(" оманда успешно выполнена");
        }
        return this.vehicle;
    }
}