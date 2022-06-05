package com.example.spring5application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@RestController
@RequestMapping(path="/user")
public class HomeController {


    Map<Long,User> users = new HashMap<>();
    private JpaRepository articleRepository;

    @PostConstruct
    public void init() throws Exception{
        users.put(Long.valueOf(1),new User(1,"longzhongua",28));
        users.put(Long.valueOf(2),new User(2,"longzhiran",2));

    }


    @RequestMapping("/home")
    public Mono<String> visitHome() {
        return Mono.just("This is WebFlux demo");
    }

    @GetMapping("/list")
    public Flux<User> getAll(){
        return Flux.fromIterable(users.entrySet().stream().map(entry->entry.getValue()).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id){
        return Mono.justOrEmpty(users.get(id));
    }

    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(User user){
        users.put(user.getId(),user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> putUser(@PathVariable Long id,User user)
    {
        user.setId(id);
        users.put(id,user);
        return Mono.just(new ResponseEntity<>(user,HttpStatus.CREATED));

    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id){
        users.remove(id);
        return Mono.just(new ResponseEntity<>("刪除成功",HttpStatus.ACCEPTED));
    }
    @GetMapping("/helloword")
        public Mono<String> helloworld(){
            return Mono.just("This is WebFlux demo");
        }

    @RequestMapping("/article")
    public ModelAndView articleList(@RequestParam(value = "start", defaultValue = "0") Integer
                                            start, @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
            start = start<0?0:start;
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start,limit,sort);
        Page<Article> page = articleRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("admin/article/list");
        mav.addObject("page",page);
        return mav;

    }
}


