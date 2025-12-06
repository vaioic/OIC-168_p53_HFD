# IF WSI Image Analysis

The following software and extensions were used:

- [QuPath v5.1](https://github.com/qupath/qupath/releases/tag/v0.5.1)
- [SAM QuPath extension v7.0](https://github.com/ksugar/qupath-extension-sam/releases/tag/v0.7.0)
- [Python env for SAM](https://github.com/ksugar/samapi)
- [BIOP CellPose QuPath Extension v0.9.6](https://github.com/BIOP/qupath-extension-cellpose/releases/tag/v0.9.6)
- [CellPose python env v3.1.1](https://github.com/MouseLand/cellpose/releases/tag/v3.1.1)

Scripts and classifier models are organized by the stain and tissue they were used for:

- [CD45 Area Analyses](/CD45/)
- [p53 Mean Fluorescence Intensity Analyses](/p53/)
- [s100_ki67 Proliferative Adipocyte Analysis](/s100_ki67/)

**Please note that the classifiers in this GitHub Repo are unlikely to work on images that were not collected in the same way (i.e., sample prep, IF staining protocols and imaging protocols on the same microscope), but the scripts and tools used may serve as a helpful outline for similar analyses**