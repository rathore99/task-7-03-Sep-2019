package com.ssi.task8;
/*defining a thread by implementing runnable interface*/
/*Thread class implements runnable interface
runnbale interface present in java.lang package and it contains only one method run()
*/
class myRunnable implements Runnable
{
  public void run()
  {
    for(int i=0;i<5;i++)
    System.out.println("child thread");
    System.out.println(Thread.currentThread().getName());
  }
  
}
class Test
{
 public static void main(String args[])
 {
   myRunnable r = new myRunnable();
   Thread t = new Thread(r);
   t.start();
   for(int i=0;i<5;i++)
    System.out.println("main thread");
    Thread.currentThread().setName("rahul rathore ");
    System.out.println(Thread.currentThread().getName());
 }
} 
/*
Thread t1 = new Thread()
Thread t2 = new Thread(r)
case 1 : t1.start() a new thread will created ,responsible for execution of thread class run() which has empty implementation
case2: t1.run() no new thread will be created and thrad class run method will be executed jst lie a normal method call
case 3:
t2.start() a new thread willl be created which will responsible for execution of myrunnable run() method
case4:: t2.run() a new thread will not be created and myrunnbale run method will be executed jst like a normal methid call
case 5: r.start will get compile time error saying myrunnbale class not have start capability
case 6 r.run() no new thread will be created and myrunnble run() will be executed like normal method call
*/
/* public final String getName()
public finl void setName(String name)*/

/* ******Thread class costructors*******/
/*1. Thread t =
*/

