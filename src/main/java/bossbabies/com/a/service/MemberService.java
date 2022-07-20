package bossbabies.com.a.service;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.parameterVO.UpdateMemberVO;

public interface MemberService {
    int regiMember(MemberDto memberDto);
    MemberDto loginMember(LoginVO vo);

    MemberDto getMember(String id);
    int updateMember(UpdateMemberVO vo);
}
