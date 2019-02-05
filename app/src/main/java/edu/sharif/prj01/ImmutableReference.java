package edu.sharif.prj01;

// It is important to remember, that even if an
// object is immutable and thereby thread safe,
// the reference to this object may not be thread safe
//
// The class holds a reference to an
// ImmutableValue instance. Notice how it is possible
// to change that reference through both the setValue()
// and add() methods. Therefore, even if the Calculator
// class uses an immutable object internally, it is not
// itself immutable, and therefore not thread safe.
// In other words: The ImmutableValue class is thread safe,
// but the use of it is not.
public class ImmutableReference {
    private ImmutableValue currentValue = null;

    public ImmutableValue getValue(){
        return currentValue;
    }

    public void setValue(ImmutableValue newValue){
        this.currentValue = newValue;
    }

    public void add(int newValue){
        this.currentValue = this.currentValue.add(newValue);
    }
}

