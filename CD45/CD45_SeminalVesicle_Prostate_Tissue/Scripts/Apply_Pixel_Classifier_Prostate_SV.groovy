//apply pixel classifier for the two tissues and create a detection object to show the outline of the detected signal

def tissues = getAnnotationObjects()

for (tissue in tissues) {
    if (tissue.getName() == 'SV') {
        getCurrentHierarchy().getSelectionModel().setSelectedObject(tissue, false);
        addPixelClassifierMeasurements("SV_CD45_PixelClassifier_RTrees_FullTissues", "SV_CD45_PixelClassifier_RTrees_FullTissues");
        createDetectionsFromPixelClassifier("SV_CD45_PixelClassifier_RTrees_FullTissues", 0.0, 0.0)
    } 
    
    if (tissue.getName() == 'Prostate') {
        getCurrentHierarchy().getSelectionModel().setSelectedObject(tissue, false);
        addPixelClassifierMeasurements("Prostate_CD45", "Prostate_CD45");
        createDetectionsFromPixelClassifier("Prostate_CD45", 0.0, 0.0)
    }
}