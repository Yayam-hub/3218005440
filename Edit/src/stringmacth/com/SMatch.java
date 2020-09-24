package stringmacth.com;
import java.util.regex.Pattern;

public class SMatch implements ISMatch
{

    private char [] _first ;

    private char [] _second ;



    /*���캯��

     * @param first ԭ���ı�

     * @param second ��Ϯ�ı�

     */

    public SMatch(char [] first, char [] second) {

        this._first=first;

        this._second =second;

    }



    /*���캯��

     * @param origin ԭʼ�ı�

     * @param dest Ŀ���ı�

     */

    public SMatch(java.lang.String origin,java.lang.String dest) {
        this._first=origin.toCharArray();
        this._second=dest.toCharArray();
    }



    /* Match ʵ�ַ���������༭��

     * @return ���ر༭�����һ�����

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

        // ��ʼ����Ϊ���

        dis[0][0]=0;
        for (int i=1;i<2;++i){
            dis[i][0]=dis[i-1][0]+1;
        }
        for (int i=1;i<secondLength;++i){
            dis[0][i]=dis[0][i-1]+1;
        }
        /*��̬�滮*/
        for (int i=0;i<firstLength;++i) {
            for (int j = 0; j < secondLength; ++j) {
                if (_first[i] == _second[j]) {
                    // ƥ����ֱ�Ӹ�ֵ�����벻��
                    dis[(i+1)%2][j + 1] = dis[i%2][j];
                } else {
                    // ��ƥ��ʱ���������������ɾ��
                    dis[(i + 1)%2][j + 1] = Math.min(Math.min(dis[(i + 1)%2][j], dis[i%2][j + 1]), dis[i%2][j]) + 1;
                }
            }
        }
        return (double)(secondLength-dis[firstLength%2][secondLength])/secondLength; //��һ��
    }

    /* ȥ���ո�ȷ���Ӣ�������ַ�*/

    public void PreProgress() {
        // ƥ��������ʽ
        String patternText = " [\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5|\\uff0d \\uff3f|\\u002d]?";
        Pattern pattern = Pattern.compile(patternText);
        this._second = pattern.matcher(new String(this._second)).replaceAll("").trim().toCharArray();
        this._first = pattern.matcher(new String(this._first)).replaceAll("").trim().toCharArray();
    }
}