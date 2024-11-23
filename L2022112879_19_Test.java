import org.junit.Test;
import static org.junit.Assert.*;

/*
针对第19题编写的测试类
测试类设计：
测试目标
1.验证游戏规则的正确性
    规则一：活细胞少于2个活邻居死亡
    规则二：活细胞有2或3个或邻居存活
    规则三：活细胞多于3个活邻居死亡
    规则四：死细胞正好有3个活邻居复活
2.验证程序对输入的棋盘状态的边界和异常处理
    空棋盘
    单行单列棋盘
    非对称棋盘
3.验证复杂棋盘场景下整体演化的正确性

测试用例设计原则
1.等价类划分：
    活细胞和死细胞的不同邻居组合
    多种输入规模：小型棋盘2x2，中型棋盘4x4，大型棋盘
2.边界值分析：
    极小棋盘：1x1，2x1
    极大活邻居棋盘：8个活邻居
    无活邻居或全部死细胞
3.特殊情况：
    全活或全死棋盘
    死细胞复活形成新的模式
 */
public class L2022112879_19_Test {
    //测试规则一：活细胞少于2个活邻居死亡
    @Test
    public void testRule1_Underpopulation(){
        Solution19 solution19 = new Solution19();
        int[][] board = {{1,0}, {0,0}};
        int[][] expected = {{0,0}, {0,0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected,board);
    }

    //测试规则二：活细胞有2或3个活邻居存货
    @Test
    public void testRule2_Surival(){
        Solution19 solution19 = new Solution19();
        int[][] board = {
                {1,1,0},
                {1,1,0},
                {0,0,0}};
        int[][] expected = {
                {1,1,0},
                {1,1,0},
                {0,0,0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected,board);
    }
    //测试规则三：活细胞多于3个活邻居死亡
    @Test
    public void testRule3_Overpopulation(){
        Solution19 solution19 = new Solution19();
        int[][]board = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 1, 0}};
        int[][] expected = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected, board);
    }
    //测试规则四：死细胞正好有三个活邻居复活
    @Test
    public void testRule4_Reproduction() {
        Solution19 solution19 = new Solution19();
        int[][] board = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 0, 0}};
        int[][] expected = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected, board);
    }
    //测试空棋盘
    @Test
    public void testEmptyBoard(){
        Solution19 solution19 = new Solution19();
        int[][] board = {};
        int[][] expected = {};
        solution19.gameOfLife(board);
        assertArrayEquals(expected, board);
    }
    //测试单行棋盘
    @Test
    public void testSingleRowBoard(){
        Solution19 solution19 = new Solution19();
        int[][] board = {{1,0,1,0,1}};
        int[][] expected = {{0,0,0,0,0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected, board);
    }
    //测试单列棋盘
    @Test
    public void testSingleColBoard(){
        Solution19 solution19 = new Solution19();
        int[][] board = {{1},{0}, {1}, {0}, {1}};
        int[][] expected = {{0},{0},{0},{0},{0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected,board);
    }
    //测试非对称棋盘
    @Test
    public void testAsymmetricBoard(){
        Solution19 solution19 = new Solution19();
        int[][] board = {{1,1,0},{1,0,0}};
        int[][] expected = {{1,1,0},{1,1,0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected,board);
    }
    //测试全活棋盘
    @Test
    public void testAllAliveBoard(){
        Solution19 solution19 = new Solution19();
        int[][]board = {{1,1},{1,1}};
        int[][] expected = {{1,1},{1,1}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected,board);
    }
    //测试全死棋盘
    @Test
    public void testAllDeadBoard(){
        Solution19 solution19 = new Solution19();
        int[][]board = {{0,0},{0,0}};
        int[][] expected = {{0,0},{0,0}};
        solution19.gameOfLife(board);
        assertArrayEquals(expected,board);
    }
}
