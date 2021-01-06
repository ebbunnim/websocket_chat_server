package ebbunnim.chatserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // welcome 페이지
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-mvc";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // getter, setter : 자바 빈 규약 / 프로퍼티 접근 방식이라고 하기도 함
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name=name;
        }

    }

}
