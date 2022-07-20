package bossbabies.com.a.controller;

import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import bossbabies.com.a.dto.mypage.ReviewDto;
import bossbabies.com.a.parameterVO.ReviewVO;
import bossbabies.com.a.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]마이페이지
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       이성은         신규생성
 * -----------------------------------------------------------
 */

@Controller
public class MyPageController {

    @Autowired
    MyPageService service;

    @GetMapping("mypage.do")
    public String orderList(MyPageDto md, Model model) {
        MyPageDto member = service.getMember(md);
        List<OrderedBookDto> orderItemList = service.getOrderList(md);
        List<LikedBookDto> likeItemList = service.getLikeList(md);
        List<ReviewDto> reviewList = service.getReviewList(md);

        model.addAttribute("member", member);
        model.addAttribute("orderList", orderItemList);
        model.addAttribute("likeList", likeItemList);
        model.addAttribute("reviewList", reviewList);

        return "myPage";
    }

    @GetMapping("cancelOrder.do")
    public String cancelOrder(int orderId, int memberId) {
        service.cancelOrder(orderId);

        return "redirect:/mypage.do?memberId=" + memberId;
    }

    @GetMapping("deleteLike.do")
    public String deleteLike(int likeId, int memberId){
        service.deleteLike(likeId);

        return "redirect:/mypage.do?memberId=" + memberId;
    }

    @GetMapping("writeReview.do")
    public String writeReview() {

        return "writeReview";
    }

    @PostMapping("writeReviewAf.do")
    public String writeReviewAf(ReviewVO reviewVO) {
        service.writeReview(reviewVO);

        return "redirect:/mypage.do?memberId=" + reviewVO.getMemberId();
    }


}
