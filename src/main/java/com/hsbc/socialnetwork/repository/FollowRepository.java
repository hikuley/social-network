package com.hsbc.socialnetwork.repository;

import com.hsbc.socialnetwork.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    Follow findByWhoIdAndToIdIs(Long whoId, Long toId);

    List<Follow> findByWhoId(Long userId);

}