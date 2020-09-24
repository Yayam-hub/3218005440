package stringmacth.com;
import java.util.regex.Pattern;

public class SMatch implements ISMatch
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
        int firstLength= _first.length,secondLength= _second.length;
        if (firstLength==0 || secondLength==0){
            throw new TextException("Text can't be empty");
        }
        int [][] dis = new int[2][secondLength+1];
        for (int i=0;i<2;++i){
            for (int j=0;j<=secondLength;++j){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }

        // 初始化都为添加

        dis[0][0]=0;
        for (int i=1;i<2;++i){
            dis[i][0]=dis[i-1][0]+1;
        }
        for (int i=1;i<secondLength;++i){
            dis[0][i]=dis[0][i-1]+1;
        }
        /*动态规划*/
        for (int i=0;i<firstLength;++i) {
            for (int j = 0; j < secondLength; ++j) {
                if (_first[i] == _second[j]) {
                    // 匹配则直接赋值，距离不变
                    dis[(i+1)%2][j + 1] = dis[i%2][j];
                } else {
                    // 不匹配时假设三种情况，增删改
                    dis[(i + 1)%2][j + 1] = Math.min(Math.min(dis[(i + 1)%2][j], dis[i%2][j + 1]), dis[i%2][j]) + 1;
                }
            }
        }
        return (double)(secondLength-dis[firstLength%2][secondLength])/secondLength; //归一化
    }

    /* 去除空格等非中英文数字字符*/

    public void PreProgress() {
        // 匹配正则表达式
        String patternText = " [\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5|\\uff0d \\uff3f|\\u002d]?";
        Pattern pattern = Pattern.compile(patternText);
        this._second = pattern.matcher(new String(this._second)).replaceAll("").trim().toCharArray();
        this._first = pattern.matcher(new String(this._first)).replaceAll("").trim().toCharArray();
    }
}