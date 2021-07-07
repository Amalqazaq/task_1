package jo.secondstep;

public class linkedlist implements List {
      private Node head=null;
      private Node tail=null;
      private int len=0;
      
	@Override
	public void add(int value) {
		
		Node n=new Node();
		n.data=value;
		
		if(len == 0) {
			head=tail=n;
		}
		else {
			tail.link=n;
			tail=n;
		}
		len++;

	}

	@Override
	public void add(int value, int position) {
		if(position < 0 || position >= len) {
			System.out.println("Invalid Index");
		}
		
		Node n=new Node();
		n.data=value;
		
		if(position == 0) {
			n.link=head;
			head=n;
		}
		else if(position == len-1 ) {
			add(value);
		}
		else {
			int cont=1;
			Node p=head;
			while(p != null) {
				if(cont == position) {
					n.link=p.link;
					p.link=n;
				}
				p=p.link;
				cont++;
			}
			
			len++;
		}
		
		
	}

	@Override
	public int remove(int position) {
		if(position < 0 || position >= len) {
			System.out.println("Invalid Index");
			return -1;
		}
		int val=-1;
		if(position == 0) {
			val = head.data;
			head=head.link;
		}
		else {
			int cont=1;
			Node p=head.link,q=head;
			while(p != null) {
				if(cont == position) {
					q.link=p.link;
					if(position == len-1) {
						tail=q;
					}
					val=p.data;
				}
				q=q.link;
				p=p.link;
				cont++;
			}
			
			
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
		int cont=0,val=0;
		Node p=head;
		while(p != null) {
			if(cont == position) {
				val= p.data;
			}
			p=p.link;
			cont++;
		}
		return val;
	}

	@Override
	public int size() {
		return len;
	}

	@Override
	public void clear() {
		head=tail=null;
		len=0;
		
	}

	@Override
	public void set(int value, int position) {
		if(position < 0 || position >= len) {
			System.out.println("Invalid Index");
			return ;
		}
		int cont=0;
		Node p=head;
		while(p != null) {
			if(cont == position) {
				 p.data = value;
			}
			p=p.link;
			cont++;
		}
	}

	@Override
	public boolean isEmpty() {
		if(len == 0 ) return true;
		return false;
	}
	
	public void Print() {
		Node p=head;
		
		while(p != null) {
			System.out.print(p.data+" ");
			p=p.link;
		}
		System.out.println();
	}

}

class Main{
	  public static void main(String[] args) {
		  linkedlist obj=new linkedlist();
		    obj.add(11);
		    obj.add(12);
		    obj.add(13);
		    obj.add(14);
		    obj.add(15);
		    obj.add(16);
		    obj.set(20,7);
		    /*obj.Print();
		    obj.add(20);
		    obj.add(10);*/
	        obj.Print();
	       
		  }
	}
