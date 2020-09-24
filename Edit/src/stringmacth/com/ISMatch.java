package stringmacth.com;


public interface ISMatch {
	  /* 匹配字符串

     * @return 返回相似度

     */
	double Match() throws TextException;
    /* 字符串预处理*/
  void PreProgress();
}


