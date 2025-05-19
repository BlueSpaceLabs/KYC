package org.techdisqus.dao;

import org.springframework.stereotype.Component;
import org.techdisqus.dao.request.RegistrationEventDaoRequest;
import org.techdisqus.dao.response.RegistrationEventResponse;

@Component
public class RestRegisterEventDao extends AbstractRestDao implements RegisterEventDao {

	public RegistrationEventResponse registerSim(RegistrationEventDaoRequest daoRequest) {
		// refer https://awarex.atlassian.net/browse/SCI-63 for response

		return null;
	}


}
