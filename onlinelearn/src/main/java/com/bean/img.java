package com.bean;

public class img {
	@Override
	public String toString() {
		return "img [imageId=" + imageId + ", imageUrl=" + imageUrl + ", linkAddress=" + linkAddress + ", title="
				+ title + ", imgType=" + imgType + ", seriesNumber=" + seriesNumber + ", previewUrl=" + previewUrl
				+ ", color=" + color + ", describes=" + describes + "]";
	}
	private int imageId;  // ID
	private  String imageUrl; //ͼƬ��ַ
	private  String linkAddress;  //ͼƬ���ӵ�ַ
	private  String title;        //ͼƬ����
	private imgType  imgType;      //ͼƬ����
	private int   seriesNumber;    //���к�
	private  String  previewUrl;  //����ͼƬ��ַ
	private  String  color;        //����ɫ
	private  String describes;      //ͼƬ����
	
	
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public imgType getImgType() {
		return imgType;
	}
	public void setImgType(imgType imgType) {
		this.imgType = imgType;
	}
	public int getSeriesNumber() {
		return seriesNumber;
	}
	public void setSeriesNumber(int seriesNumber) {
		this.seriesNumber = seriesNumber;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	

	
	
	
	
	

	

}
