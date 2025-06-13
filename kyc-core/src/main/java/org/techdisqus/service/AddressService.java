package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.response.Entity;

import java.util.List;

public interface AddressService {

     List<Entity> getEntities(String code, String type, KycRequestHeaders kycRequestHeaders);
}
