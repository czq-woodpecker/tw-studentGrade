package com.tw.command;

import com.tw.RouterController;
import com.tw.model.Student;
import com.tw.repository.StudentRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: woodpecker
 * @Date: 2019/6/16 15:52
 */
public class AddStudentCommand extends Command {
    private static final String WELCOME_MESSAGE = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";
    private static final String ERROR_FORMAT_MESSAGE = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";
    private static final String STUDENT_FORM_REGEX = "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";


    public AddStudentCommand(int number) {
        super(number);
    }

    @Override
    public void execute() {
        System.out.println(WELCOME_MESSAGE);
        String studentInfoString = scanner.nextLine();
        Student student = transferStringToStu(studentInfoString);
        if (student == null) {
            System.out.println(ERROR_FORMAT_MESSAGE);
        } else {
            StudentRepository.addStudent(student);
            System.out.println("学生" + student.getName() + "的成绩被添加");
        }
        getRouterController().toMenu(RouterController.MAIN_MENU);
    }

    /**
     * 从Str从提取Student信息
     * @param studentInfoString
     * @return
     */
    private Student transferStringToStu(String studentInfoString) {
        if (studentInfoString == null || "".equals(studentInfoString.trim())) {
            return null;
        }
        Matcher matcher = Pattern.compile(STUDENT_FORM_REGEX).matcher(studentInfoString);
        if (!matcher.matches()) {
            return null;
        }
        Student student = new Student();
        student.setName(matcher.group(1));
        student.setNumber(matcher.group(2));
        student.setMathGrade(Double.parseDouble(matcher.group(3)));
        student.setChineseGrade(Double.parseDouble(matcher.group(4)));
        student.setEnglishGrade(Double.parseDouble(matcher.group(5)));
        student.setProgramGrade(Double.parseDouble(matcher.group(6)));
        return student;
    }
}
