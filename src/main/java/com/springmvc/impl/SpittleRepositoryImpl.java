package com.springmvc.impl;

import com.springmvc.entity.Spitter;
import com.springmvc.entity.Spittle;
import com.springmvc.itf.SpittleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        Spittle spittle = new Spittle("Hello",new Date());
        return spittle;
    }

    @Override
    public Spitter save(Spitter spitter) {
        System.out.println("spitter = [" + spitter.toString() + "]");
        return spitter;
    }

    @Override
    public Spitter findSpitterByName(String username) {
        return new Spitter(24L,"Jack","Bauer","jbauer","24hours");
    }
}
