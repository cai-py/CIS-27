package Notes;

public class temp{


    public static void main(String[] args) {
int sum = 0;
        for(int i =0; i < args.length; i++){
            sum += Integer.parseInt(args[i]);
            System.out.println(args[i]);
        }
        System.out.println(sum);
    }
}


/*
you can pass arguments to your class from your IDE
look for "modify run configuration"



 */