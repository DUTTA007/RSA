/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author TD
 */


import java.math.BigInteger;
import java.util.Random;
 
public class RSA
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int        bitlength;
    private Random     r;
 
    public RSA(int bitlenfromusr)
    {
        r = new Random();
        bitlength = bitlenfromusr;
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }
 
    public RSA(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.n = N;
    }
    
    public void printRSAValues() {
    	System.out.println("Random source value = " + r );
    	System.out.println("Random Prime Number 1 p = " + p);
    	System.out.println("Random Prime Number 2 q = " + q);
    	System.out.println("p x q = N= " + n );
    	System.out.println("(p-1)x(q-1) = phi(n) = " + phi );
    	System.out.println("1 < e < phi(n)  e = " + e );
    	System.out.println("(mod phi(n)) d = " + d); 
    }
 
    //Encrypt message
    public byte[] encrypt(byte[] message)
    {
        //message ^ e mod n
    	return (new BigInteger(message)).modPow(e, n).toByteArray();
    }
 
    //Decrypt message
    public byte[] decrypt(byte[] cipher)
    {
        //cipher ^ d mod n
    	return (new BigInteger(cipher)).modPow(d, n).toByteArray();
    }
}

