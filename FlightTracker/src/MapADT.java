import java.util.NoSuchElementException;

public interface MapADT<KeyType, DestinationType, ETAType, FlightStatusType> {

	public boolean put(KeyType key, DestinationType destination, ETAType eta, FlightStatusType flightStatus);
	public String get(KeyType key) throws NoSuchElementException;
	public int size();
	public boolean containsKey(KeyType key);
	public String remove(KeyType key);
	public void clear();
	
}