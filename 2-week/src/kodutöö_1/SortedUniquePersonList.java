package kodutöö_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Collection for holding kodutöö_1.Person objects.<br>
 * Provides the following guarantees:<br>
 * 1) Elements are guaranteed to be in ascending order, sorted by their ID code value.<br>
 * 2) Elements are guaranteed to have unique ID code values.<br>
 *
 * Uses an underlying array for storing the elements. <br>
 * The object guarantees to not use more than twice the required array size.<br>
 * For example, if currently 10 persons are stored, then the underlying array size might range from 10 to 20, but will not be larger.
 */
public class SortedUniquePersonList {
    private Person[] arrayPersons;

    public SortedUniquePersonList() {
        this.arrayPersons = new Person[0];
    }

    public static void main(String[] args) {
        SortedUniquePersonList newList = new SortedUniquePersonList();
        Person isik1 = new Person(1, "Kadri", "Tuulik");
        Person isik2 = new Person(4, "Sigrid", "Kast");
        Person isik3 = new Person(5, "Tiina", "Komm");
        Person isik4 = new Person(10, "Kalle", "Kalvi");
        newList.add(isik1);
        newList.add(isik2);
        newList.add(isik3);
        newList.add(isik4);
        System.out.println(newList.size() + " : " +Arrays.toString(newList.arrayPersons));
        newList.removeElement(1);
        System.out.println(newList.size() + " : " +Arrays.toString(newList.arrayPersons));
    }
    /**
     * Returns reference to object at the given index. Checks that the given index is in bounds of the underlying array, returns null if it isn't.
     * @param index Index at which the object is searched.
     * @return kodutöö_1.Person object at the given index, or null if the index is out of bounds.
     */
    public Person getElementAt(int index) {
        int sizeOfArray = this.arrayPersons.length;
        if (index < sizeOfArray && index >= 0) {
            return this.arrayPersons[index];
        }
        else {
            return null;
        }
    }

    /**
     * Returns the index of the object with the given ID code. If an object with the given ID code is not present, returns -1.
     * @param idCode ID code that is searched.
     * @return Index at which the kodutöö_1.Person object with the given ID code can be found, or -1 if no such ID code is present.
     */
    public int indexOf(int idCode) {
        if (this.arrayPersons.length != 0) {
            for (int i = 0; i < this.arrayPersons.length; i++) {
                if (this.arrayPersons[i].getIdCode() == idCode) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Attempts to add the person to the collection, but only if no person with the same ID code is already present.<br>
     * If an element is added, it is inserted to the correct position according to their ID code. Also, the index of all subsequent elements is then increased.<br>
     * If a kodutöö_1.Person object with the same ID code is already present, does nothing.
     * @param person kodutöö_1.Person object to be added.
     * @return true if person was added to the collection, false otherwise.
     */
    public boolean add(Person person) {
        if (indexOf(person.getIdCode()) != -1) {
            return false;
        }
        int oldArrayLen = this.arrayPersons.length; Person[] newArray = new Person[oldArrayLen+1];
        int oldArrayOffset = 0;

        for (int i = 0; i < oldArrayLen+1; i++) {
            if (oldArrayOffset == 0 && (oldArrayLen == 0 || i == oldArrayLen)) {
                newArray[i] = person;
            }
            else if (oldArrayOffset == 0 && person.getIdCode() < this.arrayPersons[i].getIdCode()) {
                newArray[i] = person;
                oldArrayOffset = 1;
            }
            else {
                newArray[i] = this.arrayPersons[i - oldArrayOffset];
            }
        }
        this.arrayPersons = newArray;
        return true;
    }

    /**
     * Attempts to remove the person with the given ID code from the collection. Does nothing if no kodutöö_1.Person object with the given ID code is present.<br>
     * In the case of a successful removal of an object, decreases the index of all subsequent elements.
     * @param idCode ID code that is searched.
     * @return true if the person with the given ID code was removed, false otherwise.
     */
    public boolean removeElement(int idCode) {
        int indexOfRemovableElement = indexOf(idCode);
        if (this.arrayPersons.length != 0 && indexOfRemovableElement != -1) {
            Person[] newArray = new Person[this.arrayPersons.length - 1];
            System.arraycopy(this.arrayPersons, 0, newArray, 0, indexOfRemovableElement);
            System.arraycopy(this.arrayPersons, indexOfRemovableElement+1, newArray, indexOfRemovableElement, this.arrayPersons.length - indexOfRemovableElement - 1);
            this.arrayPersons = newArray;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Calculates and returns the size of the collection.
     * @return Number of elements in the collection.
     */
    public int size() {
        return arrayPersons.length;
    }
}