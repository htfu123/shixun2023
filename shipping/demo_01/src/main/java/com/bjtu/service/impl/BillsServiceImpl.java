package com.bjtu.service.impl;

import com.bjtu.dao.BillsDao;
import com.bjtu.domain.Bills;
import com.bjtu.domain.Order;
import com.bjtu.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillsServiceImpl implements BillsService {
    @Autowired
    private BillsDao billsDao;
    @Override
    public boolean save(Bills bills) {
        billsDao.save(bills);
        return true;
    }

    @Override
    public List<Bills> getByOrderId(int order_id) {
        return billsDao.getByOrderId(order_id);
    }

    @Override
    public List<Bills> getByCarrierId(int carrier_id) {
        return billsDao.getByCarrierId(carrier_id);
    }
}
