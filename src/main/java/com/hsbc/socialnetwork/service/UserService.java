package com.hsbc.socialnetwork.service;

import com.hsbc.socialnetwork.domain.Follow;
import com.hsbc.socialnetwork.domain.Message;
import com.hsbc.socialnetwork.domain.User;
import com.hsbc.socialnetwork.model.*;
import com.hsbc.socialnetwork.repository.FollowRepository;
import com.hsbc.socialnetwork.repository.MessageRepository;
import com.hsbc.socialnetwork.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    private MessageRepository messageRepository;

    private ModelMapper modelMapper;

    private FollowRepository followRepository;

    @Autowired
    public UserService(UserRepository userRepository, MessageRepository messageRepository, ModelMapper modelMapper, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
        this.followRepository = followRepository;
    }

    public UserCreateResponse create(@Valid UserCreateRequest userCreateRequest) {

        log.info("User create method started.");

        User userEntity = modelMapper.map(userCreateRequest, User.class);

        User saved = userRepository.save(userEntity);

        log.info("User create method finished.");

        return new UserCreateResponse(saved);
    }

    public GetUserWallResponse getWall(Long userId) {

        log.info(" UserService getWall method started.");

        List<Message> messageList = messageRepository.findByUserIdOrderByIdDesc(userId);

        log.info("UserService getWall method finished.");

        return new GetUserWallResponse(messageList);
    }

    public FollowResponse follow(FollowRequest followRequest) throws Exception {

        log.info(" UserService follow method started.{}", followRequest);

        Long who = followRequest.getWhoId();

        Long to = followRequest.getToId();

        User whoUser = userRepository.findById(who).get();

        User toUser = userRepository.findById(to).get();

        Follow followEntity = new Follow();

        followEntity.setWho(whoUser);

        followEntity.setTo(toUser);

        Follow isExistLine = followRepository.findByWhoIdAndToIdIs(who, to);

        if (isExistLine != null)
            throw new Exception("You are following " + toUser.getFirstName() + " already.");


        Follow saved = followRepository.save(followEntity);

        log.info("UserService getWall method finished.");

        return new FollowResponse(saved);
    }


    public TimelineResponse getTimeline(Long userId) {

        log.info(" UserService getTimeline method started.{}", userId);

        List<Long> followingList = new ArrayList<>();

        List<Follow> list = followRepository.findByWhoId(userId);

        for (Follow follow : list) {
            followingList.add(follow.getTo().getId());
        }

        log.info("getting following list []", followingList);

        List<Message> timeLine = messageRepository.findByUserIdInOrderByIdDesc(followingList);

        log.info("getting message list according to []", followingList);

        log.info(" UserService getTimeline method finished.{}", userId);

        return new TimelineResponse(timeLine);
    }

}
