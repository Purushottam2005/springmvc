package cn.webservice;

public class TestWebservice {
	public int checkUserRight(String userId, String password) {
        //����������ݿ����
        if (password != null && "fred".equals(userId)) {
            return 1;
        }
    return 0;
}
}
