package elements.animals;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import elements.treatments.Treatment;
import elements.treatments.TreatmentType;

public class TreatmentTest {
 
	@Test
	public void testIsFinished(){
		System.out.println("--- TreatmentTest.testIsFinished ---");
		Calendar calNow = Calendar.getInstance();
		Calendar calLater = Calendar.getInstance();
		calLater.add(Calendar.DAY_OF_MONTH, 5);
		Calendar calEarlier5 = Calendar.getInstance();
		calEarlier5.add(Calendar.DAY_OF_MONTH, -5);
		Calendar calEarlier10 = Calendar.getInstance();
		calEarlier10.add(Calendar.DAY_OF_MONTH, -10);
		
		Treatment treatment = new Treatment("TreatmentForTest1",
				new Date(calNow.getTime().getTime()),
				new Date(calLater.getTime().getTime()), null);
		Assert.assertFalse(treatment.isFinished());
	
		treatment = new Treatment("TreatmentForTest2",
				new Date(calEarlier10.getTime().getTime()),
				new Date(calEarlier5.getTime().getTime()), null);
		Assert.assertTrue(treatment.isFinished());
	
		treatment = new Treatment("TreatmentForTest3",
				new Date(calEarlier10.getTime().getTime()),
				new Date(calNow.getTime().getTime()), null);
		Assert.assertTrue(treatment.isFinished());
		
		System.out.println("--- Test OK ---\n");
	}
	
	@Test
	public void testConstructor(){
		System.out.println("--- TreatmentTest.testConstructor ---");
		TreatmentType type = new TreatmentType("traitement", 5);
		Calendar calLater = Calendar.getInstance();
		calLater.add(Calendar.DAY_OF_MONTH, 5);
		Treatment treatment = new Treatment("TreatmentForTest1", new Date(Calendar.getInstance().getTime().getTime()), type, null);
		Assert.assertEquals((new Date(calLater.getTime().getTime())).toString(),treatment.getEndDate().toString());

		System.out.println("--- Test OK ---\n");
	}
}
