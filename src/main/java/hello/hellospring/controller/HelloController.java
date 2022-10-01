package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    /**
     * MVC 방식
     * 받은 데이터를 Model에 저장 후 return한 문자열에 맞는 template 파일 찾은 후
     * 값을 변환
     * 뷰 리절버가 html 파일을 보여줌
     * @param name
     * @param model
     * @return
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    /**
     * API 방식
     * 받은 데이터를 문자열 그대로 화면에 출력
     * @param name
     * @return
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" +name;
    }

    /**
     * API 방식(JSON 방식)
     * html이 아닌 데이터 넘기기
     * @param name
     * @return
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
