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
        System.out.println("������� ���");
        while (true) {
            this.s = scanner.nextLine();
            if (!this.s.equals("")) {
                break;
            }
            System.out.println("�������� ��� ������");
        }
        this.vehicle.setName(this.s);
        System.out.println("������� ����������");
        Coordinates coordinates = new Coordinates();
        System.out.println("������� x");
        while (true) {
            this.s = scanner.nextLine();
            try {
                coordinates.setX(Float.parseFloat(this.s));
                if (Float.parseFloat(this.s) < 286.0f) {
                    break;
                }
                System.out.println("� ������ ���� ������ 286");
            }
            catch (NumberFormatException e) {
                System.out.println("�������� ��� ������");
            }
        }
        System.out.println("������� y");
        while (true) {
            this.s = scanner.nextLine();
            try {
                coordinates.setY(Double.parseDouble(this.s));
                if (Double.parseDouble(this.s) < 53.0) {
                    break;
                }
                System.out.println("� ������ ���� ������ 53");
            }
            catch (NumberFormatException e) {
                System.out.println("�������� ��� ������");
            }
        }
        this.vehicle.setCoordinates(coordinates);
        this.vehicle.setCreationDate(new Date());
        System.out.println("������� ���� ���������");
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
                    System.out.println("���� ��������� ������ ���� ������ 0");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("�������� ��� ������");
                continue;
            }
            break;
        }
        System.out.println("������� ���-�� �����");
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
                    System.out.println("���-�� ����� ������ ���� ������ 0");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("�������� ��� ������");
                continue;
            }
            break;
        }
        System.out.println("������� ��� ����������:\n    CAR,\n    PLANE,\n    DRONE,\n    MOTORCYCLE,\n    SPACESHIP");
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
            System.out.println("�������� ��� ������");
        }
        System.out.println("������� ��� �������\n    ELECTRICITY,\n    NUCLEAR,\n    ANTIMATTER");
        while (true) {
            this.s = scanner.nextLine();
            if (this.s.equals("ELECTRICITY") | this.s.equals("NUCLEAR") | this.s.equals("ANTIMATTER")) {
                break;
            }
            System.out.println("�������� ��� ������");
        }
        this.vehicle.setFuelType(FuelType.valueOf(this.s));
        if (!Developer.isScriptStart()) {
            System.out.println("������� ������� ���������");
        }
        return this.vehicle;
    }
}