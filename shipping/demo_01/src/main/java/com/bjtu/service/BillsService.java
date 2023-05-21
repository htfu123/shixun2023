package com.bjtu.service;

import com.bjtu.domain.Bills;
import com.bjtu.domain.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillsService {
    public boolean save(Bills bills);

    public List<Bills> getByOrderId(int order_id);

    public List<Bills> getByCarrierId(int carrier_id);
}
