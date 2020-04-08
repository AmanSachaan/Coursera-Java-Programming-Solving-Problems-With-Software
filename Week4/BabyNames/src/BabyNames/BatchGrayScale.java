package BabyNames;
import edu.duke.*;
import java.io.*;
public class BatchGrayScale {
    public ImageResource makeGray (ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel:outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    public void selectConvertAndSave()
    {
        DirectoryResource directoryResource=new DirectoryResource();
        for(File file:directoryResource.selectedFiles())
        {
            ImageResource inImage=new ImageResource(file);
            ImageResource outImage=makeGray(inImage);
            String newName="/home/aman/Pictures/gray-"+inImage.getFileName();
            outImage.setFileName(newName);
            outImage.save();
            outImage.draw();
        }
    }
    public static void main(String args[])
    {
        BatchGrayScale batchGrayScale=new BatchGrayScale();
        batchGrayScale.selectConvertAndSave();
    }
}
