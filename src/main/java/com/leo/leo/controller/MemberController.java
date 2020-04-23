package com.leo.leo.controller;

import com.leo.leo.model.Member;
import com.leo.leo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/members")
    ResponseEntity<Iterable<Member>> getAllMember(){
        return  new ResponseEntity(memberService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/member")
    ResponseEntity<Member> saveMember(@Valid @RequestBody Member member){
        Member saveMember = memberService.save(member);
        return new ResponseEntity(saveMember, HttpStatus.CREATED);
    }

    @PutMapping("/member")
    ResponseEntity<Member> updateMember(@Valid @RequestBody Member member) throws ValidationException {
        if(memberService.findById(member.getId()).isPresent()){
            Member updateMember = memberService.save(member);
            return new ResponseEntity(updateMember, HttpStatus.OK);
        }else
            throw new ValidationException("Cannot be updated, No such kind of member");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/member/{id}")
    void deleteMember(@PathVariable Integer id){
        memberService.deleteById(id);
    }

    @GetMapping("/member/{id}")
    ResponseEntity<Optional<Member>> getMemberById(@PathVariable Integer id){
        final Optional<Member> byId = memberService.findById(id);
        return new ResponseEntity(byId, HttpStatus.OK);
    }


}
