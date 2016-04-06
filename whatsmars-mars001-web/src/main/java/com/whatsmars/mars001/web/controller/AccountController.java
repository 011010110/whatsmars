package com.whatsmars.mars001.web.controller;

import com.whatsmars.common.pojo.Result;
import com.whatsmars.common.util.ResultHelper;
import com.whatsmars.mars001.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shenhongxi on 2016/4/1.
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("name")String name,
                        //@RequestParam("token")String token,
                        HttpServletRequest request,
                        HttpServletResponse response) {
//        String source = this.getToken(request);
//        if(!source.equals(token)) {
//            return ResultHelper.renderAsJson(ResultCode.VALIDATE_FAILURE, "表单过期，请重新刷新页面");
//        }
        Result result = accountService.hello(name);
        if (!result.isSuccess()) {
            return ResultHelper.renderAsJson(result);
        }
//        this.removeToken(request, response);
        result.setResponseUrl("/account/hello_success.jhtml");
        return ResultHelper.renderAsJson(result);
    }

    @RequestMapping("/hello_success")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        //mav.addAllObjects(result.getAll());
        mav.addObject("title", "Welcome to Whatsmars!");
        return mav;
    }
}
