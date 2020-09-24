package stringmacth.com;
import java.io.*;
import java.nio.charset.StandardCharsets;
public interface FileOperation {
    /* ��ȡ�ı�
     * @param filePath �ļ����Ի������·��
     * @return �����ַ����ı�
     * @throws IOException �ļ������쳣
     */
    static String ReadToString(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line=reader.readLine())!=null){
            builder.append(line);
        }
        reader.close(); // [2020-09-16]fix reader close
        return builder.toString();
    }

    /* �����ļ�
     * @param text ������ı�
     * @param filePath �ļ�·��
     * @throws IOException �ļ�����쳣
     */
    static void SaveStringToFile(String text,String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(text);
        writer.close();
    }
}
