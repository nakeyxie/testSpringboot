package com.xiechy.test;



public class SingletonClass {
	
	/*此方式为延迟加载（用到才加载）*/
      private static SingletonClass instance =null;
      static int times=0;
      public static SingletonClass getInstance(){
    	   times++;
    	  if(null==instance){
    		  /*1实现线程并发问题,判断过后让第一个进入的线程睡觉，然后第二个进入，判读也是null,所以也会new一个对象！！*/
    		  
    		  /*2如果判读为null,那就锁住new对象那段*/
    		  synchronized (SingletonClass.class){
    			  if(null==instance){
    				  /*此处就算线程睡觉，其他线程也进不来！！！！因为锁住了！！！*/
    				  if(times==1){
    	    			  try {
    	    				  System.out.println("开始睡觉5秒");
    	    					Thread.sleep(5*1000);
    	    					 System.out.println("睡觉结束");
    	    				} catch (InterruptedException e) {
    	    					// TODO Auto-generated catch block
    	    					e.printStackTrace();
    	    				} 
    	    		  }
    	    		 
    				  
    				  instance = new SingletonClass();
    			  }
    			  
    		  }
    		 
    		 //instance = new SingletonClass();
    	  }
    	   return instance;
      }
        /**
         * synchronized   synchronized
         * synchronized   synchronized
         * synchronized   synchronized
         * synchronized
         * synchronized
         * synchronized
         * synchronized
         */
      
      /*
      public static SingletonClass getInstance(){
   	   times++;
   	  if(null==instance){
   		  /*1实现线程并发问题,判断过后让第一个进入的线程睡觉，然后第二个进入，判读也是null,所以也会new一个对象！！
   		  if(times==1){
   			  try {
   				  System.out.println("开始睡觉5秒");
   					Thread.sleep(5*1000);
   					 System.out.println("睡觉结束");
   				} catch (InterruptedException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				} 
   		  }
   		 
   		 //instance = new SingletonClass();
   	  }
   	   return instance;
     }
      
      
     
     *********/
      private SingletonClass(){
    	 
      }
      
      
    
      
}
