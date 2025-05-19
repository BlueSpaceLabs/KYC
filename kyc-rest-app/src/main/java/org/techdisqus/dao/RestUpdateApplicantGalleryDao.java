package org.techdisqus.dao;


import org.springframework.stereotype.Component;
import org.techdisqus.dao.response.gallery.GalleryUpdateDaoResponse;

import java.util.Objects;

@Component
public class RestUpdateApplicantGalleryDao extends AbstractRestDao implements UpdateApplicantGalleryDao {

    public GalleryUpdateDaoResponse updateGallery(String externalId, String status) {
        return trustplatformRestClient
                .put()
                .uri("/abis/v3/applicants/" + externalId + "/move-to-gallery/" + status)
                .exchange((clientRequest, clientResponse) -> Objects.requireNonNull(clientResponse.bodyTo(GalleryUpdateDaoResponse.class)));

    }


}
