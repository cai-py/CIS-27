package interfaceexamples;

/**
 * The examples shows the use of default, static, and private methods.
 * 
 * @author P. Thananjeyan
 */
interface DefaultInterface {
                       
    // All variables public static and final
    int x = 10;
    
    // All methods are public
    void m1();                  
    
    // Okay to have default methods. Classes that implements the interface
    // can accept the default method or implement its version of the method.
    default void m2(){          //OK to hpublic
        //Code here
    }
    
    // Okay to have static method.  Classes that implement the interface
    // cannot implement method.  These methods are part of the interface.
    // Classes have to use the syntax DefaultInterface.m3() to call this method.
    static void m3(){           //public
        
    }
    
    // Okay after Java 9.  These are private helper method that belong to the
    // Interface. Must compile and run using --source 9 option.
    private void m4(){
        
    }
    
}


/**
 * Interface implements a default version of the m1 method.
 * @author pthananjeyan
 */
interface ModifiedInterface extends DefaultInterface {
    
    @Override
    public default void m1(){
        
    }
}


interface AnotherSubInterface extends DefaultInterface {
    
    public default void m5(){
        throw new UnsupportedOperationException();
    }
}


class E implements DefaultInterface {
    
    public void m1(){
        // Implement m1
    }
    
    
    public void m2(){
        // OK to implement m2
        // Not needed
    }
}


class F implements ModifiedInterface, AnotherSubInterface {

    //No methods are neede here
    //Can use default m1, m2, and m5 
}
