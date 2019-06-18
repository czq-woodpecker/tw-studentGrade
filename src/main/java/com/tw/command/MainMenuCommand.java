package com.tw.command;

import com.tw.RouterController;

/**
 * @author: woodpecker
 * @Date: 2019/6/16 20:42
 */
public class MainMenuCommand extends Command {
    public static final String MENU_MESSAGE =
            "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3）：";

    public MainMenuCommand(int number) {
        super(number);
    }

    @Override
    public void execute() {
        System.out.println(MENU_MESSAGE);
        //默认
        int menuNum = RouterController.MAIN_MENU;
        try {
            menuNum = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("无效输入");
        }
        //吸收回车
        scanner.nextLine();
        getRouterController().toMenu(menuNum);
    }
}
