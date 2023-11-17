package com.mycompany.doaaarray;

public class myArrayList<D> {

    // init the aarayList by array 
    D arr[];
    // init size of arraylist (number of element in arraylist)
    private int size = 5;

    //constructer
    public myArrayList() {
        arr = (D[]) new Object[5];
        size = 0;
    }

    // isEmpty method it return true if arraylist has element else return false
    public boolean isFull() {
        return size >= 0 && size < arr.length;
    }

    //add method 
    public void add(D value) {
        // to check if arry is full
        if (!isFull()) {
            //extend the array
            reSize();
        }
        //add the elements
        arr[size++] = value;
    }

    // add method with 2 attrbutes
    public void add(int index, D value) {
        // we will check if index is correct and found
        if (index >= 0 && index <= size) {
            // if is correct 
            // to check if arry is full
            if (!(size >= 0 && size < arr.length)) {
                //extend the array
                D reArr[] = (D[]) new Object[arr.length * 2];
                for (int i = 0; i < arr.length; i++) {
                    reArr[i] = arr[i];
                }
                arr = reArr;
            }
            // shifting process to empty the required index 
            shiftRight(index);
            // add the required value 
            arr[index] = value;

        } else {
            // if the index is not correct there an error , give this message
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    // to remove an element by index 
    public D remove(int index) {
        // this value will return when it called
        D old;
        if (check(index)) {
            // if is correct 
            // let return value equal value of required index 
            old = arr[index];
            // delete an element
            shiftLeft(index);
        } else {
            // if the index is not correct there an error , give this message
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return old;
    }

    // return first index where given value 
    public int indexOf(D value) {
        // we will check evrey element to find the first index
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        // if is not found 
        return -1;
    }

    // replace value at given index with given value 
    public D set(int index, D value) {
        D old;
        // to check if index i correct 
        if (check(index)) {
            // replace value at given index
            old = arr[index];
            arr[index] = value;

        } else {
            // if the index is not correct there an error , give this message
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return old;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += arr[i];
            if (i != size - 1) {
                str += ',';
            }
        }
        str += "]";
        return str;
    }

    // revers the arrayList
    public void revers() {
        // to fix size with after changes 
        int size = this.size();
        // we will stop in mid of arraylist 
        for (int i = 0; i < size / 2; i++) {
            // Swap elements at position i and size - i - 1
            D temp = this.get(i);
            this.set(i, this.get(size - i - 1));
            this.set(size - i - 1, temp);
        }
    }

    // returns the number of missing elements required to transform the arraylist into a palindrome
    public int palindrome() {
        int count = 0;  // Counter for differences
        int left = 0;  // Left index of the array
        int right = size - 1;  // Right index of the array

        while (left < right) {  // Iterate until the left index is greater than or equal to the right index
            if (arr[left] == arr[right]) {  // If the elements at the current indices match
                left++;  // Move the left index to the right
                right--;  // Move the right index to the left
            } else {  // If elements at current indices don't match
                if (arr[left] == arr[right - 1]) {  // Check if skipping one element on the right makes them match
                    count++;  // Increment the counter for differences
                    left++;  // Move the left index to the right
                    right = right - 2;  // Move the right index two steps to the left
                } else {  // If skipping one element on the right doesn't make them match
                    count++;  // Increment the counter for differences
                    left++;  // Move the left index to the right
                }
            }
        }
        return count;  // Return the total count of differences
    }

    // adds all elements from the given list to array 
    public void addAll(myArrayList<D> list) {
        // we will tracking elements in list to add in arr 
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }

    // get method that return a value of index 
    public D get(int index) {

        if (check(index)) {
            return arr[index];
        } else {
            // if the index is not correct there an error , give this message
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    // to return size of array
    public int size() {
        return size;
    }

    //shifting process to remove the required index 
    public void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];

        }
        size--;
    }

    //shifting process to empty the required index 
    public void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        size++;
    }

    // to check if index is correct and found {
    public boolean check(int index) {
        // there we use the size not length because not allowd to put an element between another with empty value
        return index >= 0 && index <= size;
    }

    // to extend size of arraylist 
    public void reSize() {
        D reArr[] = (D[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            reArr[i] = arr[i];
        }
        arr = reArr;

    }

}
