
import java.math.BigInteger;
import java.util.Scanner;


/**
 *
 * @author Quang Hung
 */
public class JSP0084 {
    private BigInteger n1;
    private BigInteger n2;
    private static Scanner sc = new Scanner(System.in);
    
    public JSP0084(){
        
    }

    public JSP0084(BigInteger n1, BigInteger n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public BigInteger getN1() {
        return n1;
    }

    public void setN1(BigInteger n1) {
        this.n1 = n1;
    }

    public BigInteger getN2() {
        return n2;
    }

    public void setN2(BigInteger n2) {
        this.n2 = n2;
    }
    
    public void inputNumb(){
        System.out.println("Enter number 1: ");
        n1 = sc.nextBigInteger();
        System.out.println("Enter nubmer 2:");
        n2 = sc.nextBigInteger();
    }
    
    public void diplayMulti(){
        System.out.println("Result of multiply two digit number:" +n1.multiply(n2));
    }

}
