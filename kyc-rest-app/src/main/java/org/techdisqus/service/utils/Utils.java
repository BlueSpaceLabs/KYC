package org.techdisqus.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@Slf4j
public class Utils {

    @Value("${threshold:0.8}")
    private double threshold;

    public boolean doFuzzyMatch(String currentName, String actualName, Map<String, String> reqInfo) {
        currentName = currentName.replace(" ", "").toLowerCase();
        actualName = actualName.replace(" ","").toLowerCase();

        JaroWinklerDistance jaroWinklerDistance = new JaroWinklerDistance();
        Double score = jaroWinklerDistance.apply(currentName,actualName);

        return score > threshold;
    }
}
