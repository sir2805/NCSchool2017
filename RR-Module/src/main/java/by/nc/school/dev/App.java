package by.nc.school.dev;

import by.nc.school.dev.builders.GroupJournalBuilder;
import by.nc.school.dev.builders.WorkPlanBuilder;
import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.data.*;
import by.nc.school.dev.enitities.*;
import by.nc.school.dev.services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    private static User currentUser;

    public static void main( String[] args ) throws IOException {
        new FakeUserGenerator().serialize();
        new FakeSubjectGenerator().serialize();
        new FakeWorkPlanGenerator().serialize();
        new TestJournalDb().serialize(new ArrayList<>());
        FakeGroupGenerator fakeGroupGenerator = new FakeGroupGenerator();
        fakeGroupGenerator.serialize();
        System.out.println(fakeGroupGenerator.deserialize());
        displaySubjects();
        displayWorkPlan();
        displayGroups();
        testValidation();
        putMarkTest();
        System.out.println(new TestJournalDb().deserialize());
//        testValidation();
//        testUsernameChange();
    }

    private static void displayGroups() {
        for (int i = 1; i <= 4; i++) {
            GroupSemesterJournal groupSemesterJournal = new GroupJournalBuilder().build(i);
            System.out.println(groupSemesterJournal);
        }
    }

    private static void displaySubjects() {
        List<Subject> subjects = new ServiceFactory().getSubjectService().getAllSubjects();
        for (Subject subject : subjects) {
            System.out.println(subject.getName() + "  " + subject.getTutor().getFullName());
        }
    }

    private static void displayWorkPlan() {
        for (int i = 1; i <= 4; i++) {
            WorkPlan workPlan = new WorkPlanBuilder().build(new DaoFactory().getWorkPlanDao().getWorkPlanForGroup(i));
            System.out.println(workPlan);
        }
    }

    private static void testUsernameChange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new login ");
        String newUsername = sc.nextLine();
        UserService userService = new ServiceFactory().getUserService();
        userService.changeUsername(currentUser, newUsername);
        System.out.println(currentUser);
    }


    private static void testValidation() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input login ");
            String username = sc.nextLine();
            System.out.println("Input password ");
            String password = sc.nextLine();
            currentUser = new LoginController().login(username, password);
            if (currentUser != null) {
                System.out.println(Tutor.class.equals(currentUser.getClass()));
                break;
            }
        }
    }

    private static void putMarkTest() {
        Scanner sc = new Scanner(System.in);
        Student student;
        Subject subject;
        Mark mark;
        while (true) {
            System.out.println("Input student");
            String studentFullName = sc.nextLine();
            student = (Student) new ServiceFactory().getUserService().getUserByFullName(studentFullName);
            if (student != null) {
                break;
            }
        }

        while (true) {
            System.out.println("Input subject");
            String subjectName = sc.nextLine();
            subject = new ServiceFactory().getSubjectService().getSubjectByName(subjectName);
            if (subject != null) {
                break;
            }
        }

        System.out.println("Input mark ");
        String markValueString = sc.nextLine();
        System.out.println("should mark be exam? (Y/N)");
        String isExam = sc.nextLine();
        int markValue = Integer.valueOf(markValueString);
        boolean isExamFlag;
        if (isExam.equals("Y")) {
            isExamFlag = true;
        } else {
            isExamFlag = false;
        }

        mark = new Mark(markValue, isExamFlag);
        GroupSemesterJournal groupSemesterJournal = new GroupJournalBuilder().build(student.getGroupNumber());
        new ServiceFactory().getMarkService().putMark((Tutor) currentUser, mark, subject, student, groupSemesterJournal);
    }
}