public final class Hometown implements Serializable {
  // Private internal state
  private String town;
  private static final String UNKNOWN = "UNKNOWN";
 
  void performSecurityManagerCheck() throws AccessDeniedException {
    // ...
  }
 
  void validateInput(String newCC) throws InvalidInputException {
    // ...
  }
 
  public Hometown() {
    performSecurityManagerCheck();
 
    // Initialize town to default value
    town = UNKNOWN;
  }
 
  // Allows callers to retrieve internal state
  String getValue() {
    performSecurityManagerCheck();
    return town;
  }
 
  // Allows callers to modify (private) internal state
  public void changeTown(String newTown) {
    if (town.equals(newTown)) {
      // No change
      return;
    } else { 
      performSecurityManagerCheck();
      validateInput(newTown);
      town = newTown;
    }
  }
 
  private void writeObject(ObjectOutputStream out) throws IOException {
    out.writeObject(town);
  }
 
  private void readObject(ObjectInputStream in) throws IOException {
    in.defaultReadObject();
    // If the deserialized name does not match the default value normally
    // created at construction time, duplicate the checks
    if (!UNKNOWN.equals(town)) {
      validateInput(town);
    }
  }
}


public final class Hometown implements Serializable {
  // ... All methods the same except the following:
 
  // writeObject() correctly enforces checks during serialization
  private void writeObject(ObjectOutputStream out) throws IOException {
    performSecurityManagerCheck();
    out.writeObject(town);
  }
 
  // readObject() correctly enforces checks during deserialization
  private void readObject(ObjectInputStream in) throws IOException {
    in.defaultReadObject();
    // If the deserialized name does not match the default value normally
    // created at construction time, duplicate the checks
    if (!UNKNOWN.equals(town)) {
      performSecurityManagerCheck();
      validateInput(town);
    }
  }
}



