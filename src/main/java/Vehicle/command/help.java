package Vehicle.command;

public class help extends AbsCommand
{
    @Override
    public void execute() {
        System.out.println("help : ������� ������� �� ��������� ��������\n"+
        "info : ������� � ����������� ����� ������ ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)\n"+
        "show : ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������\n"+
        "insert null {element} : �������� ����� ������� � �������� ������\n"+
        "update id {element} : �������� �������� �������� ���������, id �������� ����� ���������\n"+
        "remove_key null : ������� ������� �� ��������� �� ��� �����\n"+
        "clear : �������� ���������\n"+
        "save : ��������� ��������� � ����\n"+
        "execute_script file_name : ������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������.\n"+
        "exit : ��������� ��������� (��� ���������� � ����)\n"+
        "history : ������� ��������� 5 ������ (��� �� ����������)\n"+
        "remove_greater_key null : ������� �� ��������� ��� ��������, ���� ������� ��������� ��������\n"+
        "remove_lower_key null : ������� �� ��������� ��� ��������, ���� ������� ������, ��� ��������\n"+
        "average_of_number_of_wheels : ������� ������� �������� ���� numberOfWheels ��� ���� ��������� ���������\n"+
        "min_by_id : ������� ����� ������ �� ���������, �������� ���� id �������� �������� �����������\n"+
        "print_ascending : ������� �������� ��������� � ������� �����������\n");
    }
}