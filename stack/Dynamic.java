package stack;

public class Dynamic extends first {

	public Dynamic() throws Exception {
		this(default_capacity);
		// TODO Auto-generated constructor stub
	}

	public Dynamic(int capacity) throws Exception {
		// TODO Auto-generated constructor stub
		super(capacity);

	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] arr = new int[2 * this.data.length];
			for (int i = 0; i < this.size(); i++) {
            arr[i] = this.data[i];
			}
			this.data = arr;
		}
		super.push(item);
	}

}
