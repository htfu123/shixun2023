package com.bjtu.service;

import com.bjtu.domain.Bills;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;

@SpringBootTest
public class BillsServiceTest {
    @Autowired
    private BillsService billsService;
    @Test
    public void save() {
        billsService.save(new Bills(1,91,"上海",2,122));
    }

    @Test
    public void getByOrderId() {
        billsService.getByOrderId(1);
    }

    @Test
    public void getByCarrierId() {
        billsService.getByCarrierId(1);
    }
}
