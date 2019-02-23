package com.hsbc.socialnetwork.controller;

import com.hsbc.socialnetwork.model.FollowRequest;
import com.hsbc.socialnetwork.model.PostMessageRequest;
import com.hsbc.socialnetwork.model.ResponseDto;
import com.hsbc.socialnetwork.model.UserCreateRequest;
import com.hsbc.socialnetwork.service.MessageService;
import com.hsbc.socialnetwork.service.UserService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/user")
@Api(description = "User API", value = "User API")
public class UserController extends BaseController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    private MessageService messageService;


    @Autowired
    public UserController(UserService userService, MessageService messageService, ModelMapper modelMapper) {
        this.userService = userService;
        this.messageService = messageService;
    }


    @PostMapping("/create_user")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest, BindingResult bindingResult) {

        log.info("The restful request for new user: {}", userCreateRequest);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(userService.create(userCreateRequest), HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity postMessage(@RequestBody @Valid PostMessageRequest postMessageRequest, BindingResult bindingResult) throws Exception {

        log.info("The restful request for new post message: {}", postMessageRequest);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(messageService.postMessage(postMessageRequest), HttpStatus.OK);
    }

    @GetMapping("/wall/{userId}")
    public ResponseEntity wall(@PathVariable("userId") Long userId) {

        log.info("The restful request for getting user wall information: {}");

        return new ResponseEntity(userService.getWall(userId), HttpStatus.OK);
    }

    @PostMapping("/follow")
    public ResponseEntity follow(@RequestBody @Valid FollowRequest followRequest, BindingResult bindingResult) throws Exception {

        log.info("The restful request for follow user : {}", followRequest);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(userService.follow(followRequest), HttpStatus.OK);
    }

    @GetMapping("/timeline/{userId}")
    public ResponseEntity timeline(@PathVariable("userId") Long userId) {

        log.info("The restful request for getting user timeline.");

        return new ResponseEntity(userService.getTimeline(userId), HttpStatus.OK);
    }

}
