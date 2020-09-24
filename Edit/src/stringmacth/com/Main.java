package stringmacth.com;
import java.io.File;
import java.io.IOException;

public class Main {
	 public static void main(String[] args) {
		 long startTime=System.currentTimeMillis();
		 File f=new File("E:\\\\JAVA\\\\Edit\\\\src\\\\test1\\\\orig.txt");
		 File f1=new File("E:\\JAVA\\Edit\\src\\test1\\orig_0.8_add.txt");
		 File f2=new File("E:\\JAVA\\Edit\\src\\test1\\out.txt");
		 System.out.println("原文文本绝对路径："+f.getAbsolutePath());
		 System.out.println("抄袭文本绝对路径："+f1.getAbsolutePath());
		 System.out.println("输出文本绝对路径："+f2.getAbsolutePath());
	        try {
	            double similarity = 0.0;
	            try {
	                String first = FileOperation.ReadToString("E:\\JAVA\\Edit\\src\\test1\\orig.txt");
	                String second = FileOperation.ReadToString("E:\\JAVA\\Edit\\src\\test1\\orig_0.8_add.txt");
				 SMatch match1 = new SMatch(first, second);
	                
	                similarity =  match1.Match();
	            } catch (IOException | TextException e) {
	                System.out.println(((Throwable) e).getMessage());
	            } finally {
	                if (args.length > 2 && args[2] != null) { // 如果有第三个参数则输出到文件，否则输出到屏幕上
	                    FileOperation.SaveStringToFile(String.format("%.2f\n", similarity), args[2]);
	                } else {
	                    System.out.printf("文本相似度：%.2f\n", similarity);
	                }
	            }
	        }catch (Exception e){
	            System.out.println(e.getMessage());
	        }
	        long endTime=System.currentTimeMillis(); //获取结束时间

	        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	        System.exit(0); // 返回正常结束码0
	    }
}
