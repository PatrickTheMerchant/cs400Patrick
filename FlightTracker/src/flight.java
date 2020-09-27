public class flight<KeyType, DestinationType, ETAType, FlightStatusType> {
  
private KeyType key;
private DestinationType destination;
private ETAType eta;
private FlightStatusType flightStatus;


  public flight() {
    key = null;
    destination = null;
    eta = null;
    flightStatus = null;
  }
  
  //The class can be constructed only with the key, or with all of the variables or none of them
  //alternatively, set and get operations are available for all variables
  public flight(KeyType key) {
    this.key = key;
  }
  
  public flight(KeyType key, DestinationType destination, ETAType eta, 
    FlightStatusType flightStatus) {
    this.key = key;
    this.destination = destination;
    this.eta = eta;
    this.flightStatus = flightStatus;
  }
  
  public KeyType getKey() {
    return this.key;
  }
  
  public DestinationType getDestination() {
    return this.destination;
  }
  
  public ETAType getETA() {
    return this.eta;
  }
  
  public FlightStatusType getFlightStatus() {
    return this.flightStatus;
  }
  
  public void setKey(KeyType key) {
    this.key = key;
  }
  
  public void setDestination(DestinationType destination) {
    this.destination = destination;
  }
  
  public void setETA(ETAType eta) {
    this.eta = eta;
  }
  
  public void setFlightStatus(FlightStatusType flightStatus) {
    this.flightStatus = flightStatus;
  }

}
