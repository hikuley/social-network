package com.hsbc.socialnetwork.repository;

import com.hsbc.socialnetwork.domain.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByUserIdOrderByIdDesc(Long id);

    List<MessageEntity> findByUserIdInOrderByIdDesc(List<Long> userList);

}