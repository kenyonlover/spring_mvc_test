package com.springmvc.itf;

import com.springmvc.entity.Spitter;
import com.springmvc.entity.Spittle;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SpittleRepository {
    /**
     * 展现最近提交的Spittle列表
     * @param max 所返回的 Spittle中，Spittle ID属性的最大值
     * @param count 要返回 多少个Spittle对象
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);

    Spitter save(Spitter spitter);

    Spitter findSpitterByName(String username);
}
