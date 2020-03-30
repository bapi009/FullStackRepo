package com.vmware.calculate.service.impl;

import com.vmware.calculate.model.BaseResponseTO;
import com.vmware.calculate.model.Operands;
import com.vmware.calculate.service.CalculateService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public BaseResponseTO<Integer> addNumbers(Operands operands) {
        return new BaseResponseTO(HttpStatus.OK, "Added Successfully", operands.getX()+operands.getY());
    }

    @Override
    public BaseResponseTO<Integer> subtractNumbers(Operands operands) {
        return new BaseResponseTO(HttpStatus.OK, "Subtracted Successfully", operands.getX()-operands.getY());
    }
}
