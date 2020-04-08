package Perimeter;
import edu.duke.*;
import java.io.File;
public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDists
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints=0;
        for(Point currPoint: s.getPoints())
        {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength=getPerimeter(s)/getNumPoints(s);
        return averageLength;

    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide=0.0;
        Point prevPt=s.getLastPoint();
        for(Point currPt : s.getPoints())
        {
            if(largestSide<prevPt.distance(currPt))
                largestSide=prevPt.distance(currPt);
            prevPt=currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX=0.0;
        for(Point currPt:s.getPoints())
        {
            if(largestX<currPt.getX())
                largestX=currPt.getX();

        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter=0.0;
        DirectoryResource directoryResource=new DirectoryResource();
        for(File f:directoryResource.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s=new Shape(fr);
            double currPerimeter=getPerimeter(s);
            if(largestPerimeter<currPerimeter)
                largestPerimeter=currPerimeter;
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        // replace this code
        double largestPerimeter=0.0;
        DirectoryResource directoryResource=new DirectoryResource();
        for(File f:directoryResource.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s=new Shape(fr);
            double currPerimeter=getPerimeter(s);
            if(largestPerimeter<currPerimeter) {
                largestPerimeter = currPerimeter;
                temp=f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints=getNumPoints(s);
        System.out.println("Number of Points = " + numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("Average Length = " + averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);

    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest parameter is : "+getLargestPerimeterMultipleFiles());

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with largest parameter is : "+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
