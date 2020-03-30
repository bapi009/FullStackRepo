package com.vmware.calculate.controller;

import com.vmware.calculate.model.BaseResponseTO;
import com.vmware.calculate.model.Operands;
import com.vmware.calculate.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculateController {

    @Autowired
    CalculateService calculateService;

    @PostMapping("/add")
    public ResponseEntity<BaseResponseTO> addNumbers(@RequestBody Operands operands) {
        BaseResponseTO<Integer> responseTO = calculateService.addNumbers(operands);
        return new ResponseEntity<>(responseTO, responseTO.getStatus());
    }

    @PostMapping("/diff")
    public ResponseEntity<BaseResponseTO> subtractNumbers(@RequestBody Operands operands) {
        BaseResponseTO<Integer> responseTO = calculateService.subtractNumbers(operands);
        return new ResponseEntity<>(responseTO, responseTO.getStatus());
    }
}
