package com.akikun.demo.spring.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Random;

/**
 * @author 李俊秋(龙泽)
 */
@RestController
@RequestMapping("/h2")
public class H2Controller {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/create")
    public void create() {
        User user = new User();
        Random random = new Random();
        int c = random.nextInt(128);
        user.setUsername("" + (char) c);
        user.setGender(1);

        userRepository.save(user);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public User create(@PathVariable Long id) {

        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElse(new User());
    }


}
