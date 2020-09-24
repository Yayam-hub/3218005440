package stringmacth.com;


public class SMatch //implements ISMatch
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

        // ��ʼ����Ϊ���

        dis[0][0]=0;
        for (int i=1;i<2;++i){
            dis[i][0]=dis[i-1][0]+1;
        }
        for (int i=1;i<desLength;++i){
            dis[0][i]=dis[0][i-1]+1;
        }
        /*��̬�滮*/
        for (int i=0;i<originLength;++i) {
            for (int j = 0; j < desLength; ++j) {
                if (_first[i] == _second[j]) {
                    // ƥ����ֱ�Ӹ�ֵ�����벻��
                    dis[(i+1)%2][j + 1] = dis[i%2][j];
                } else {
                    // ��ƥ��ʱ���������������ɾ��
                    dis[(i + 1)%2][j + 1] = Math.min(Math.min(dis[(i + 1)%2][j], dis[i%2][j + 1]), dis[i%2][j]) + 1;
                }
            }
        }
        return (double)(desLength-dis[originLength%2][desLength])/desLength; //��һ��
    }

  
}