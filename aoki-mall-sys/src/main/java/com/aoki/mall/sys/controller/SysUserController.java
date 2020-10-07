package com.aoki.mall.sys.controller;

import com.aoki.mall.common.utils.R;
import com.aoki.mall.sys.entity.SysUserEntity;
import com.aoki.mall.sys.form.SysLoginForm;
import com.aoki.mall.sys.service.SysCaptchaService;
import com.aoki.mall.sys.service.SysUserService;
import com.aoki.mall.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    @ResponseBody
    public void captcha(HttpServletResponse response, String uuid)throws IOException {
        /**
         *         浏览器请求分为简单请求和复杂请求,在发起复杂请求且跨域的情况下会自动发起OPTIONS预检测请求
         *
         *         简单请求需满足以下两个条件否则为复杂请求:
         *         (1)请求方法是以下三种方法之一
         *              HEAD、GET、POST
         *         (2)HTTP 的头信息不超出以下几种字段
         *              Accept、Accept-Language、Content-Language、Last-Event-ID、
         *              Content-Type: 只限于 (application/x-www-form-urlencoded、multipart/form-data、text/plain)
         */
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @PostMapping("/sys/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {
        //1. 验证输入的验证码与数据库中验证码是否一致
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return R.error("验证码不正确");
        }

        //2. 用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());
        //账号不存在、密码错误
        //if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
        if(user == null){
            return R.error("账号或密码不正确");
        }

        //3. 账号锁定
        if(user.getStatus() == 0){
            return R.error("账号已被锁定,请联系管理员");
        }

        //4. 生成token，并保存到数据库
        R r = sysUserTokenService.createToken(user.getUserId());
        return r;
    }


    /**
     * 退出
     */
//    @PostMapping("/sys/logout")
//    public R logout() {
//        sysUserTokenService.logout(getUserId());
//        return R.ok();
//    }
}
