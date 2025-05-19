package org.techdisqus.dao;


import org.techdisqus.dao.request.RegistrationEventDaoRequest;
import org.techdisqus.dao.response.RegistrationEventResponse;

import java.util.concurrent.Future;

public interface RegisterEventDao{

	RegistrationEventResponse registerSim(RegistrationEventDaoRequest daoRequest);


}
