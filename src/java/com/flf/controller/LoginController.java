package com.flf.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flf.entity.Menu;
import com.flf.entity.Role;
import com.flf.entity.User;
import com.flf.service.MenuService;
import com.flf.service.UserService;
import com.flf.util.CheckBIZ;
import com.flf.util.Const;
import com.flf.util.RightsHelper;
import com.flf.util.Tools;
import com.ssd.framework.util.Checking;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;

	/**
	 * 访问登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "login";
	}

	/**
	 * 请求登录，验证用户
	 * 
	 * @param session
	 * @param loginname
	 * @param password
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(HttpSession session,
			@RequestParam String loginname, @RequestParam String password,
			@RequestParam String code) {
		String sessionCode = (String) session
				.getAttribute(Const.SESSION_SECURITY_CODE);
		ModelAndView mv = new ModelAndView();
		String errInfo = "";
		if (Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
			User user = userService.getUserByNameAndPwd(loginname, password);
			if (user != null) {
				user.setLastLogin(new Date());
				userService.updateLastLogin(user);
				session.setAttribute(Const.SESSION_USER, user);
				session.removeAttribute(Const.SESSION_SECURITY_CODE);
			} else {
				errInfo = "用户名或密码有误！";
			}
		} else {
			errInfo = "验证码输入有误！";
		}
		if (Tools.isEmpty(errInfo)) {
			mv.setViewName("redirect:index.html");
		} else {
			mv.addObject("errInfo", errInfo);
			mv.addObject("loginname", loginname);
			mv.addObject("password", password);
			mv.setViewName("login");
		}
		return mv;
	}

	/**
	 * 访问系统首页
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(HttpSession session, Model model) {
		User user = (User) session.getAttribute(Const.SESSION_USER);
		user = userService.getUserAndRoleById(user.getUserId());
		Role role = user.getRole();
		String roleRights = role != null ? role.getRights() : "";
		String userRights = user.getRights();
		// 避免每次拦截用户操作时查询数据库，以下将用户所属角色权限、用户权限限都存入session
		session.setAttribute(Const.SESSION_ROLE_RIGHTS, roleRights); // 将角色权限存入session
		session.setAttribute(Const.SESSION_USER_RIGHTS, userRights); // 将用户权限存入session

		List<Menu> menuList = menuService.listAllMenu();
		if (Tools.notEmpty(userRights) || Tools.notEmpty(roleRights)) {
			for (Menu menu : menuList) {
				menu.setHasMenu(RightsHelper.testRights(userRights,
						menu.getMenuId())
						|| RightsHelper.testRights(roleRights, menu.getMenuId()));
				if (menu.isHasMenu()) {
					List<Menu> subMenuList = menu.getSubMenu();
					for (Menu sub : subMenuList) {
						sub.setHasMenu(RightsHelper.testRights(userRights,
								sub.getMenuId())
								|| RightsHelper.testRights(roleRights,
										sub.getMenuId()));
					}
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("menuList", menuList);
		return "index";
	}

	/**
	 * 进入首页后的默认页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/default")
	public String defaultPage() {
		return "default";
	}

	/**
	 * 用户注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Const.SESSION_USER);
		session.removeAttribute(Const.SESSION_ROLE_RIGHTS);
		session.removeAttribute(Const.SESSION_USER_RIGHTS);
		return "login";
	}

	/**
	 * 跳转到账号注册页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request, HttpServletResponse response)
			throws JSONException, IOException {
		return "test";
	}

	/**
	 * CP注册页面
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/reg")
	public String reg(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String loginname = request.getParameter("name");
		String password = request.getParameter("pw");
		if (Checking.isNullorBlank(loginname)) {
			request.setAttribute("msg", "账号不符合要求");
		}
		if (!CheckBIZ.isPasswordMG(password)) {
			request.setAttribute("msg", "密码不符合要求");
		}
		if (userService.getUserByNameAndPwd(loginname, password) != null) {
			request.setAttribute("msg", "此用户已经注册");
		}
		String comName = request.getParameter("cn");
		if (Checking.isNullorBlank(comName)) {
			request.setAttribute("msg", "请按要求填入");
		}
		String comWebsite = request.getParameter("cw");
		String comLoc = request.getParameter("cl");
		if (Checking.isNullorBlank(comLoc)) {
			request.setAttribute("msg", "请按要求填入");
		}
		// 将用户注册信息存入数据库
		User user = new User();
		user.setRoleId(4);
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setComName(comName);
		user.setComWebsite(comWebsite);
		user.setComLoc(comLoc);
		userService.insertUser(user);
		return "login";
	}
}
