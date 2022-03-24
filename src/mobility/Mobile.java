package mobility;
import java.lang.Math.*;


public abstract class Mobile {
    //Attributes
    private Point location; //Current location
    private double totalDistance;//Distance the object traveled (greater than zero).


    //Methods

    Mobile(Point p){
        this.setLocation(p);
        this.totalDistance = 0;
    }

    Mobile(){
        //TODO
    }
    void addTotalDistance(double distance){
        this.setTotalDistance(this.getTotalDistance() + distance); // adds given distance to old distance.
    }

    boolean setLocation(Point location){
        this.location = location;
        return true;
    }

    Point getLocation(){return location;}


    boolean setTotalDistance(double d){
        if (d<=0)
            return false;
        this.totalDistance += d;
        return true;

    }


    double getTotalDistance(){return totalDistance;}

    double calcDistance(Point other){
        /*Return the distance of the obj from received point*/
        return Math.sqrt((Math.pow(this.location.getX() - other.getX(),2) +Math.pow((this.location.getY() - other.getY()),2))); // sqrt((x_1 + x_2)^2 +(y_1 + y_2)^2)
    }

    double move(Point other){
        double distance = this.calcDistance(other); // returns distance between 2 Points.
        this.setLocation(other); //setting location of our obj to other obj location.
        this.addTotalDistance(distance); //updating total distance traveled.
        return distance;
    }




}
