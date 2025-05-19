

# SelfieInspection

Results of the inspection of customer's selfie versus document. Please, read the chapter \"Trust Factors\" of the DOT documentation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**similarityWith** | [**SelfieSimilarityWith**](SelfieSimilarityWith.md) |  |  [optional] |
|**genderEstimate** | **String** | Estimated gender of the customer in the selfie, represented by: M for male, F for female |  [optional] [readonly] |
|**genderConsistency** | [**SelfieInspectionGenderConsistency**](SelfieInspectionGenderConsistency.md) |  |  [optional] |
|**ageEstimate** | **Integer** | Estimated age of the customer in the selfie in years. |  [optional] [readonly] |
|**ageDifferenceWith** | [**SelfieAgeDifferenceWith**](SelfieAgeDifferenceWith.md) |  |  [optional] |
|**hasMask** | **Boolean** | True if a person in the selfie is wearing a face mask |  [optional] [readonly] |



