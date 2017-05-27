package domain;

public class ChannelDto {
	String channelName;
	String channelFeature;
	ChannelDto(String channelName, String channelFeature){
		this.channelName = channelName;
		this.channelFeature = channelFeature;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelFeature() {
		return channelFeature;
	}
	public void setChannelFeature(String channelFeature) {
		this.channelFeature = channelFeature;
	}


}
