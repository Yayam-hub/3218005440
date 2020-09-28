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
			 System.out.println("原文文本绝对路径："+f.getAbsolutePath());
			 System.out.println("抄袭文本绝对路径："+f1.getAbsolutePath());
			 System.out.println("输出文本绝对路径："+f2.getAbsolutePath());
			 
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
		               
							// 输出到文件
		                    FileOperation.SaveStringToFile(String.format("%.2f\n", similarity),outTextPath);
		                    System.out.printf("文本相似度：%.2f\n", similarity);
		        }catch (Exception e){
		            System.out.println(e.getMessage());
		        }
		      
		        long endTime=System.currentTimeMillis(); //获取结束时间

		        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		        
	}

	
	public static void main(String[]args) {
		// TODO Auto-generated method stub
		calculate(args[0],args[1],args[2]);
	}

	
}


