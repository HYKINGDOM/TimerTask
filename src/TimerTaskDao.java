import dao.TimerDao;

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
 *
 * @author hy
 * @date
 *
 */
public class TimerTaskDao {

    private TimerDao timerDao = null;

    public TimerTaskDao(){
        System.out.println("==========进入调试方法==========");
//        new DemoTask();
        timerDao.deletGetHourWorking();
        System.out.println("==========调试方法==========");
    }

    public TimerDao getTimerDao() {
        return timerDao;
    }

    public void setTimerDao(TimerDao timerDao) {
        this.timerDao = timerDao;
    }
}
