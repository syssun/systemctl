package com.sys.systemctl.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ctl")
public class Ctl {


    //锁屏
    @GetMapping("/lockscreen")
    public String lockScreen(){
        try {
            Runtime.getRuntime().exec("rundll32.exe user32.dll LockWorkStation");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }
    //计算器
    @GetMapping("/calc")
    public String calc(){
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }
    //15s 关机
    @GetMapping("/rononce")
    public String rononce(){
        try {
            Runtime.getRuntime().exec("rononce -p");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }
    @GetMapping("/taskmgr")
    public String taskmgr(){
        try {
            Runtime.getRuntime().exec("taskmgr");
        } catch (IOException e) {
            return "0";
        }
        return "1";
    }





}
