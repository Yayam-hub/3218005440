package stringmacth.com;


//import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class MainTest {
	
@BeforeClass
 public static void BeforeTest() {
	System.out.println("���Կ�ʼ��");
}

@AfterClass
public static void AfterTest() {
	System.out.println("���Խ�����");
}


/*

 * @method ��ͬ�ļ��Ƚ�

 * @return void

 */
	
/*��ͬ�ı����бȽ�*/
	@Test
	 void testSame() {
		try {
			    Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\out.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/*orig.txt��orig_0.8_add.txt���бȽ�*/
		@Test
	 void testAdd() {
		 try {


			    Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt", "E:\\JAVA\\Edit\\src\\test1\\orig_0.8_add.txt","E:\\JAVA\\Edit\\src\\test1\\out_1.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
		/*orig.txt��orig_del.txt���бȽ�*/
		@Test
		void testDel() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_del.txt","E:\\JAVA\\Edit\\src\\test1\\out_2.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		/*orig.txt��orig_0.8_dis_1.txt�Ƚ�*/
		@Test
		void testDis1() {
			try {
			
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_dis_1.txt","E:\\JAVA\\Edit\\src\\test1\\out_3.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*orig.txt��orig_0.8_dis_10.txt�Ƚ�*/
		@Test
		void testDis10() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_dis_10.txt","E:\\JAVA\\Edit\\src\\test1\\out_4.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*orig.txt��orig_0.8_dis_15.txt�Ƚ�*/
		@Test
		void testDis15() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\orig_0.8_dis_15.txt","E:\\JAVA\\Edit\\src\\test1\\out_5.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*orig.txt��Empty.txt�Ƚ�*/
		@Test
		void testEmpty() {
			try {
				Main.calculate("E:\\JAVA\\Edit\\src\\test1\\orig.txt","E:\\JAVA\\Edit\\src\\test1\\Empty.txt","E:\\JAVA\\Edit\\src\\test1\\out_6.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*orig.txt����ļ��Ƚ�*/
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
		


