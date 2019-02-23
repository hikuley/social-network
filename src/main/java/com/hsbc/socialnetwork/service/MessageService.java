package com.hsbc.socialnetwork.service;

import com.hsbc.socialnetwork.domain.MessageEntity;
import com.hsbc.socialnetwork.domain.UserEntity;
import com.hsbc.socialnetwork.model.PostMessageRequest;
import com.hsbc.socialnetwork.model.PostMessageResponse;
import com.hsbc.socialnetwork.repository.MessageRepository;
import com.hsbc.socialnetwork.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService extends BaseService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    private UserRepository userRepository;

    private MessageRepository messageRepository;


    @Autowired
    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public PostMessageResponse postMessage(PostMessageRequest postMessageRequest) throws Exception {

        log.info("Began the postMessage method. {}:", postMessageRequest);

        if (postMessageRequest.getMessage().length() > 140)
            throw new Exception("Character size of the message must be small than 140");


        Long userId = postMessageRequest.getUserId();
        Optional<UserEntity> user = userRepository.findById(userId);
        UserEntity userEntity = user.get();

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setUser(userEntity);
        messageEntity.setMessage(postMessageRequest.getMessage());

        MessageEntity saved = messageRepository.save(messageEntity);

        log.info("Finished the postMessage method. {}:", saved);

        return new PostMessageResponse(saved);
    }

    public PostMessageResponse wall(PostMessageRequest postMessageRequest) {

        return null;
    }


}
