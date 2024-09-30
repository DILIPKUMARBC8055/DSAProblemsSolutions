class MyCircularDeque {
    ArrayList<Integer> data;
    int maxSize;
    public MyCircularDeque(int k) {
        maxSize=k;
        data=new ArrayList<>();
    }
    
    public boolean insertFront(int value) {
        if(data.size()>=maxSize)
        {
            return false;
        }
        data.add(0,value);
        return true;
    }
    
    public boolean insertLast(int value) {
         if(data.size()>=maxSize)
        {
            return false;
        }
        data.add(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(data.size()==0)
        {
            return false;
        }
        data.remove(0);
        return true;
    }
    
    public boolean deleteLast() {
         if(data.size()==0)
        {
            return false;
        }
        data.remove(data.size()-1);
        return true;
    }
    
    public int getFront() {
        if(data.size()==0)
        {
            return -1;
        }
        return data.get(0);
    }
    
    public int getRear() {
        if(data.size()==0)
        {
            return -1;
        }
        return data.get(data.size()-1);
    }
    
    public boolean isEmpty() {
        return data.size()==0;
    }
    
    public boolean isFull() {
        return data.size()==maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */