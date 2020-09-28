package stringmacth.com;


//import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class MainTest {
	
@BeforeClass
 public static void BeforeTest() {
	System.out.println("测试开始！");
}

@AfterClass
public static void AfterTest() {
	System.out.println("测试结束！");
}


/*

 * @method 相同文件比较

 * @return void

 */
	
/*相同文本进行比较*/
	@Test
	 void testSame() {
		try {
			    Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\out.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/*orig.txt与orig_0.8_add.txt进行比较*/
		@Test
	 void testAdd() {
		 try {


			    Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt", "E:\\JAVA\\Edit\\src\\test1\\orig_0.8_add.txt","E:\\JAVA\\Edit\\src\\test1\\out_1.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
		/*orig.txt与orig_del.txt进行比较*/
		@Test
		void testDel() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_del.txt","E:\\JAVA\\Edit\\src\\test1\\out_2.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		/*orig.txt与orig_0.8_dis_1.txt比较*/
		@Test
		void testDis1() {
			try {
			
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_dis_1.txt","E:\\JAVA\\Edit\\src\\test1\\out_3.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*orig.txt与orig_0.8_dis_10.txt比较*/
		@Test
		void testDis10() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_dis_10.txt","E:\\JAVA\\Edit\\src\\test1\\out_4.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*orig.txt与orig_0.8_dis_15.txt比较*/
		@Test
		void testDis15() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_dis_15.txt","E:\\JAVA\\Edit\\src\\test1\\out_5.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*orig.txt与Empty.txt比较*/
		@Test
		void testEmpty() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\Empty.txt","E:\\JAVA\\Edit\\src\\test1\\out_6.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*orig.txt与空文件比较*/
		@Test
		void testNone() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","","E:\\JAVA\\Edit\\src\\test1\\out_6.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		@Test
		void testWrong() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_1.txt","E:\\JAVA\\Edit\\src\\test1\\out_7.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		


