package se.irori.model;

public enum Predicate {
  CREATE, DELETE, UPDATE, READ;

  public static Predicate from(String verb) {
    return CREATE;
  }
}
