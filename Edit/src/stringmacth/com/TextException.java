package stringmacth.com;

/*�ı��쳣��*/
public class TextException extends Exception{
	private static final long serialVersionUID = 1L;
	public TextException(String message){
        super(message);
    }
    public TextException(String message,Throwable cause){
        super(message,cause);
    }
    public TextException(Throwable cause){
        super(cause);
    }
}
