import db.MySQLConnector;
import object.Curator;
import object.Group;
import object.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentsTable;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {

            StudentsTable studentsTable = new StudentsTable();
        ArrayList<Student> students = studentsTable.selectAll();
        if (students.isEmpty()) {
            studentsTable.insert(new Student("Иванов Иван Иванович", "муж", 1));
            studentsTable.insert(new Student("Сидорова Анастасия Евгеньевна", "жен", 2));
            studentsTable.insert(new Student("Смирнова Екатерина Вадимовна", "жен", 3));
            studentsTable.insert(new Student("Кузнецов Алексей Сергеевич", "муж", 1));
            studentsTable.insert(new Student("Белова Мария Николаевна", "жен", 2));
            studentsTable.insert(new Student("Александров Александр Сергеевич", "муж", 3));
            studentsTable.insert(new Student("Воробьева Юлия Игоревна", "жен", 1));
            studentsTable.insert(new Student("Зайцев Максим Владимирович", "муж", 2));
            studentsTable.insert(new Student("Соловьёва Ольга Александровна", "жен", 3));
            studentsTable.insert(new Student("Лебедев Даниил Иванович", "муж", 1));
            studentsTable.insert(new Student("Ильина Алина Васильевна", "жен", 2));
            studentsTable.insert(new Student("Романов Артём Олегович", "муж", 3));
            studentsTable.insert(new Student("Новикова Елена Александровна", "жен", 1));
            studentsTable.insert(new Student("Киселёв Игорь Дмитриевич", "муж", 2));
            studentsTable.insert(new Student("Богданов Богдан Богданович", "муж", 3));

        }

        GroupTable groupTable = new GroupTable();
        ArrayList<Group> groups = groupTable.selectAll();
        if (groups.isEmpty()) {
            groupTable.insert(new Group("QA",1 ));
            groupTable.insert(new Group("AQA",2 ));
            groupTable.insert(new Group("Developer",3 ));
            groups = groupTable.selectAll();

        }

        CuratorTable curatorTable = new CuratorTable();
        ArrayList<Curator> curators = curatorTable.selectAll();
        if (curators.isEmpty()) {
            curatorTable.insert(new Curator("Алексеев Григорий Аполонович"));
            curatorTable.insert(new Curator("Петров Петр Александрович"));
            curatorTable.insert(new Curator("Гроздев Алексей Алексеевич"));
            curatorTable.insert(new Curator("Липов Марк Маркович"));
        }
       studentsTable.selectAllWomen();
            System.out.println("-------------------------------------------------");

            studentsTable.selectCount();

            System.out.println("-------------------------------------------------");
            studentsTable.selectAllStudentsFromGroup();

            System.out.println("-------------------------------------------------");
            studentsTable.selectAllStudentWitchGroupAndCurator();

            System.out.println("-------------------------------------------------");
            groupTable.selectAllGroupAndCurator();

            groups.get(2).setId_curator(10);
            groupTable.update(groups.get(2));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MySQLConnector.close();
        }
    }
}






