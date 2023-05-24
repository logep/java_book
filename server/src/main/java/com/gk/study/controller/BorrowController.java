package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Borrow;
import com.gk.study.permission.Access;
import com.gk.study.permission.AccessLevel;
import com.gk.study.service.BorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final static Logger logger = LoggerFactory.getLogger(BorrowController.class);

    @Autowired
    BorrowService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(){
        List<Borrow> list =  service.getBorrowList();

        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

    // 用户订单
    @RequestMapping(value = "/userBorrowList", method = RequestMethod.GET)
    public APIResponse userBorrowList(String userId){
        List<Borrow> list =  service.getUserBorrowList(userId);
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(Borrow borrow) throws IOException {
        service.createBorrow(borrow);
        return new APIResponse(ResponeCode.SUCCESS, "创建成功");
    }

    @Access(level = AccessLevel.ADMIN)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            service.deleteBorrow(id);
        }
        return new APIResponse(ResponeCode.SUCCESS, "删除成功");
    }


    @Access(level = AccessLevel.ADMIN)
    @RequestMapping(value = "/returnBorrow", method = RequestMethod.POST)
    @Transactional
    public APIResponse returnBorrow(Long id) throws IOException {
        Borrow borrow = new Borrow();
        borrow.setId(id);
        borrow.setStatus("2"); // 2=还
        service.updateBorrow(borrow);
        return new APIResponse(ResponeCode.SUCCESS, "操作成功");
    }

    @Access(level = AccessLevel.LOGIN)
    @RequestMapping(value = "/returnUserBorrow", method = RequestMethod.POST)
    @Transactional
    public APIResponse returnUserBorrow(Long id) throws IOException {
        Borrow borrow = new Borrow();
        borrow.setId(id);
        borrow.setStatus("2");
        service.updateBorrow(borrow);
        return new APIResponse(ResponeCode.SUCCESS, "操作成功");
    }

}
