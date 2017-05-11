package next.controller.user;

import next.controller.UserSessionUtils;
import next.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    /*
    /users(GET), index() : 목록
    /users/form(GET), form() : 생성 폼
    /users(POST), create() : 생성
    /users/{id}(GET), show() : 상세 보기
    /users/{id}/edit(GET), edit() : 수정 폼
    /users/{id}(PUT), update() : 수정
    /users/{id}(DELETE), destroy() : 삭제
    */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getUsers(HttpServletRequest request, Model model) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        
        if (!UserSessionUtils.isLogined(request.getSession())) {
            modelAndView.setViewName("/user/login");
            return modelAndView;
        }

        modelAndView.setViewName("/user/list");
        modelAndView.addObject("users", UserDao.getInstance().findAll());
        return modelAndView;
    }
}
