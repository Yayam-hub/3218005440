package stringmacth.com;
import java.io.*;
import java.nio.charset.StandardCharsets;
public interface FileOperation {
    /* 读取文本
     * @param filePath 文件绝对或者相对路径
     * @return 返回字符串文本
     * @throws IOException 文件读入异常
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

    /* 保存文件
     * @param text 保存的文本
     * @param filePath 文件路径
     * @throws IOException 文件输出异常
     */
    static void SaveStringToFile(String text,String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(text);
        writer.close();
    }
}
