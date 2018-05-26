abstract public class Vehicle{
  protected String modelName;
  protected String company;
  protected String owner;
  protected String engineType;
  protected double tankSize;
  public double fuelConsumption;


  Vehicle(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption){
    this.modelName = modelName;
    this.company = company;
    this.owner = owner;
    this.engineType = engineType;
    this.tankSize = tankSize;
    this.fuelConsumption = fuelConsumption;
  }

  public String toString(){
    return "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption;
  }

  public double movableDistance(){
    return tankSize * fuelConsumption;
  }

  abstract public double costFor100Km(PetroleumPrice price);

  abstract public void setAirConON();

  abstract public void setAirConOFF();
}
