package hasmapimplement;

public class hashmap<K , V> {

	class HTpair{
		K key;
		V value;
	  HTpair(K key , V value){
		this.key = key;
		this.value = value;
	}	
		public boolean equals(Object other) {
			HTpair pair = (HTpair) other;
			return this.key.equals(pair.key);
		}
		
		public String toString(){
			return "{"+this.key+"-"+this.value+"}";
		}
	}
	
	public static final int DEFAULT_CAPACITY = 10; 
		
	private LinkedList<HTpair>[] bucketlist; 
    private int size ;
    
    public hashmap() {
    	this(DEFAULT_CAPACITY);
    }
    
    public hashmap(int capacity) {
    	this.bucketlist = (LinkedList<HTpair>[]) new LinkedList[capacity];
        this.size = 0;
    }
    public void put(K key , V value) throws Exception {
    	int bi  = hashFunction(key);
    	LinkedList<HTpair> bucket = this.bucketlist[bi];
    	HTpair pta = new HTpair(key,value);
    	if(bucket == null) {
    		bucket = new LinkedList<>();
    		bucket.addLast(pta);
    		this.bucketlist[bi] = bucket;
    	    this.size++;
    	}else {
    		int findAt = bucket.find(pta);
    		if(findAt ==-1) {
    			bucket.addLast(pta);
    		}else {
    			HTpair pair = bucket.getAt(findAt);
    			pair.value = value;
    		}
    	}
        double lambda = (this.size*1.0)/this.bucketlist.length;
        if(lambda > 0.75) {
        	this.rehash();
        }
    }
    public int hashFunction(K key) {
    	int l = key.hashCode();
    	l = Math.abs(l);
    	int bi  = l % this.bucketlist.length;
    	return bi;
    }
    
    public void display() throws Exception{
    	for(LinkedList<HTpair> bucket : this.bucketlist) {
    		if(bucket != null && !bucket.isEmpty()   ) {
    			bucket.display();
    		}else {
    			System.out.println("NULL");
    		}
    	}
    }
    
    public V get(K key) throws Exception{
      int bi = hashFunction(key);
      LinkedList<HTpair> bucket = this.bucketlist[bi];
      HTpair ptf = new HTpair(key,null);
      if(bucket == null) {
    	  return null;
      }else {
    	  int idx = bucket.find(ptf);
    	  if(idx == -1) {
    		  return null;
    	  }else {
    		 HTpair pair = bucket.getAt(idx); 
    		 return pair.value;
    	  }
      }
    }
    
    public V REMOVE(K key) throws Exception{
        int bi = hashFunction(key);
        LinkedList<HTpair> bucket = this.bucketlist[bi];
        HTpair ptf = new HTpair(key,null);
        if(bucket == null) {
      	  return null;
        }else {
      	  int idx = bucket.find(ptf);
      	  if(idx == -1) {
      		  return null;
      	  }else {
      		 HTpair pair = bucket.getAt(idx);
      		 bucket.removeAt(idx);
      		 this.size--;
      		 return pair.value;
      	  }
        }
      }
    

    // oba = old bucketlist array
    private void rehash() throws Exception{
    	LinkedList<HTpair>[] oba = this.bucketlist;
    	this.bucketlist = (LinkedList<HTpair>[]) new LinkedList[2*oba.length];
    	this.size = 0;
    	for(LinkedList<HTpair> ob : oba) {
    		while(ob != null && !ob.isEmpty()) {
    			HTpair pair = ob.removeFirst();
    			this.put(pair.key, pair.value);
    		}
    	}
    }
}
