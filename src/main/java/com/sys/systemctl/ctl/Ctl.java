package com.sys.systemctl.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URLEncoder;

//@RestController
//@RequestMapping("/ctl")
public class Ctl {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    //锁屏
    @GetMapping("/lockscreen")
    public String lockScreen() {
        kafkaTemplate.send("lockscreenTopic", "open");
        return "1";
    }

    //un锁屏
    @GetMapping("/unlockscreen")
    public String unlockScreen() {
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
    @GetMapping("/calc")
    public String calc() {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    //60s 关机
    @GetMapping("/shutdown")
    public String shutdown() {
        try {
            Runtime.getRuntime().exec("shutdown -s -t 60");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //10min 关机
    @GetMapping("/shutdownten")
    public String shutdownten() {
        try {
            Runtime.getRuntime().exec("shutdown -s -t 600");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //立即关机
    @GetMapping("/shutdownnow")
    public String rononce() {
        try {
            Runtime.getRuntime().exec("shutdown -s -f");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //取消关机命令
    @GetMapping("/canceshutdow")
    public String canceshutdown() {
        try {
            Runtime.getRuntime().exec("shutdown -a");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    @GetMapping("/taskmgr")
    public String taskmgr() {
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
    @GetMapping("/openqq")
    public String openqq() {
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
    @GetMapping("/closeqq")
    public String closeqq() {
        try {
            Runtime.getRuntime().exec("taskkill /f /im qq.exe");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    // D:\微信\WeChat\wechat.exe
    @GetMapping("/openwechat")
    public String openwechat() {
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
    @GetMapping("/closewechat")
    public String closeWechat() {
        try {
            Runtime.getRuntime().exec("taskkill /f /im wechat.exe");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    //系统睡眠
    @GetMapping("/seleep")
    public String seleep() {
        try {
            Runtime.getRuntime().exec("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }

    //自定义命令
    @GetMapping("/autoctl")
    public String autoctl(String ctl) {
        try {
            String s = "\"";
            Runtime.getRuntime().exec("cmd /c \"" + ctl + "\"");
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }


    public void rbPressAndReles(Robot rb, int code) {
        rb.keyPress(code);
        rb.keyRelease(code);
        rb.delay(2000);
    }
}
