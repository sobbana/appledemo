package com.cigniti.appledemo.service;

import com.cigniti.appledemo.entity.AppleTune;
import com.cigniti.appledemo.entity.AppleTunes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppleDemoServiceImpl implements  AppleDemoService{

    @Override
    public AppleTunes getAllTuneDetails(AppleTunes appleTunes) {
        return appleTunes;
    }

    @Override
    public AppleTune getTuneDetails(AppleTunes appleTunes, long id) {
        AppleTune appleTune = AppleTune.builder().build();
        if (appleTunes.getAppleTunes() == null) {
        } else {
            appleTune = appleTunes.getAppleTunes().stream().filter(x -> x.getId() == id).findFirst().get();
        }
        return appleTune;
    }

    @Override
    public AppleTunes addTuneDetails(AppleTunes appleTunes, AppleTune appleTune) {
        if (appleTunes.getAppleTunes() == null) {
            List<AppleTune> list = new ArrayList<>();
            list.add(appleTune);
            appleTunes.setAppleTunes(list);
        } else {
            appleTunes.getAppleTunes().add(appleTune);
        }
        return appleTunes;
    }

    @Override
    public AppleTunes updateTuneDetails(AppleTunes appleTunes, AppleTune appleTune) {
        return AppleTunes.builder().appleTunes(
                appleTunes.getAppleTunes().stream()
                        .map(y -> {
                            if (y.getId() == appleTune.getId()) {
                                y.setId(appleTune.getId());
                                y.setUid(appleTune.getUid());
                                y.setProductId(appleTune.getProductId());
                                y.setProductDes(appleTune.getProductDes());
                                y.setProductRef(appleTune.getProductRef());
                                y.setProductType(appleTune.getProductType());
                                return y;
                            } else {
                                return  y;
                            }
                        }).collect(Collectors.toList())).build();
    }

    @Override
    public AppleTunes deleteTuneDetails(AppleTunes appleTunes, long id) {
        if (appleTunes.getAppleTunes() == null) {
        } else {
            appleTunes.getAppleTunes().removeIf(x -> x.getId()==id);
        }
        return appleTunes;
    }
}
