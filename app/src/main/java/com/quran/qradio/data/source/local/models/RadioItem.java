package com.quran.qradio.data.source.local.models;

public class RadioItem {
	
	private String RadioId; 
	private String RadioName;
	private String RadioImageUrl; 
	private String RadioUrl;
	private int id;

	public RadioItem()
	{
		
	}
	public RadioItem(String Radioid)
	{
		this.RadioId=Radioid;
	}
	
	public RadioItem(String Radioid,String Radioname,String Radiourl,String image)
	{
		this.RadioId=Radioid;
		this.RadioName=Radioname;
		this.RadioUrl=Radiourl;
		this.RadioImageUrl=image;
		
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRadioId() {
		return RadioId;
	}

	public void setRadioId(String Radioid) {
		this.RadioId = Radioid;
	}
	
	
	public String getRadioName() {
		return RadioName;
	}

	public void setRadioName(String Radioname) {
		this.RadioName = Radioname;
	}
	
	public String getRadioImageurl()
	{
		return RadioImageUrl;
		
	}
	
	public void setRadioImageurl(String radioimage)
	{
		this.RadioImageUrl=radioimage;
	}
	
	public String getRadiourl()
	{
		return RadioUrl;
		
	}
	
	public void setRadiourl(String radiourl)
	{
		this.RadioUrl=radiourl;
	}

}
