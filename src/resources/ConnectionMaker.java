package resources;

import java.sql.Connection;
import java.sql.SQLException;

// 커넥션을 만드는 인터페이스... 이 인터페이스를 implement하면 커넥션과 관련된 것을 반드시 구현해야 한다.
// 이 인터페이스가 있기 때문에 클래스 간의 결합이 느슨해진다.
public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
