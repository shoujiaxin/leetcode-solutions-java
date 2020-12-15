/*
 * @lc app=leetcode id=1114 lang=java
 *
 * [1114] Print in Order
 *
 * https://leetcode.com/problems/print-in-order/description/
 *
 * concurrency
 * Easy (65.46%)
 * Likes:    525
 * Dislikes: 89
 * Total Accepted:    54.4K
 * Total Submissions: 82.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Suppose we have a class:
 *
 *
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 *
 *
 * The same instance of Foo will be passed to three different threads. Thread A
 * will call first(), thread B will call second(), and thread C will call
 * third(). Design a mechanism and modify the program to ensure that second()
 * is executed after first(), and third() is executed after second().
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input
 * [1,2,3] means thread A calls first(), thread B calls second(), and thread C
 * calls third(). "firstsecondthird" is the correct output.
 *
 *
 * Example 2:
 *
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls
 * third(), and thread C calls second(). "firstsecondthird" is the correct
 * output.
 *
 *
 *
 * Note:
 *
 * We do not know how the threads will be scheduled in the operating system,
 * even though the numbers in the input seems to imply the ordering. The input
 * format you see is mainly to ensure our tests' comprehensiveness.
 *
 */

// @lc code=start
class Foo {

  private Lock lock = new ReentrantLock();
  private Condition jobDone;
  private int num = 1;

  public Foo() {
    jobDone = lock.newCondition();
  }

  public void first(Runnable printFirst) throws InterruptedException {
    lock.lock();

    try {
      while (num != 1) {
        jobDone.await();
      }

      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      num = 2;
      jobDone.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public void second(Runnable printSecond) throws InterruptedException {
    lock.lock();

    try {
      while (num != 2) {
        jobDone.await();
      }

      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      num = 3;
      jobDone.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public void third(Runnable printThird) throws InterruptedException {
    lock.lock();

    try {
      while (num != 3) {
        jobDone.await();
      }

      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
      num = 1;
      jobDone.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
// @lc code=end
