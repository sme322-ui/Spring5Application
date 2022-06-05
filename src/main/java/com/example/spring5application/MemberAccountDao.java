package com.example.spring5application;




public interface MemberAccountDao {

    public Integer insert(MemberAccount memberAccount);
    public MemberAccount findMemberAccountByUsername(String username);
    public Integer update(MemberAccount memberAccount);

}