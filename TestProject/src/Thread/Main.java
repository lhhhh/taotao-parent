package Thread;

class Thread1 extends Thread{
//	private String name;
//    public Thread1(String name) {
//       this.name=name;
//    }
//	public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(name + "运行  :  " + i);
//            try {
//                sleep((int) Math.random() * 10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//       
//	}
	
	private int count=5;
	private String name;
    public Thread1(String name) {
       this.name=name;
    }
	public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  count= " + count--);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
	}
}

class Thread2 implements Runnable{
	private String name;

	public Thread2(String name) {
		this.name=name;
	}

	@Override
	public void run() {
	  for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
            	Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
//	private int count=15;
//	@Override
//	public void run() {
//		  for (int i = 0; i < 5; i++) {
//			  System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
//	            try {
//	            	Thread.sleep((int) Math.random() * 10);
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	        }
//		
//	}
}

public class Main {
	public static void main(String[] args) {
		//继承Thread
//		Thread1 mTh1=new Thread1("A");
//		Thread1 mTh2=new Thread1("B");
//		mTh1.start();
//		mTh2.start();
		
		//实现Runnable
		new Thread(new Thread2("C")).start();
		new Thread(new Thread2("D")).start();
		
//		Thread2 my = new Thread2();
//        new Thread(my, "C").start();//同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常   
//        new Thread(my, "D").start();
//        new Thread(my, "E").start();
	}
}
