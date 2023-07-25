package com.cigniti.appledemo.service;

import com.cigniti.appledemo.entity.AppleTune;
import com.cigniti.appledemo.entity.AppleTunes;

public interface AppleDemoService {
     AppleTunes getAllTuneDetails(AppleTunes appleTunes);
     AppleTune getTuneDetails(AppleTunes appleTunes, long id);
     AppleTunes addTuneDetails(AppleTunes appleTunes, AppleTune appleTune);
     AppleTunes updateTuneDetails(AppleTunes appleTunes, AppleTune appleTune);
     AppleTunes deleteTuneDetails(AppleTunes appleTunes, long id);
}
