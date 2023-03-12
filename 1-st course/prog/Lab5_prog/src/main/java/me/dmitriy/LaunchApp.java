package me.dmitriy;

import me.dmitriy.server.utilits.LaunchManager;

/**
 * @author Михайлов Дмитрий Андреевич
 * Группа P3118
 * Вариант №31191
 */

public class LaunchApp{

    public static void main(String[] args){
        LaunchManager launchManager = new LaunchManager();
        launchManager.getCommandFromConsole();
    }
}