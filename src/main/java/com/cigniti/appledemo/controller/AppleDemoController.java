package com.cigniti.appledemo.controller;

import com.cigniti.appledemo.entity.AppleTune;
import com.cigniti.appledemo.entity.AppleTunes;
import com.cigniti.appledemo.service.AppleDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * There is an API that needs to be tested and url is https://developer.apple.com/library/archive/documentation/AudioVideo
 * /Conceptual/iTuneSearchAPI/index.html#//apple_ref/doc/uid/TP40017632-CH3-SW1
 */
@RestController
@RequestMapping("/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI")
public class AppleDemoController {
    @Autowired
    private AppleDemoService appleDemoService;

    private static AppleTunes appleTunes = AppleTunes.builder().build();

    @GetMapping("/all")
    public ResponseEntity<AppleTunes> getAllDetails() {
        this.appleTunes = appleDemoService.getAllTuneDetails(appleTunes);
        return ResponseEntity.ok().body(this.appleTunes);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AppleTune> getAllTuneDetails(@PathVariable long id) {
        return ResponseEntity.ok().body(appleDemoService.getTuneDetails(appleTunes, id));
    }

    @PostMapping("/apple_ref/doc/uid")
    public ResponseEntity<AppleTunes> addTunesDetails(@RequestBody AppleTune appleTune) {
        this.appleTunes = appleDemoService.addTuneDetails(appleTunes, appleTune);
        return ResponseEntity.ok().body(this.appleTunes);
    }

    @PutMapping("/apple_ref/doc/uid/{id}")
    public ResponseEntity<AppleTunes> updateTunesDetails(@RequestBody AppleTune appleTune) {
        this.appleTunes = appleDemoService.updateTuneDetails(appleTunes, appleTune);
        return ResponseEntity.ok().body(this.appleTunes);
    }

    @DeleteMapping("/apple_ref/doc/uid/{id}")
    public ResponseEntity<AppleTunes> deleteTunesDetails(@PathVariable long id) {
        this.appleTunes = appleDemoService.deleteTuneDetails(appleTunes, id);
        return ResponseEntity.ok().body(this.appleTunes);
    }
}
