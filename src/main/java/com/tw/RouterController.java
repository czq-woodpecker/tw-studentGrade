package com.tw;

import com.tw.command.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: woodpecker
 * @Date: 2019/6/17 0:59
 */
public class RouterController {
    public final static int MAIN_MENU = 0;
    public final static int ADD_STUDENT_MENU = 1;
    public final static int GENERATE_STUDENT_GRADE_MENU = 2;
    public final static int EXIST_MENU = 3;

    private List<Command> commands;
    private static final String ERROR_MENU_NUMBER = "无效选择";

    public RouterController() {
        commands = Arrays.asList(
                new MainMenuCommand(MAIN_MENU),
                new AddStudentCommand(ADD_STUDENT_MENU),
                new GenerateStuGradeCommand(GENERATE_STUDENT_GRADE_MENU),
                new ExistCommand(EXIST_MENU)
        );
    }

    public void toMenu(int number) {
        Optional<Command> optionalCommand = commands
                .stream()
                .filter(command -> command.getNumber() == number)
                .findFirst();
        if(optionalCommand.isPresent()) {
            Command command = optionalCommand.get();
            command.setRouterController(this);
            command.execute();
        } else {
            System.out.println(ERROR_MENU_NUMBER);
        }
    }
}
