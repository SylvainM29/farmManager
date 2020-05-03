package elements.animals;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;

import elements.animals.Animal;
import elements.animals.AnimalType;
import elements.treatments.Treatment;
import elements.treatments.TreatmentType;

import org.junit.Assert;

public class AnimalTest {

	@Test
	public void testGetCurrentTreatment(){
		System.out.println("--- AnimalTest.testGetCurrentTreatment ---");
		Animal animal = new Animal(1, "Genious", null, null, AnimalType.COW);
		TreatmentType treatmentType = new TreatmentType("traitement 1", 2);
		animal.addTreatment(new Treatment("traitement 1", new Date(Calendar.getInstance().getTime().getTime()), treatmentType, animal));
		Assert.assertNotNull(animal.getCurrentTreatment());
		
		Calendar calEarlier5 = Calendar.getInstance();
		calEarlier5.add(Calendar.DAY_OF_MONTH, -5);
		animal.addTreatment(new Treatment("traitement 2", new Date(calEarlier5.getTime().getTime()), treatmentType, animal));
		Assert.assertNull(animal.getCurrentTreatment());

		System.out.println("--- Test OK ---\n");
	}
}
