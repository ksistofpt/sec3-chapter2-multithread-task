import com.codefinity.TaskLockExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskLockExampleTest {

    private TaskLockExample taskLockExample;
    private BlockingQueue<String> executionOrder;

    @BeforeEach
    void setUp() {
        taskLockExample = new TaskLockExample();
        executionOrder = new LinkedBlockingQueue<>();
    }

    @RepeatedTest(3)
    void testMethodExecutionOrder() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            taskLockExample.redLight();
            executionOrder.offer("method1");
        });

        Thread t2 = new Thread(() -> {
            try {
                taskLockExample.yellowLight();
                executionOrder.offer("method2");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                taskLockExample.greenLight();
                executionOrder.offer("method3");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t3.start();
        t2.start();
        t1.start();

        t3.join();
        t2.join();
        t1.join();

        assertEquals("method1", executionOrder.poll());
        assertEquals("method2", executionOrder.poll());
        assertEquals("method3", executionOrder.poll());
    }
}