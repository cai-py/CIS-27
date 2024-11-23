/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author P. Thananjeyan
 */
public class MyArray<E> {
    
    private E[]  arr;
    private int count;
    
    public MyArray (int n){
       arr = (E[]) new Object[n];
       count = 0;
    }
    
    public MyArray (){
       this(10);
    }
    
    private void resize(int n){
        E[] temp = (E[]) new Object[n];
        for (int i = 0; i < count; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
    
    public int size(){
        return count;
    }
    
    public void add(int index, E obj){
        if (count == arr.length)
            resize(2 * arr.length);
        arr[count] = obj;
        count++;
    }

    public void remove(E obj){
        for (int i = 0; i < count; i++){
            if (arr[i].equals(obj)){
                for (int j = i; j < - 1 ; j++) {
                    arr[j] = arr[j + 1];
                }
                count--;
                arr[count] = null;
            }
        }
        if (count == arr.length / 4)
            resize(arr.length / 2);
    }
}
	
    
    
    

