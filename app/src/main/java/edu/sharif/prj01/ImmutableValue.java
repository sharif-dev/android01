package edu.sharif.prj01;

// Notice how the value for the ImmutableValue instance
// is passed in the constructor.
// Notice also how there is no setter method. Once an
// ImmutableValue instance is created you
// cannot change its value. It is immutable.
public class ImmutableValue{

    private int value = 0;

    public ImmutableValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    // If you need to perform operations on the ImmutableValue
    // instance you can do so by returning a new instance with
    // the value resulting from the operation.
    public ImmutableValue add(int valueToAdd){
        return new ImmutableValue(this.value + valueToAdd);
    }
}
