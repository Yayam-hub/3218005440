package stringmacth.com;
import java.io.File;
import java.io.IOException;

public class Main {
	 public static void main(String[] args) {
		 long startTime=System.currentTimeMillis();
		 File f=new File("E:\\\\JAVA\\\\Edit\\\\src\\\\test1\\\\orig.txt");
		 File f1=new File("E:\\JAVA\\Edit\\src\\test1\\orig_0.8_add.txt");
		 File f2=new File("E:\\JAVA\\Edit\\src\\test1\\out.txt");
		 System.out.println("ԭ���ı�����·����"+f.getAbsolutePath());
		 System.out.println("��Ϯ�ı�����·����"+f1.getAbsolutePath());
		 System.out.println("����ı�����·����"+f2.getAbsolutePath());
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
	                if (args.length > 2 && args[2] != null) { // ����е�����������������ļ��������������Ļ��
	                    FileOperation.SaveStringToFile(String.format("%.2f\n", similarity), args[2]);
	                } else {
	                    System.out.printf("�ı����ƶȣ�%.2f\n", similarity);
	                }
	            }
	        }catch (Exception e){
	            System.out.println(e.getMessage());
	        }
	        long endTime=System.currentTimeMillis(); //��ȡ����ʱ��

	        System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
	        System.exit(0); // ��������������0
	    }
}
