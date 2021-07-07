package jo.secondstep;

public class arrayList implements List {
	   private static final int Defaul_Size=15;
	   private int []a=new int [Defaul_Size];
	   private int size=Defaul_Size;
	   private int len=0;
	   
	   void Copy() {
			int []b=new int [size+ size/2];
			
			for(int i=0;i<len;i++) {
				b[i]=a[i];
			}
			
			a=b;
		}
		
		
		public void add(int value) {
			if(len+1 > size ) {
				Copy();
			}
			
			a[len]=value;
			len++;
		}

		
		public void add(int value, int position) {
			if(position < 0 || position >= len) {
				System.out.println("Invalid Index");
			}
			
			else {
				if(len+1 > size ) {
					Copy();
				}
				
				for(int i=len;i>position;i--) {
					a[i]=a[i-1];
				}
				
				a[position]=value;
				len++;
			}
			
		}

	@Override
	public int remove(int position) {
		if(position < 0 || position >= len) {
			System.out.println("Invalid Index");
			return -1;
		}
		int val=a[position];
		for(int i=position;i<len;i++) {
			a[i]=a[i+1];
		}
		len--;
		return val;
	}

	@Override
	public int get(int position) {
		if(position < 0 || position >= len) {
			System.out.println("Invalid Index");
			return -1;
		}
		return a[position] ;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		len = 0;
	}

	@Override
	public void set(int value, int position) {
		a[position] = value;
		
	}

	@Override
	public boolean isEmpty() {
		if(len == 0 ) return true;
		return false;
	}
	
	public void Print() {
		for(int i=0;i<len;i++) 
			System.out.print(a[i]+" ");
		System.out.println();
	}
}

/*class Main{
	  public static void main(String[] args) {
		    arrayList obj=new arrayList();
		    obj.add(11);
		    obj.add(12);
		    obj.add(13);
		    obj.add(14);
		    obj.add(15);
		    obj.add(16);
		    
		    obj.add(10,0);
		    obj.add(20,3);
		    obj.add(17);
		    obj.add(18);
		    obj.add(19);
	        obj.Print();
	        System.out.println(obj.remove(5));
		  }
	}*/