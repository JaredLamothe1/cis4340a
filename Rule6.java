try {
  // ...
} catch (SecurityException se) {
  System.err.println(se);
  // Recover from exception
}

try {
  // ...
} catch(SecurityException se) {
  logger.log(Level.SEVERE, se);
  // Recover from exception
}
