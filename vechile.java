public class vechile {
    public String brandName;
    public String modelName;
    public String color;
    public double price;
    public String mfgCode;
    public String fuelType;
    public String seatingCapacity;
    public void setmfgCode(String mfgCode){
        this.mfgCode = mfgCode;
    }
    public vechile(){
        this.brandName = "Unknown";
        this.modelName = "Unknown";
        this.color = "Unknown";
        this.price = 0.0;
        this.mfgCode = "0000";
        this.fuelType = "Unknown";
        this.seatingCapacity = "0";
    }

    public vechile(String brandName, String modelName, String color, double price, String mfgCode, String fuelType, String seatingCapacity){
        this.brandName = brandName;
        this.modelName = modelName;
        this.color = color;
        this.price = price;
        this.mfgCode = mfgCode;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
    }
    public vechile(vechile v){
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.color = v.color;
        this.price = v.price;
        this.mfgCode = v.mfgCode;
        this.fuelType = v.fuelType;
        this.seatingCapacity = v.seatingCapacity;
    }

    


    public String getmfgCode(){
        return mfgCode;
    } 
     
    public void start(){
        System.out.println("Vechile Started");
    }
    public void drive(){
        System.out.println("Vechile is in motion");
    }
    public void stop(){
        System.out.println("Vechile Stopped");
    }
    public float accelerate(float speed){
        float newSpeed;
        if (speed<20)
            newSpeed=speed + 20;
        else 
            newSpeed=speed - 20;
        return newSpeed;
    }
    public float calculateMileage(float distance, float fuelConsumed){
        return distance/fuelConsumed;
    }
}

