package unitTests;

import primitives.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;

public class VectorTests {
	
	@Test
	public void testAdd(){
		Vector v = new Vector(2.5, 3.6, 1.0);
		Vector newV = v.add(new Vector(1.0, 1.0, 1.0));
		
		assertEquals("", 1, newV.compareTo(new Vector(3.5, 4.6, 2.0)));
//		assertEquals("X coordinate failed under positive addition", 3.5, newV.getHead().getX().getCoordinate(), 1e-10);
//		assertEquals("Y coordinate failed under positive addition", 4.6, newV.getHead().getY().getCoordinate(), 1e-10);
//		assertEquals("Z coordinate failed under positive addition", 2.0, newV.getHead().getZ().getCoordinate(), 1e-10);
		
		
		newV = v.add(new Vector(-1.0, -1.0, -1.0));
		
		assertEquals("", 1, newV.compareTo(new Vector(1.5, 2.6, 0.0)));
//		assertEquals("X coordinate failed under negative addition", 1.5, newV.getHead().getX().getCoordinate(), 1e-10);
//		assertEquals("Y coordinate failed under negative addition", 2.6, newV.getHead().getY().getCoordinate(), 1e-10);
//		assertEquals("Z coordinate failed under negative addition", 0.0, newV.getHead().getZ().getCoordinate(), 1e-10);

		newV = v.add(new Vector(0.0, 0.0, 0.0));
		
		assertEquals("", 1, newV.compareTo(new Vector(2.5, 3.6, 1.0)));
//		assertEquals("X coordinate failed under zero addition", 2.5, newV.getHead().getX().getCoordinate(), 1e-10);
//		assertEquals("Y coordinate failed under zero addition", 3.6, newV.getHead().getY().getCoordinate(), 1e-10);
//		assertEquals("Z coordinate failed under zero addition", 1.0, newV.getHead().getZ().getCoordinate(), 1e-10);
		
	}

	@Test
	public void testSubtract(){
		Vector v = new Vector(2.5, 3.6, 1.0);
		Vector newV = v.subtract(new Vector(1.0, 1.0, 1.0));
		
		assertEquals("X coordinate failed under positive subtraction", 1.5, newV.getHead().getX().getCoordinate(), 1e-10);
		assertEquals("Y coordinate failed under positive subtraction", 2.6, newV.getHead().getY().getCoordinate(), 1e-10);
		assertEquals("Z coordinate failed under positive subtraction", 0.0, newV.getHead().getZ().getCoordinate(), 1e-10);
		
		
		newV = v.subtract(new Vector(-1.0, -1.0, -1.0));
		
		assertEquals("X coordinate failed under negative subtraction", 3.5, newV.getHead().getX().getCoordinate(), 1e-10);
		assertEquals("Y coordinate failed under negative subtraction", 4.6, newV.getHead().getY().getCoordinate(), 1e-10);
		assertEquals("Z coordinate failed under negative subtraction", 2.0, newV.getHead().getZ().getCoordinate(), 1e-10);
		
		newV = v.subtract(new Vector(0.0, 0.0, 0.0));
		
		assertEquals("X coordinate failed under zero subtraction", 2.5, newV.getHead().getX().getCoordinate(), 1e-10);
		assertEquals("Y coordinate failed under zero subtraction", 3.6, newV.getHead().getY().getCoordinate(), 1e-10);
		assertEquals("Z coordinate failed under zero subtraction", 1.0, newV.getHead().getZ().getCoordinate(), 1e-10);
		
	}
	
	@Test
	public void testScalling(){
		Vector v = new Vector(7.7, 0.0, 0.032);
	}
	
	@Test
	public void testDotProduct(){
		
	}
	
	@Test
	public void testLength(){
		Vector v = new Vector(0.0, 0.0, 0.0);
		assertEquals("Zero vector length failed", 0.0, v.length(), 1e-10);
		
		v = new Vector(1.0, 0.0, -1.0);
		assertFalse("Assigned zero length to non-zero vector", v.length() == 0.0);
		
		Random r = new Random();
		double randomX = (r.nextDouble()*200)-100;
		double randomY = (r.nextDouble()*200)-100;
		double randomZ = (r.nextDouble()*200)-100;
		
		v = new Vector(randomX, randomY, randomZ);
		assertEquals("Length function failed on random vector", Math.sqrt(randomX*randomX + randomY*randomY + randomZ*randomZ), v.length(), 1e-10);
		
	}
	
	@Test
	public void testNormalize(){
		Vector v = new Vector(7.7, 0.0, 0.032);
		Vector newV = v.normalize();
		
		assertEquals("Normalize failed", 1.0, newV.length(), 1e-10);
		
		v = new Vector(0.0, 0.0, 0.0);
		
		try{
			v.normalize();
			fail("If it got to here then it didn't throw an error, which it should have.");
		}catch(IllegalArgumentException e){
			assertEquals("Normalize threw the wrong error", e.getMessage(), "Cannot normalize the zero vector. Will result in divide by zero");
		}
		
		
	}
	
	@Test
	public void testCrossProduct(){
		
	}
}
