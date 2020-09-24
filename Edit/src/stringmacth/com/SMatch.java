package stringmacth.com;


public class SMatch //implements ISMatch
{

    private char [] _first ;

    private char [] _second ;



    /*构造函数

     * @param first 原文文本

     * @param second 抄袭文本

     */

    public SMatch(char [] first, char [] second) {

        this._first=first;

        this._second =second;

    }



    /*构造函数

     * @param origin 原始文本

     * @param dest 目标文本

     */

    public SMatch(java.lang.String origin,java.lang.String dest) {
        this._first=origin.toCharArray();
        this._second=dest.toCharArray();
    }



    /* Match 实现方法，距离编辑法

     * @return 返回编辑距离归一化结果

     */

    public double Match() throws TextException {
        int originLength= _first.length,desLength= _second.length;
        if (originLength==0 || desLength==0){
            throw new TextException("Text can't be empty");
        }
        int [][] dis = new int[2][desLength+1];
        for (int i=0;i<2;++i){
            for (int j=0;j<=desLength;++j){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }

        // 初始化都为添加

        dis[0][0]=0;
        for (int i=1;i<2;++i){
            dis[i][0]=dis[i-1][0]+1;
        }
        for (int i=1;i<desLength;++i){
            dis[0][i]=dis[0][i-1]+1;
        }
        /*动态规划*/
        for (int i=0;i<originLength;++i) {
            for (int j = 0; j < desLength; ++j) {
                if (_first[i] == _second[j]) {
                    // 匹配则直接赋值，距离不变
                    dis[(i+1)%2][j + 1] = dis[i%2][j];
                } else {
                    // 不匹配时假设三种情况，增删改
                    dis[(i + 1)%2][j + 1] = Math.min(Math.min(dis[(i + 1)%2][j], dis[i%2][j + 1]), dis[i%2][j]) + 1;
                }
            }
        }
        return (double)(desLength-dis[originLength%2][desLength])/desLength; //归一化
    }

  
}