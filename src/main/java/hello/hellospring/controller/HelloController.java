package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // url에서 '/hello'로 들어오는 경우 하단의 함수 실행
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; // resources/templates 안에 있는 hello를 찾아서 rendering, hello가 viewName으로 매핑
        // 'resources/templates//+{viewName}+'./html'
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        // param으로 name이 있어야하므로 경로에 '?name=내용'이 있어야함
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // view를 거치지 않고 바로 나타낼 수 있음
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
