package com.example.elasticsearch.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.elasticsearch.service.DSOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DSController")
public class DSController {

        @Autowired
        private DSOneService dsOneService;

        @GetMapping("/oneTest")
        public R oneTest(){
                dsOneService.oneTest();
                return null;
        }

        @GetMapping("/twoTest")
        public R twoTest(Integer id){
                dsOneService.twoTest(id);
                return null;
        }

}
