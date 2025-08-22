
//things to import
import qupath.ext.biop.cellpose.Cellpose2D
/**
 * Cellpose Detection Template script
 * @author Olivier Burri
 *
 * This script is a template to detect objects using a Cellpose model from within QuPath.
 * After defining the builder, it will:
 * 1. Find all selected annotations in the current open ImageEntry
 * 2. Export the selected annotations to a temp folder that can be specified with tempDirectory()
 * 3. Run the cellpose detction using the defined model name or path
 * 4. Reimport the mask images into QuPath and create the desired objects with the selected statistics
 *
 * NOTE: that this template does not contain all options, but should help get you started
 * See all options in https://biop.github.io/qupath-extension-cellpose/qupath/ext/biop/cellpose/CellposeBuilder.html
 * and in https://cellpose.readthedocs.io/en/latest/command.html
 *
 * NOTE 2: You should change pathObjects get all annotations if you want to run for the project. By default this script
 * will only run on the selected annotations.
 */

// Specify the model name (cyto, nuclei, cyto2, ... or a path to your custom model as a string)
// Other models for Cellpose https://cellpose.readthedocs.io/en/latest/models.html
// And for Omnipose: https://omnipose.readthedocs.io/models.html
def pathModel = "path/to/Generalized_Adipocyte_V2"
//Detect smaller adipocytes
def cellpose = Cellpose2D.builder( pathModel )
        .pixelSize( 0.5 )                  // Resolution for detection in um
        .channels( 0,1 )	               // Select detection channel(s)
        .tileSize(2048)                  // If your GPU can take it, make larger tiles to process fewer of them. Useful for Omnipose
        .cellposeChannels( 0,0 )           // Overwrites the logic of this plugin with these two values. These will be sent directly to --chan and --chan2
        .diameter(95.15)                    // Median object diameter. Set to 0.0 for the `bact_omni` model or for automatic computation
//        .classify( "Adipocytes_300" )       // PathClass to give newly created objects
        .addParameter('gpu_device','1')
        .build()

def imageData = getCurrentImageData()
def pathObjects = getAnnotationObjects() // To process all annotations. For working in batch mode
if (pathObjects.isEmpty()) {
    Dialogs.showErrorMessage( "Cellpose", "Please select a parent object!" )
    return
}
cellpose.detectObjects( imageData, pathObjects )

