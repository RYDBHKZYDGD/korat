package korat.exploration;

/**
 * Created by tianxiao on 6/2/14.
 */
public class GraphExplorationTest extends BaseExplorationTest {
    public void testGraph() throws Exception {
        String cmdLine = "-c korat.examples.graph.Graph -a 3";
        doTestForAllConfigs(cmdLine, 250, -1);
    }
}
