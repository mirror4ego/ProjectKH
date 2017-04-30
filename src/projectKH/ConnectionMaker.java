package projectKH;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker { // 커넥션을 만드는 인터페이스... 이 인터페이스를 implement하면 커넥션과 관련된 것을 반드시 구현해야 한다.
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
