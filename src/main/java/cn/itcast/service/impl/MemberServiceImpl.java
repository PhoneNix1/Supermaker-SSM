package cn.itcast.service.impl;

import cn.itcast.dao.MemberMapper;
import cn.itcast.domain.Member;
import cn.itcast.domain.MemberRecord;
import cn.itcast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public List<Member> getMembers(){
        return memberMapper.getMembers();
    }

    @Override
    public boolean addMember(Member param){
        //先查询是否有相同ID
        List<Member> member1=memberMapper.getMember(param.getId());
        if (member1.size()>0){
            return false;
        }else {
            memberMapper.addMember(param);
            return true;
        }
    }

    @Override
    public Member getMemberNPT(int memberID){
        return memberMapper.getMemberNPT(memberID);
    }

    @Override
    public Member getMemberBal(int memberID){
        return memberMapper.getMemberBal(memberID);
    }

    @Override
    public boolean getMemberAll(int memberID, BigDecimal total_cost){
        Member memberTotal = memberMapper.getMemberAll(memberID);
        int a = total_cost.compareTo(memberTotal.getTotal());
        //等于1说明购物金额大于会员卡余额，不可以结账。否则可以 并更新
        if(a==1){
            //TODO 提示或者
            return false;
        }// 再更新会员表,余额，更新时间，把总价传进去，用Member的total-结账的Total
        else{
            memberMapper.updateMember(memberID,total_cost);
            return true;
        }
    }

    @Override
    public Member getMemberID(int memberID){
        return memberMapper.getMemberID(memberID);
    }

    @Override
    public void addMemberRecord(MemberRecord memberRecord){
        memberMapper.addMemberRecord(memberRecord);
    }

    @Override
    public MemberRecord getmemberRecord(int memberID){
        return memberMapper.getmemberRecord(memberID);
    }
}
