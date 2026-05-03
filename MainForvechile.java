public class MainForvechile{
    public static void printvechileDetails(vechile v){
        System.out.println("Brand Name: " + v.brandName);
        System.out.println("Model Name: " + v.modelName);
        System.out.println("Color: " + v.color);
        System.out.println("Price: " + v.price);
        System.out.println("Manufacturing Code: " + v.mfgCode);
        System.out.println("Fuel Type: " + v.fuelType);
        System.out.println("Seating Capacity: " + v.seatingCapacity);
    }
    public static void main(String[] args){
        vechile myVechile = new vechile();
        myVechile.brandName = "Toyota";
        myVechile.modelName = "Camry";
        myVechile.color = "Red";
        myVechile.price = 30000.0;
        myVechile.mfgCode = "TY12345";
        myVechile.fuelType = "Petrol";
        myVechile.seatingCapacity = "5";

        printvechileDetails(myVechile);

        myVechile.start();
        myVechile.drive();
        float newSpeed = myVechile.accelerate(50);
        System.out.println("New Speed after acceleration: " + newSpeed);
        float mileage = myVechile.calculateMileage(500, 25);
        System.out.println("Calculated Mileage: " + mileage + " km/l");
        myVechile.stop();
    
        vechile myVechile1 = new vechile();
        myVechile1.brandName = "Honda";
        myVechile1.modelName = "Civic";
        myVechile1.color = "Blue";
        myVechile1.price = 28000.0;
        myVechile1.mfgCode = "HN67890";
        myVechile1.fuelType = "Diesel";
        myVechile1.seatingCapacity = "5";
        printvechileDetails(myVechile1);

        myVechile1.start();
        myVechile1.drive();
        float newSpeed1 = myVechile1.accelerate(10);
        System.out.println("New Speed after acceleration: " + newSpeed1);
        float mileage1 = myVechile1.calculateMileage(600, 30);
        System.out.println("Calculated Mileage: " + mileage1 + " km/l");
        myVechile1.stop();
    }
}  