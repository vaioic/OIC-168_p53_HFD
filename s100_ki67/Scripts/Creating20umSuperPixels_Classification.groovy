selectAnnotations();
runPlugin('qupath.imagej.superpixels.SLICSuperpixelsPlugin', '{"sigmaMicrons":1.0,"spacingMicrons":20.0,"maxIterations":10,"regularization":0.25,"adaptRegularization":true}')
selectDetections();
runPlugin('qupath.lib.algorithms.IntensityFeaturesPlugin', '{"pixelSizeMicrons":0.1725,"region":"ROI","tileSizeMicrons":25.0,"channel1":true,"channel2":true,"channel3":true,"doMean":true,"doStdDev":true,"doMinMax":true,"doMedian":true,"doHaralick":true,"haralickMin":0.0,"haralickMax":10000.0,"haralickDistance":1,"haralickBins":32}')

def min_intensity=100//remove any nuclei with an area less than or equal to this value
measurement='ROI: 0.17 µm per pixel: Ki67: Std.dev.'
def toDelete = getDetectionObjects().findAll {measurement(it, measurement) <= min_intensity}
removeObjects(toDelete,true)

runObjectClassifier("Superpixels_20um");
selectAnnotations();
runPlugin('qupath.lib.plugins.objects.TileClassificationsToAnnotationsPlugin', '{"pathClass":"Profilerating Cluster","deleteTiles":false,"clearAnnotations":false,"splitAnnotations":false}')

//Add to end of any script running in batch to help clear up memory space. Very important for running batch scripts on HPC
Thread.sleep(100)
// Try to reclaim whatever memory we can, including emptying the tile cache
javafx.application.Platform.runLater {
    getCurrentViewer().getImageRegionStore().cache.clear()
    System.gc()
}
Thread.sleep(100)