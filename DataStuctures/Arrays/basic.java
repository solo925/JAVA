// o(1) acces but fixed size

public class basic{
  
    public static void main(String[] args){
        int [] numbers = {1,2,3,4,5,6,7 };
        System.out.println(numbers[0]);

        int [][] matrix = {{1,2,3,4,5,6,7}};
        System.out.println(matrix[0][0]);

        for(int i:numbers){
            System.out.println(i);
        }
        for(int [] i2:matrix){
            System.out.println("This is i2" + i2);
        }


    }
}
