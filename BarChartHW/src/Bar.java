public class Bar implements Comparable<Bar> {
	private String name;
	private Integer value;
	private String category;
	// Creates a new bar.


	public Bar(String name, int value, String category) {
		try {

			this.name = name;

			this.value = value;

			this.category = category;

			if (name == null) throw new IllegalArgumentException("name cannot be null");
			if (category == null) throw new IllegalArgumentException("category cannot be null");
			if (value < 0) throw new IllegalArgumentException("value cannot be negative");


		}
		catch (Exception excpt) {
			System.out.println(excpt.getMessage());
		}
	}

	// Returns the name of this bar.
	public String getName() {
		return this.name;
	}

	// Returns the value of this bar.
	public Integer getValue() {
		return this.value;
	}

	// Returns the category of this bar.
	public String getCategory() {
		return this.category;
	}

	// Compare two bars by value.
	@Override
	public int compareTo(Bar that) throws NullPointerException{
		int comparisonVal=0;

		
			comparisonVal = this.value.compareTo(that.value);

			if(that.value < 0  || that.name == null || that.category ==null) {
				throw new NullPointerException ("Invalid pointer data");
			}
		
		return comparisonVal;



	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (this.name + this.value + this.category);
	}
}
