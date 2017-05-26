package dao;

import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class ChannelDao {
	ConnectionMaker connectionMaker;
	public ChannelDao() {
		connectionMaker = new ConnectionMakerKH();
	}
}
