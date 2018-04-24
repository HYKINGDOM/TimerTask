import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *      ┌─┐       ┌─┐ + +
 *   ┌──┘ ┴───────┘ ┴──┐++
 *   │                 │
 *   │       ───       │++ + + +
 *   ███████───███████ │+
 *   │                 │+
 *   │       ─┴─       │
 *   │                 │
 *   └───┐         ┌───┘
 *       │         │
 *       │         │   + +
 *       │         │
 *       │         └──────────────┐
 *       │                        │
 *       │                        ├─┐
 *       │                        ┌─┘
 *       │                        │
 *       └─┐  ┐  ┌───────┬──┐  ┌──┘  + + + +
 *         │ ─┤ ─┤       │ ─┤ ─┤
 *         └──┴──┘       └──┴──┘  + + + +
 *                神兽保佑
 *               代码无BUG!
 */
public class BasicThreadFactory implements ThreadFactory {
    private final ThreadGroup threadGroup;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String threadNamePrefix;

    /**
     * 构造函数
     *
     * @param threadPoolName
     *            线程池名称
     */
    public BasicThreadFactory(String threadPoolName) {
        SecurityManager securityManager = System.getSecurityManager();

        threadGroup = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();

        threadNamePrefix = threadPoolName + "-thread-";
    }

    /**
     * 创建线程
     */
    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(threadGroup, runnable, threadNamePrefix + threadNumber.getAndIncrement(), 0);

        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }

        if (thread.getPriority() != Thread.MAX_PRIORITY) {
            thread.setPriority(Thread.MAX_PRIORITY);
        }

        return thread;
    }
}
