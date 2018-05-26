class Car extends Vehicle {
  private int numberOfSeats;
  private boolean airConditionOn;

  Car(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats){
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    setNumberOfSeat(numberOfSeats);
    this.airConditionOn = false;
  }

  private void setNumberOfSeat(int numberOfSeats){
    this.numberOfSeats = numberOfSeats;
  }

  public String toString(){
    return super.toString() + ", numberOfSeat: " + numberOfSeats;
  }

  public double costFor100Km(PetroleumPrice price){
    return 100 / this.fuelConsumption * price.getGasolineCost();
  }

  public void setAirConON(){
    this.airConditionOn = true;
    this.fuelConsumption *= 0.85;
  }

  public void setAirConOFF(){
    this.airConditionOn = false;
    this.fuelConsumption /= 0.85;
  }
}
