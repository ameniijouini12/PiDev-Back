package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.feedback;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<feedback,Integer> {

}
