package org.techdisqus.dao;


import org.techdisqus.dao.response.gallery.GalleryUpdateDaoResponse;

import java.util.concurrent.Future;

public interface UpdateApplicantGalleryDao {

    GalleryUpdateDaoResponse updateGallery(String externalId, String status);

}
