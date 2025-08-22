# H&E Adipocyte and Immunofluorescence Segmentation

The following software and extensions were used for analysis:

- [QuPath v5.1](https://github.com/qupath/qupath/releases/tag/v0.5.1)
- [SAM QuPath extension v7.0](https://github.com/ksugar/qupath-extension-sam/releases/tag/v0.7.0)
- [Python env for SAM](https://github.com/ksugar/samapi)
- [StarDist QuPath extension v5.0](https://github.com/qupath/qupath-extension-stardist/releases/tag/v0.5.0)
- [Model Files for StarDist](https://github.com/qupath/models)
- [BIOP CellPose QuPath Extension v0.9.6](https://github.com/BIOP/qupath-extension-cellpose/releases/tag/v0.9.6)
- [CellPose python env v3.1.1](https://github.com/MouseLand/cellpose/releases/tag/v3.1.1)

The [Models_and_Classifiers](/Models_and_Classifiers/) folder contains the custom trained CellPose adipocyte segmentation model and the object classifier models trained in QuPath.

The [Scripts](/Scripts/) folder contains the groovy scripts for running all segmentation and classification steps in batch.