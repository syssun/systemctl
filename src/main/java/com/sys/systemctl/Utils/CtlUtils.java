package com.sys.systemctl.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CtlUtils {
    public static String exeCmd(String msg) {
        String s = "0";
        switch (msg) {
            case "lockscreenTopic":
                s = lockScreen();
                break;
            case "unlockscreenTopic":
                s = unlockScreen();
                break;
            case "calcTopic":
                s = calc();
                break;
            case "shutdownTopic":
                s = shutdown();
                break;
            case "shutdowntenTopic":
                s = shutdownten();
                break;
            case "shutdownnowTopic":
                s = rononce();
                break;
            case "canceshutdowTopic":
                s = canceshutdown();
                break;
            case "taskmgrTopic":
                s = taskmgr();
                break;
            case "openqqTopic":
                s = openqq();
                break;
            case "closeqqTopic":
                s = closeqq();
                break;
            case "openwechatTopic":
                s = openwechat();
                break;
            case "closewechatTopic":
                s = closeWechat();
                break;
            case "seleepTopic":
                s = seleep();
                break;
            case "autoctlTopic":
                s = autoctl(msg);
                break;
            default:
                return "0";
        }
        return s;
    }

    //锁屏
    private static  String lockScreen() {
        try {
            Runtime.getRuntime().exec("rundll32.exe user32.dll LockWorkStation");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //un锁屏
    private static String unlockScreen() {
        try {
            Robot rb = new Robot();
            rbPressAndReles(rb, KeyEvent.VK_ENTER);
            rb.delay(2000);
            rbPressAndReles(rb, KeyEvent.VK_1);
            rbPressAndReles(rb, KeyEvent.VK_2);
            rbPressAndReles(rb, KeyEvent.VK_3);
            rbPressAndReles(rb, KeyEvent.VK_4);
            rbPressAndReles(rb, KeyEvent.VK_5);
            rbPressAndReles(rb, KeyEvent.VK_6);
            rbPressAndReles(rb, KeyEvent.VK_S);
            rbPressAndReles(rb, KeyEvent.VK_Y);
            rbPressAndReles(rb, KeyEvent.VK_S);
            rbPressAndReles(rb, KeyEvent.VK_ENTER);
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }


    //计算器
    private static String calc() {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    //60s 关机
    private static String shutdown() {
        try {
            Runtime.getRuntime().exec("shutdown -s -t 60");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //10min 关机
    private static String shutdownten() {
        try {
            Runtime.getRuntime().exec("shutdown -s -t 600");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //立即关机
    private static String rononce() {
        try {
            Runtime.getRuntime().exec("shutdown -s -f");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //取消关机命令
    private static String canceshutdown() {
        try {
            Runtime.getRuntime().exec("shutdown -a");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //任务管理器
    private static String taskmgr() {
        try {
            Runtime.getRuntime().exec("cmd /c taskmgr");
        } catch (IOException e) {
            e.getStackTrace();
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "0";
        }
        return "1";
    }

    // qq D:\qq\qq安装文件\Bin\qq.exe
    private static String openqq() {
        try {
            Robot rb = new Robot();
            Runtime.getRuntime().exec("D:\\qq\\qq安装文件\\Bin\\qq.exe");
            rb.delay(10000);
            rbPressAndReles(rb, KeyEvent.VK_S);
            rbPressAndReles(rb, KeyEvent.VK_Y);
            rbPressAndReles(rb, KeyEvent.VK_S);
            rbPressAndReles(rb, KeyEvent.VK_8);
            rbPressAndReles(rb, KeyEvent.VK_5);
            rbPressAndReles(rb, KeyEvent.VK_7);
            rbPressAndReles(rb, KeyEvent.VK_8);
            rbPressAndReles(rb, KeyEvent.VK_5);
            rbPressAndReles(rb, KeyEvent.VK_7);
            rbPressAndReles(rb, KeyEvent.VK_ENTER);

        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    // close qq  taskkill /f /im qq.exe
    private static String closeqq() {
        try {
            Runtime.getRuntime().exec("taskkill /f /im qq.exe");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    // D:\微信\WeChat\wechat.exe
    private static String openwechat() {
        try {
            Robot rb = new Robot();
            Runtime.getRuntime().exec("D:\\微信\\WeChat\\wechat.exe");
            rb.delay(2000);
            rb.keyPress(KeyEvent.VK_ENTER);//回车事件
            rb.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    //
    private static String closeWechat() {
        try {
            Runtime.getRuntime().exec("taskkill /f /im wechat.exe");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    //系统睡眠
    private static String seleep() {
        try {
            Runtime.getRuntime().exec("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }
    //自定义命令
    private static String autoctl(String ctl) {
        try {
            Runtime.getRuntime().exec("cmd /c \"" + ctl + "\"");
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }


    public static void rbPressAndReles(Robot rb, int code) {
        rb.keyPress(code);
        rb.keyRelease(code);
        rb.delay(2000);
    }
}
