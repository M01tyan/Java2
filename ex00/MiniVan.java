class MiniVan extends Vehicle{
  private int numberOfSeats;
  private boolean airConditionOn;
  private boolean hasAutoDoor;

  MiniVan(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats, boolean hasAutoDoor){
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    setNumberOfSeat(numberOfSeats);
    setHasAutoDoor(hasAutoDoor);
    this.airConditionOn = false;
  }

  public String toString(){
    return super.toString() + ", NumberOfSeat: " + this.numberOfSeats + ", HasAutoDoor: " + this.hasAutoDoor;
  }

  private void setNumberOfSeat(int numberOfSeats){
    this.numberOfSeats = numberOfSeats;
  }

  private void setHasAutoDoor(boolean hasAutoDoor){
    this.hasAutoDoor = hasAutoDoor;
  }

  public double costFor100Km(PetroleumPrice price){
    switch(this.engineType){
      case "Gasoline":
        return 100 / this.fuelConsumption * price.getGasolineCost();
      case "Diesel":
        return 100 / this.fuelConsumption * price.getDieselCost();
      default:
        return -1;
    }
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
