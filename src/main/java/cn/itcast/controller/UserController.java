package cn.itcast.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.IDUtil;
import cn.itcast.domain.Member;
import cn.itcast.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Api(value="supermarket",description = "登录接口")
@Controller
@RequestMapping(value="/supermarket")
public class UserController {
    @Autowired
    private UserService userService;
    @Resource
    private MemberService memberService;
    /**
     * 处理/login请求
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(String userName, String password, Integer role, Model model,HttpSession session){
        User user=userService.login(userName,password,role);
        if(user!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("user", user);
            if(1==user.getRole()){
                //进入会员管理界面
                //查询会员数据
                List<Member> list = memberService.getMembers();
                model.addAttribute("members", list);
                //返回页面
                return "manager";
        }else if(2==user.getRole()){
                //將流水號传递进去
                model.addAttribute("shoppingNum", IDUtil.getId());
                //进入收银员界面
                return "cashier";
            }
        }
        return "error";
    }

    @ApiOperation(value = "这是一个测试Swaager接口实例")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", dataType = "String", required = true,paramType = "query"),
            @ApiImplicitParam(name = "desc", dataType = "String", required = true,paramType = "query")
    })
    @ResponseBody
    @RequestMapping(value = "/swaager/swaagerTest", method = RequestMethod.POST)
    public String Test(String name, String desc) {
        return "这是一个测试Swaager接口实例-----------{"+String.format("%s",name)+"},----------{"+String.format("%s",desc)+"}";

    }

}
