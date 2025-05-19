package org.techdisqus.service.validators;

import com.innovatrics.dot.integrationsamples.disapi.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.techdisqus.service.utils.DateUtils;
import org.techdisqus.service.utils.DocumentUtils;
import org.techdisqus.service.validators.DocumentValidators.ValidationContext;
import org.techdisqus.util.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SelfieValidators {


    @Component
    public static class SelfieMatchValidator extends BaseValidator implements Validator<ValidationContext<CustomerInspectResponse>>{

        @Override
        public Result<Boolean> validate(ValidationContext<CustomerInspectResponse> validationContext) {

            if(validationContext.obj() != null) {

                CustomerInspectResponse customerInspectResponse = validationContext.obj();

                if(customerInspectResponse.getSecurity() != null) {
                    if (customerInspectResponse.getSecurity().getVideoInjection().getDetected()) {
                        return new Result<>(false, true);
                    }
                    if (customerInspectResponse.getSelfieInspection().getHasMask()) {
                        return new Result<>(false, true);
                    }
                    if (!customerInspectResponse.getSelfieInspection().getSimilarityWith().getDocumentPortrait()) {
                        return new Result<>(false, true);
                    }

                    if (!customerInspectResponse.getSelfieInspection().getSimilarityWith().getLivenessSelfies()) {
                        return new Result<>(false, true);
                    }

                    if (!customerInspectResponse.getSelfieInspection().getGenderConsistency().getDocumentPortrait()) {
                        return new Result<>(false, true);
                    }

                    if (customerInspectResponse.getSelfieInspection().getGenderConsistency().getViz() != null &&
                            !customerInspectResponse.getSelfieInspection().getGenderConsistency().getViz()) {
                        return new Result<>(false, true);
                    }

                    if (customerInspectResponse.getSelfieInspection().getGenderConsistency().getViz() != null &&
                            !customerInspectResponse.getSelfieInspection().getGenderConsistency().getMrz()) {
                        return new Result<>(false, true);
                    }
                }
            }


            return new Result<>(false, true);
        }
    }


}
