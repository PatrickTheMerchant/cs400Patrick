import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class flightInfo {
  private File flightData;
  private Scanner scnr;
  private ArrayList<String> storage;;

  public flightInfo() throws FileNotFoundException {
    this.flightData = new File("FlightData.txt");
    this.scnr = new Scanner(flightData);
    this.storage = new ArrayList<String>(); // default constructor

  }

  public flightInfo(String fileName, int initialCap) throws FileNotFoundException {
    this.flightData = new File(fileName);
    this.scnr = new Scanner(flightData);
    this.storage = new ArrayList<String>(initialCap); // Constructor that u can set file and the
                                                      // initial capacity of the arrayList
  }

  /**
   * 
   * 
   * @return the ArrayList that store all the information
   * @throws FileNotFoundException
   */
  public ArrayList<String> input(int datasize) throws FileNotFoundException {
    for (int i = 0; i < datasize; i++) {
      if (scnr.hasNext()) {
        if (i % 4 == 0) {
          storage.add(scnr.next()); // if it is a flight number, no additional information added
                                    // (maybe beneficial to create a key?)
        } else if (i % 4 == 1) {
          storage.add("Flight Destination:" + scnr.next()); 
        } else if (i % 4 == 2) {
          storage.add("Flight ETA:" + scnr.next());
        } else if (i % 4 == 3) {
          storage.add("Flight Status:" + scnr.next());
        } // Add what type of information in front of it except for Flight number
      }
    }
    return storage;
  }
 
  /**
   * custom toString method that print the whole arrayList
   */
  @Override
  public String toString() {
    String data = "All flight: ";
    if (storage.size() == 0) {
      data = "Currently no flight information available"; // if nothing in the arrayList, output a prompt message
      return data;
    } else {
      data = data + "\n";
      for (int i = 0; i < storage.size(); i++) {
        if (i % 4 != 3) {
          data = data + storage.get(i) + " ";
        } else {
          data = data + storage.get(i) + "\n";
        } //each flight will have it own line
      }
    }
    return data;
  }

  public File getFlightData() {
    return flightData;
  }

  public void setFlightData(File flightData) {
    this.flightData = flightData;
  }

  public Scanner getScnr() {
    return scnr;
  }

  public void setScnr(Scanner scnr) {
    this.scnr = scnr;
  }

  public ArrayList<String> getStorage() {
    return storage;
  }

  public void setStorage(ArrayList<String> storage) {
    this.storage = storage;
  }
  
}
