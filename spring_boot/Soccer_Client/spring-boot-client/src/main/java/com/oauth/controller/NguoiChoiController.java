package com.oauth.controller;

//import api.managesoccer.model.NguoiChoi;
//import api.managesoccer.service.NguoiChoiService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/soccer/")
public class NguoiChoiController {
//    @Autowired
//    NguoiChoiService nguoiChoiService;
//
//    @GetMapping(value = "/nguoichoi")
//    public ResponseEntity<List<NguoiChoi>> listAllUsers() {
//        List<NguoiChoi> listtiso = nguoiChoiService.findAll();
//        if (listtiso.isEmpty()) {
//            return new ResponseEntity<List<NguoiChoi>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<NguoiChoi>>(listtiso, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/nguoichoi/delete/{id}")
//    public void deletePlayer(@PathVariable(value = "id") int id) {
//        nguoiChoiService.deletePlayer(id);
//    }
//    @PostMapping(value = "/createNguoiChoi")
//    public NguoiChoi createNguoiChoi(@RequestBody NguoiChoi nguoiChoi) {
//        return nguoiChoiService.addPlayer(nguoiChoi);
//    }
}
