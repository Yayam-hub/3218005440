package stringmacth.com;
import java.io.File;
//import java.io.File;
import java.io.IOException;

public class Main {
	

	static void calculate(String firstTextPath, String secondTextPath, String outTextPath) {
		// TODO Auto-generated method stub
		 long startTime=System.currentTimeMillis();
		  File f=new File(firstTextPath);
			 File f1=new File(secondTextPath);
			 File f2=new File(outTextPath);
			 System.out.println("ԭ���ı�����·����"+f.getAbsolutePath());
			 System.out.println("��Ϯ�ı�����·����"+f1.getAbsolutePath());
			 System.out.println("����ı�����·����"+f2.getAbsolutePath());
			 
		        try {
		            double similarity = 0.0;
					try {
		                
						String first = FileOperation.ReadToString(firstTextPath);
		               
						String second = FileOperation.ReadToString(secondTextPath);
					 ISMatch match = new SMatch(first, second);
					match.PreProgress();
		                similarity =  match.Match();
		            } catch (IOException | TextException e) {
		                System.out.println(e.getMessage());
		            }
		               
							// ������ļ�
		                    FileOperation.SaveStringToFile(String.format("%.2f\n", similarity),outTextPath);
		                    System.out.printf("�ı����ƶȣ�%.2f\n", similarity);
		        }catch (Exception e){
		            System.out.println(e.getMessage());
		        }
		      
		        long endTime=System.currentTimeMillis(); //��ȡ����ʱ��

		        System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
		        
	}

	
	public static void main(String[]args) {
		// TODO Auto-generated method stub
		calculate(args[0],args[1],args[2]);
	}

	
}


