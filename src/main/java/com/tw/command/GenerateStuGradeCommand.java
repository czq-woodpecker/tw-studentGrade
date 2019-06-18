package com.tw.command;

import com.tw.model.Student;
import com.tw.repository.StudentRepository;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: woodpecker
 * @Date: 2019/6/18 2:08
 */
public class GenerateStuGradeCommand extends Command {
    public static final String WELCOME_MESSAGE = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    public static final String ERROR_FORMAT_MESSAGE = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private static final String STUDENT_NUMBERS_REGEX = "(\\d+)";

    public GenerateStuGradeCommand(int number) {
        super(number);
    }

    public GenerateStuGradeCommand() {
    }

    @Override
    public void execute() {
        System.out.println(WELCOME_MESSAGE);
        String stuNumberInput = scanner.nextLine();
        List<String> stuNumbers = getStudentNumbers(stuNumberInput);
        if (stuNumbers.size() == 0) {
            System.out.println(ERROR_FORMAT_MESSAGE);
        } else {
            List<Student> students = StudentRepository.getStudents(stuNumbers);
            printStudentGrades(students);
        }
    }


    private void printStudentGrades(List<Student> students) {
        System.out.println("成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("========================================");
        for (Student student : students) {
            System.out.println(
                    student.getName() + "|"
                            + formatDoubleNumber(student.getMathGrade()) + "|"
                            + formatDoubleNumber(student.getChineseGrade()) + "|"
                            + formatDoubleNumber(student.getEnglishGrade()) + "|"
                            + formatDoubleNumber(student.getProgramGrade()) + "|"
                            + formatDoubleNumber(getStudentAvgGrade(student)) + "|"
                            + formatDoubleNumber(getStudentTotalGrade(student)));
        }
        System.out.println("全班总分平均数：" + formatDoubleNumber(getClassAverageGrade(students)));
        System.out.println("全班总分中位数：" + formatDoubleNumber(getClassGradeMedian(students)));
        System.out.println("========================================");
    }

    /**
     * 获取班级成绩中位数
     * @param students
     * @return
     */
    private Double getClassGradeMedian(List<Student> students) {
        if (students == null || students.size() == 0) {
            return null;
        }
        List<Double> list = new ArrayList<>();
        for (Student student : students) {
            list.add(student.getChineseGrade());
            list.add(student.getEnglishGrade());
            list.add(student.getMathGrade());
            list.add(student.getProgramGrade());
        }
        Collections.sort(list);
        int count = list.size();
        double gradeMedian = (list.get((count - 1) / 2) + list.get(count / 2)) / 2.0;
        return gradeMedian;
    }

    /**
     * 获取班级成绩平均分
     * @param students
     * @return
     */
    private Double getClassAverageGrade(List<Student> students) {
        OptionalDouble optionalDouble = students
                .stream()
                .mapToDouble(student -> getStudentAvgGrade(student))
                .average();
        if (optionalDouble.isPresent()) {
            return optionalDouble.getAsDouble();
        }
        return null;
    }

    private double getStudentAvgGrade(Student student) {
        return getStudentTotalGrade(student) / 4.0;
    }

    private double getStudentTotalGrade(Student student) {
        if (student != null) {
            double totalGrade = student.getMathGrade()
                    + student.getChineseGrade()
                    + student.getEnglishGrade()
                    + student.getProgramGrade();
            return totalGrade;
        }
        return 0;
    }

    private List<String> getStudentNumbers(String stuNumberInput) {
        Matcher matcher = Pattern.compile(STUDENT_NUMBERS_REGEX).matcher(stuNumberInput);
        List<String> stuNumbers = new LinkedList<>();
        while (matcher.find()) {
            stuNumbers.add(matcher.group());
        }
        return stuNumbers;
    }

    /**
     * 保留一位小数，若小数为0则舍去
     * @param number
     * @return
     */
    public String formatDoubleNumber(double number) {
        return new DecimalFormat("#.#").format(number);
    }

}
