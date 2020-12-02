import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BarTest {

	@Test
	//testing the Name getter for a valid name
	void testGetName() {
		Bar test2 = new Bar ("George", 5, "names");
		assertEquals(test2.getName(),"George");
	}


	@Test
	void testGetValue() {
		Bar test3 = new Bar ("George", 34523, "names");
		assertEquals(test3.getValue(),34523);

	}
	//
	@Test

	//testing category method if Bar was constructed with a valid category
	void testGetCategory() {
		Bar test4 = new Bar ("Vienna", 90459348, "cities");
		assertEquals(test4.getCategory(), "cities");
	}

	@Test

	//testing the comparison function when the first (this) is larger than the second (that)
	void testCompareTo1() {
		Bar test5 = new Bar ("The Godfather", 9023409, "movies");
		Bar test6 = new Bar ("Hercules", 3847539, "movies");

		assertEquals(test5.compareTo(test6),1);
	}


	@Test

	//testing the comparison function when the first (this) is smaller than the second (that)
	void testCompareTo2() {
		Bar test7 = new Bar ("Popeye", 40952, "movies");
		Bar test8 = new Bar ("16 Candles", 60439, "movies");

		assertEquals(test7.compareTo(test8),-1);
	}



	@Test

	//testing the comparison function when the first (this) is equal than the second (that)
	void testCompareTo3() {
		Bar test9 = new Bar ("Mark", 56565, "baby");
		Bar test10 = new Bar ("Sally", 56565, "baby");

		assertEquals(test9.compareTo(test10),0);
	}


	@Test
	//testing compare function if Bar that has a negative value, checking that a NullPointerException is thrown
	void testCompareTo4() {

		Bar test11 = new Bar ("Chris", -456, "baby");
		Bar test12 = new Bar ("Sally", 56565, "baby");
		assertThrows(NullPointerException.class, () -> test12.compareTo(test11), "invalid pointer data throw");


	}


	@Test
	//testing compare function if Bar that has a null name, checking that a NullPointerException is thrown
	void testCompareTo5() {

		Bar test11 = new Bar (null, 5456, "baby");
		Bar test12 = new Bar ("Sally", 56565, "baby");
		assertThrows(NullPointerException.class, () -> test12.compareTo(test11), "invalid pointer data throw");


	}



	@Test
	//testing compare function if Bar that has a null category, checking that a NullPointerException is thrown
	void testCompareTo6() {

		Bar test11 = new Bar ("Chris", 54456, null);
		Bar test12 = new Bar ("Sally", 56565, "baby");
		assertThrows(NullPointerException.class, () -> test12.compareTo(test11), "invalid pointer data throw");


	}

}


//	@Test
//	//testing compare function if Bar that has a null name
//		void testCompareTo5() {
//
//			Bar test11 = new Bar ("", 456, "baby");
//			Bar test12 = new Bar ("Sally", 56565, "baby");
//			assertThrows(NullPointerException.class, () -> test12.compareTo(test11), "invalid pointer data throw");
//
//

