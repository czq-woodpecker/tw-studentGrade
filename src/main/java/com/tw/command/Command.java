package com.tw.command;

import com.tw.RouterController;

import java.util.Scanner;

/**
 * @author: woodpecker
 * @Date: 2019/6/16 15:35
 */
public abstract class Command {
    private int number;
    public static Scanner scanner = new Scanner(System.in);
    private RouterController routerController;

    public abstract void execute();

    public Command() {
    }

    public Command(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RouterController getRouterController() {
        return routerController;
    }

    public void setRouterController(RouterController routerController) {
        this.routerController = routerController;
    }
}
