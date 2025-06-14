package org.techdisqus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.response.Entity;
import org.techdisqus.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Entity>> getEntity(@RequestParam("type") String type,
                                                 @RequestParam("code") String code, KycRequestHeaders kycRequestHeaders) {

        return ResponseEntity.ok(addressService.getEntities(code, type,kycRequestHeaders));

    }
}
