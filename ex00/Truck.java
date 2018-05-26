class Truck extends Vehicle{
  private int numberOfSeats;
  private boolean airConditionOn;
  private int power;

  Truck(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats, int power){
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    setNumberOfSeat(numberOfSeats);
    setPower(power);
  }

  public String toString(){
    return super.toString() + ", NumberOfSeat: " + this.numberOfSeats + ", HorsePower: " + this.power;
  }

  private void setNumberOfSeat(int numberOfSeats){
    this.numberOfSeats = numberOfSeats;
  }

  private void setPower(int power){
    this.power = power;
  }

  public double costFor100Km(PetroleumPrice price){
    return 100 / this.fuelConsumption * price.getDieselCost();
  }

  public void setAirConON(){
    this.airConditionOn = true;
    this.fuelConsumption *= 0.75;
  }

  public void setAirConOFF(){
    this.airConditionOn = false;
    this.fuelConsumption /= 0.75;
  }
}
