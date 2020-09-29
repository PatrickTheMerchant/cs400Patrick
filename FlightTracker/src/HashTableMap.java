// --== CS400 File Header Information ==--
// Name: Patrick Merchant
// Email: plmerchant@wisc.edu
// Team: GC
// TA: Dan
// Lecturer: Florian
// Notes to Grader: none
                                                                                                    
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Class creates an array of linked lists that store Key and Value Pairs, utilizes hashing to store
 * Pairs according to the hash code of the key value. Able to add get and remove key value pairs from 
 * the array, when the array is more than 80 percent full the array size is doubled and all Pairs are
 * rehashed and stored in the new array. Collisions are handled via linked list. Implements MapADT.
 * @author PatrickM
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashTableMap<KeyType, ETAType, FlightStatusType, DestinationType> implements MapADT<KeyType, DestinationType, ETAType, FlightStatusType> {
	
	private LinkedList<flight>[] hashTable;
	
	/**
	 * Constructor initializes the hashTable with length capacity.
	 * @param capacity
	 */
	public HashTableMap(int capacity) {
		hashTable = new LinkedList[capacity];
	}
	
	/**
	 * Default constructor initializes the hashTable with length 10.
	 */
	public HashTableMap() {
		hashTable = new LinkedList[10];
	}

	/**
	 * Helper method that doubles the capacity of the array and rehashes all pairs according to the new 
	 * table capacity
	 */
	private void resize() {
		LinkedList<flight>[] tempHash = new LinkedList[hashTable.length + hashTable.length];
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (int j = 0; j < hashTable[i].size(); j++) {
					if (tempHash[Math.abs(hashTable[i].get(j).getKey().hashCode())%
					             (hashTable.length + hashTable.length)] != null) {
						tempHash[Math.abs(hashTable[i].get(j).getKey().hashCode())%
						         (hashTable.length + hashTable.length)].add(hashTable[i].get(j));
					}
					else {
						tempHash[Math.abs(hashTable[i].get(j).getKey().hashCode())%
						         (hashTable.length + hashTable.length)] = new LinkedList<flight>();
						tempHash[Math.abs(hashTable[i].get(j).getKey().hashCode())%
						         (hashTable.length + hashTable.length)].add(hashTable[i].get(j));
					}
				}
			}
		}
		hashTable = tempHash;
	}
	
	/**
	 * Adds key values pairs to the array by hashing the key value to get the index to store to.
	 * Returns true when pair is successfully stored false otherwise. 
	 */
	@Override
	public boolean put(KeyType key, DestinationType destination, ETAType eta, 
		    FlightStatusType flightStatus) {
		flight information = new flight(key, destination, eta, flightStatus);
		if(hashTable[Math.abs(key.hashCode())%hashTable.length] != null) { 
			for(int i = 0; i < hashTable[Math.abs(key.hashCode())%hashTable.length].size(); i++) {
				if (hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getKey().equals(key)) {
					return false;
				}
			}
			hashTable[Math.abs(key.hashCode())%hashTable.length].add(information);
		} else {
			hashTable[Math.abs(key.hashCode())%hashTable.length] = new LinkedList<flight>();
			hashTable[Math.abs(key.hashCode())%hashTable.length].add(information);
		}
		if(hashTable.length*0.8 <= this.size()) {
			this.resize();
		}
		return true;
	}

	/**
	 * Retrieves the value of the input key that is paired with the value by hashing the input key
	 * to find the according hash index in the array, then finds the correct key value pair if
	 * there are multiple pair in the same index.
	 */
	@Override
	public String get(Object key) throws NoSuchElementException {
		if (hashTable[Math.abs(key.hashCode())%hashTable.length] != null) {
			for(int i = 0; i < hashTable[Math.abs(key.hashCode())%hashTable.length].size(); i++) {
				if ( hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getKey().equals(key)) {
					return ( (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getKey() 							
							+ " " + (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getDestination()
							+ " " + (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getETA()
							+ " " + (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getFlightStatus());
				}
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * returns the number of pairs in the array.
	 */
	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null) {
				for(int j = 0; j < hashTable[i].size(); j++) {
					size++;
				}
			}
		}
		return size;
	}

	/**
	 * Searches the hashTable for the input key by finding the hash index of the input key then comparing it
	 * to the pairs in the found index. Returns true when found, false otherwise.
	 */
	@Override
	public boolean containsKey(Object key) {
		if(hashTable[Math.abs(key.hashCode())%hashTable.length] != null) {
			for(int i = 0; i < hashTable[Math.abs(key.hashCode())%hashTable.length].size(); i++) {
				if ( hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Removes the specified pair by finding the hash index of the input key then comparing it to the the pairs in
	 * the found index. If found the correct pair method removes the pair and returns the value of the pair. Returns
	 * null if not found.
	 */
	@Override
	public String remove(Object key) {
		if(hashTable[Math.abs(key.hashCode())%hashTable.length] != null) {
			for(int i = 0; i < hashTable[Math.abs(key.hashCode())%hashTable.length].size(); i++) {
				if (hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getKey().equals(key)) {
					String targetVal = (String) (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getKey() 							
							+ " " + (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getDestination()
							+ " " + (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getETA()
							+ " " + (String)hashTable[Math.abs(key.hashCode())%hashTable.length].get(i).getFlightStatus();    //FIXME
					hashTable[Math.abs(key.hashCode())%hashTable.length].remove(i);
					return targetVal;
				}
			}
		}
		return null;
	}

	/**
	 * Clears all key value pairs within the hashTable.
	 */
	@Override
	public void clear() {
		int capacity = hashTable.length;
		hashTable = new LinkedList[capacity];
//		for (int i = 0; i < hashTable.length; i++) {
//			hashTable[i] = null;
//		}
	}

}
