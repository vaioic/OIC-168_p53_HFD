selectAnnotations();
createDetectionsFromPixelClassifier("CD45_Huang", 25.0, 0.0)
selectObjectsByClassification("Huang");
addShapeMeasurements("AREA")
runPlugin('qupath.lib.algorithms.IntensityFeaturesPlugin', '{"pixelSizeMicrons":0.5,"region":"ROI","tileSizeMicrons":0.0,"channel1":false,"channel2":true,"doMean":true,"doStdDev":true,"doMinMax":true,"doMedian":true,"doHaralick":false,"haralickMin":NaN,"haralickMax":NaN,"haralickDistance":1,"haralickBins":32}')