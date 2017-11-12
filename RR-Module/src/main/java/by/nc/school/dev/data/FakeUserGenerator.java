package by.nc.school.dev.data;

import by.nc.school.dev.Role;
import by.nc.school.dev.enitities.Student;
import by.nc.school.dev.enitities.User;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FakeUserGenerator extends AbstractFakeGenerator<User> {

    private String[]logins = {
            "Patrice" ,
            "Collene" ,
            "Carlita" ,
            "Moises" ,
            "Collin" ,
            "Meg" ,
            "Domenic" ,
            "Hugo" ,
            "Rana" ,
            "Delicia" ,
            "Karla" ,
            "Marylouise" ,
            "Edda" ,
            "Georgiann" ,
            "Drucilla" ,
            "Brunilda" ,
            "Tristan" ,
            "Echo" ,
            "Felicitas" ,
            "Joan" ,
            "Vilma" ,
            "Dannette" ,
            "Donald" ,
            "Jeannie" ,
            "Terina" ,
            "Christiane" ,
            "Rasheeda" ,
            "Bibi" ,
            "Tracey" ,
            "Lottie" ,
            "Jeannetta" ,
            "Mellissa" ,
            "Sabra" ,
            "Glennie" ,
            "Andreas" ,
            "Drusilla" ,
            "Myra" ,
            "Carletta" ,
            "Roxy" ,
            "Niesha" ,
            "Lavon" ,
            "Elvin" ,
            "Vera" ,
            "Miranda" ,
            "Carleen" ,
            "Tessie" ,
            "Jeremy" ,
            "Libbie" ,
            "Valda" ,
            "Dulce" ,
            "aaa", "bbb", "ccc", "ddd", "admin", "roskach",
    };

    public FakeUserGenerator() {
        this.filepath = filedir + File.separator + "fakeUsers.txt";
    }

    @Override
    public void serialize() {
        try (FileOutputStream fos = new FileOutputStream(filepath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Random random = new Random();
            int id = 1;
            for (String login : logins) {
                String password = login + "1";
                String username = login + " Name";
                int role = 1;
                int groupNumber;
                groupNumber = random.nextInt(4) + 1;
                switch (login) {
                    case "admin":
                    case "roskach":
                        role = Role.DEAN;
                        groupNumber = 0;
                        break;
                    case "aaa":
                        role = Role.CURATOR;
                        groupNumber = 1;
                        break;
                    case "bbb":
                        role = Role.CURATOR;
                        groupNumber = 2;

                        break;
                    case "ccc":
                        role = Role.CURATOR;
                        groupNumber = 3;

                        break;
                    case "ddd":
                        role = Role.CURATOR;
                        groupNumber = 4;
                        break;
                }
                oos.writeObject(new User(id, role, login, password, username));
                id++;
            }
            oos.writeObject(null);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
