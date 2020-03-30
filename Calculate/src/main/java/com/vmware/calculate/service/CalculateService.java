package com.vmware.calculate.service;

import com.vmware.calculate.model.BaseResponseTO;
import com.vmware.calculate.model.Operands;
import org.springframework.web.bind.annotation.RequestBody;

public interface CalculateService {

    BaseResponseTO<Integer> addNumbers(@RequestBody Operands operands);
    BaseResponseTO<Integer> subtractNumbers(@RequestBody Operands operands);
}
