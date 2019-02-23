package com.hsbc.socialnetwork.repository;

import com.hsbc.socialnetwork.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByUserIdOrderByIdDesc(Long id);

    List<Message> findByUserIdInOrderByIdDesc(List<Long> userList);

}