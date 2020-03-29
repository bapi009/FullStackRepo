package com.vmware.calculate.service;

import com.vmware.calculate.model.BaseResponseTO;
import com.vmware.calculate.model.Operands;
import org.springframework.web.bind.annotation.RequestBody;

public interface CalculateService {

    public BaseResponseTO<Integer> addNumbers(@RequestBody Operands operands);
    public BaseResponseTO<Integer> subtractNumbers(@RequestBody Operands operands);
}
