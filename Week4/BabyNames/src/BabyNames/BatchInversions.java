package BabyNames;
import edu.duke.*;
import java.io.*;
public class BatchInversions{
    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel:outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setBlue(255-inPixel.getBlue());
        }
        return outImage;
    }
    public void selectAndConvert()
    {
        DirectoryResource directoryResource=new DirectoryResource();
        for(File file:directoryResource.selectedFiles())
        {
            ImageResource inImage=new ImageResource(file);
            ImageResource outImage=makeInversion(inImage);
            String newName="/home/aman/Pictures/inverted-"+inImage.getFileName();
            outImage.setFileName(newName);
            outImage.save();
            outImage.draw();
        }
    }
    public static void main(String args[])
    {
        BatchInversions batchInversions=new BatchInversions();
        batchInversions.selectAndConvert();
    }
}
