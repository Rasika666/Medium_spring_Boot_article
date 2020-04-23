package com.leo.leo.service;


import com.leo.leo.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface MemberService extends CrudRepository<Member, Integer> { }
