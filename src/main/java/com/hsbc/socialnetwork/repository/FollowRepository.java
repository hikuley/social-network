package com.hsbc.socialnetwork.repository;

import com.hsbc.socialnetwork.domain.FollowEntity;
import com.hsbc.socialnetwork.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, Long> {

    FollowEntity findByWhoIdAndToIdIs(Long whoId, Long toId);

    List<FollowEntity> findByWhoId(Long userId);

}