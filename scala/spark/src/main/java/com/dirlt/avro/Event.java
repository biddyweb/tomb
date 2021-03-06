/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.dirlt.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Event extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Event\",\"namespace\":\"com.dirlt.avro\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"string\"},{\"name\":\"details\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Detail\",\"fields\":[{\"name\":\"f1\",\"type\":\"string\"},{\"name\":\"f2\",\"type\":\"string\"}]}},\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence event;
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence timestamp;
  @Deprecated public java.util.List<com.dirlt.avro.Detail> details;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Event() {}

  /**
   * All-args constructor.
   */
  public Event(java.lang.CharSequence event, java.lang.CharSequence id, java.lang.CharSequence timestamp, java.util.List<com.dirlt.avro.Detail> details) {
    this.event = event;
    this.id = id;
    this.timestamp = timestamp;
    this.details = details;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return event;
    case 1: return id;
    case 2: return timestamp;
    case 3: return details;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: event = (java.lang.CharSequence)value$; break;
    case 1: id = (java.lang.CharSequence)value$; break;
    case 2: timestamp = (java.lang.CharSequence)value$; break;
    case 3: details = (java.util.List<com.dirlt.avro.Detail>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'event' field.
   */
  public java.lang.CharSequence getEvent() {
    return event;
  }

  /**
   * Sets the value of the 'event' field.
   * @param value the value to set.
   */
  public void setEvent(java.lang.CharSequence value) {
    this.event = value;
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   */
  public java.lang.CharSequence getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.CharSequence value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'details' field.
   */
  public java.util.List<com.dirlt.avro.Detail> getDetails() {
    return details;
  }

  /**
   * Sets the value of the 'details' field.
   * @param value the value to set.
   */
  public void setDetails(java.util.List<com.dirlt.avro.Detail> value) {
    this.details = value;
  }

  /** Creates a new Event RecordBuilder */
  public static com.dirlt.avro.Event.Builder newBuilder() {
    return new com.dirlt.avro.Event.Builder();
  }
  
  /** Creates a new Event RecordBuilder by copying an existing Builder */
  public static com.dirlt.avro.Event.Builder newBuilder(com.dirlt.avro.Event.Builder other) {
    return new com.dirlt.avro.Event.Builder(other);
  }
  
  /** Creates a new Event RecordBuilder by copying an existing Event instance */
  public static com.dirlt.avro.Event.Builder newBuilder(com.dirlt.avro.Event other) {
    return new com.dirlt.avro.Event.Builder(other);
  }
  
  /**
   * RecordBuilder for Event instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Event>
    implements org.apache.avro.data.RecordBuilder<Event> {

    private java.lang.CharSequence event;
    private java.lang.CharSequence id;
    private java.lang.CharSequence timestamp;
    private java.util.List<com.dirlt.avro.Detail> details;

    /** Creates a new Builder */
    private Builder() {
      super(com.dirlt.avro.Event.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.dirlt.avro.Event.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.event)) {
        this.event = data().deepCopy(fields()[0].schema(), other.event);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[2].schema(), other.timestamp);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.details)) {
        this.details = data().deepCopy(fields()[3].schema(), other.details);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Event instance */
    private Builder(com.dirlt.avro.Event other) {
            super(com.dirlt.avro.Event.SCHEMA$);
      if (isValidValue(fields()[0], other.event)) {
        this.event = data().deepCopy(fields()[0].schema(), other.event);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[2].schema(), other.timestamp);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.details)) {
        this.details = data().deepCopy(fields()[3].schema(), other.details);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'event' field */
    public java.lang.CharSequence getEvent() {
      return event;
    }
    
    /** Sets the value of the 'event' field */
    public com.dirlt.avro.Event.Builder setEvent(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.event = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'event' field has been set */
    public boolean hasEvent() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'event' field */
    public com.dirlt.avro.Event.Builder clearEvent() {
      event = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.dirlt.avro.Event.Builder setId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'id' field */
    public com.dirlt.avro.Event.Builder clearId() {
      id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.CharSequence getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.dirlt.avro.Event.Builder setTimestamp(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.timestamp = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'timestamp' field has been set */
    public boolean hasTimestamp() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'timestamp' field */
    public com.dirlt.avro.Event.Builder clearTimestamp() {
      timestamp = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'details' field */
    public java.util.List<com.dirlt.avro.Detail> getDetails() {
      return details;
    }
    
    /** Sets the value of the 'details' field */
    public com.dirlt.avro.Event.Builder setDetails(java.util.List<com.dirlt.avro.Detail> value) {
      validate(fields()[3], value);
      this.details = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'details' field has been set */
    public boolean hasDetails() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'details' field */
    public com.dirlt.avro.Event.Builder clearDetails() {
      details = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Event build() {
      try {
        Event record = new Event();
        record.event = fieldSetFlags()[0] ? this.event : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.id = fieldSetFlags()[1] ? this.id : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.timestamp = fieldSetFlags()[2] ? this.timestamp : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.details = fieldSetFlags()[3] ? this.details : (java.util.List<com.dirlt.avro.Detail>) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
