package com.tw.command;

/**
 * @author: woodpecker
 * @Date: 2019/6/18 3:18
 */
public class ExistCommand extends Command {

    public ExistCommand(int number) {
        super(number);
    }

    @Override
    public void execute() {
        scanner.close();
        System.out.println("您退出了学生成绩单系统");
    }

}
