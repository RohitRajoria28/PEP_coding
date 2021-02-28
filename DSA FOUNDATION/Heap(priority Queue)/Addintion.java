public PriorityQueue() {
    data = new ArrayList<>();
  }

  public void add(int val) {
     data.add(val);
     upheapify(data.size()-1);
  }
  public void swap(int i,int j){
      int ith=data.get(i);
      int j=data.get(j);
      data.add(i,jth);
      data.get(ith);
  }
  public void upheapify(int idx){
      if(idx==0){
          return ;
      }
      int parentIdx=(idx-1)/2;
      if(data.get(perentIdx)>data.get(idx)){
          swap(parentIdx,idx);
          upheapify(parentIdx);
      }
  }
