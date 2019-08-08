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
            Thread.sleep(60000);
            Runtime.getRuntime().exec("rundll32.exe user32.dll LockWorkStation");
        } catch (Exception e) {
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
    //60s 关机
    @GetMapping("/shutdown")
    public String shutdown(){
        try {
            Runtime.getRuntime().exec("shutdown -s -t 60");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }
    //10min 关机
    @GetMapping("/shutdownten")
    public String shutdownten(){
        try {
            Runtime.getRuntime().exec("shutdown -s -t 600");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }
    //立即关机
    @GetMapping("/shutdownnow")
    public String rononce(){
        try {
            Runtime.getRuntime().exec("shutdown -s -f");
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }
    //取消关机命令
    @GetMapping("/canceshutdow")
    public String canceshutdown(){
        try {
            Runtime.getRuntime().exec("shutdown -a");
        } catch (Exception e) {
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
 // qq D:\qq\qq安装文件\Bin\qq.exe
 @GetMapping("/openqq")
 public String openqq(){
     try {
         Runtime.getRuntime().exec("D:\\qq\\qq安装文件\\Bin\\qq.exe");
     } catch (IOException e) {
         return "0";
     }
     return "1";
 }
 // close qq  taskkill /f /im qq.exe
 @GetMapping("/closeqq")
 public String closeqq(){
     try {
         Runtime.getRuntime().exec("taskkill /f /im qq.exe");
     } catch (IOException e) {
         return "0";
     }
     return "1";
 }
// D:\微信\WeChat\wechat.exe
@GetMapping("/openwechat")
public String openwechat(){
    try {
        Runtime.getRuntime().exec("D:\\微信\\WeChat\\wechat.exe");
    } catch (IOException e) {
        return "0";
    }
    return "1";
}
//
@GetMapping("/closewechat")
public String closeWechat(){
    try {
        Runtime.getRuntime().exec("taskkill /f /im wechat.exe");
    } catch (IOException e) {
        return "0";
    }
    return "1";
}


}
