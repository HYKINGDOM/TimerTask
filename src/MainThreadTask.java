import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
public class MainThreadTask {

    private ThreadPoolExecutor threadPoolExecutor = null;

    public void initial() {
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new BasicThreadFactory("BasicThreadFactory"));
    }

    public void execute() {
        for (int index = 0; index < 10; index++) {
            threadPoolExecutor.execute(new BasicThreadTask());
        }
    }

    public void destroy() {
        threadPoolExecutor.shutdown();
    }

    /**
     * @Title: main
     * @Description: TODO
     * @param args
     * @throws
     */
//    public static void main(String[] args) {
//        MainThreadTask mainThreadTask = new MainThreadTask();
//
//        mainThreadTask.initial();
//        mainThreadTask.execute();
//        mainThreadTask.destroy();
//    }

}
