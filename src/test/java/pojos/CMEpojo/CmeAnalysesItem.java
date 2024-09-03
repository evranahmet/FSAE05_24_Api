package pojos.CMEpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class CmeAnalysesItem{
	private List<EnlilListItem> enlilList;
	private String note;
	private Integer levelOfData;
	private String featureCode;
	private Object minorHalfWidth;
	private Object latitude;
	private String link;
	private Object tilt;
	private String type;
	private Object speed;
	private String submissionTime;
	private Object speedMeasuredAtHeight;
	private Object halfAngle;
	private Boolean isMostAccurate;
	private String measurementTechnique;
	private Object imageType;
	private String time215;
	private Object longitude;

	public void setEnlilList(List<EnlilListItem> enlilList){
		this.enlilList = enlilList;
	}

	public List<EnlilListItem> getEnlilList(){
		return enlilList;
	}

	public void setNote(String note){
		this.note = note;
	}

	public String getNote(){
		return note;
	}

	public void setLevelOfData(Integer levelOfData){
		this.levelOfData = levelOfData;
	}

	public Integer getLevelOfData(){
		return levelOfData;
	}

	public void setFeatureCode(String featureCode){
		this.featureCode = featureCode;
	}

	public String getFeatureCode(){
		return featureCode;
	}

	public void setMinorHalfWidth(Object minorHalfWidth){
		this.minorHalfWidth = minorHalfWidth;
	}

	public Object getMinorHalfWidth(){
		return minorHalfWidth;
	}

	public void setLatitude(Object latitude){
		this.latitude = latitude;
	}

	public Object getLatitude(){
		return latitude;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setTilt(Object tilt){
		this.tilt = tilt;
	}

	public Object getTilt(){
		return tilt;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setSpeed(Object speed){
		this.speed = speed;
	}

	public Object getSpeed(){
		return speed;
	}

	public void setSubmissionTime(String submissionTime){
		this.submissionTime = submissionTime;
	}

	public String getSubmissionTime(){
		return submissionTime;
	}

	public void setSpeedMeasuredAtHeight(Object speedMeasuredAtHeight){
		this.speedMeasuredAtHeight = speedMeasuredAtHeight;
	}

	public Object getSpeedMeasuredAtHeight(){
		return speedMeasuredAtHeight;
	}

	public void setHalfAngle(Object halfAngle){
		this.halfAngle = halfAngle;
	}

	public Object getHalfAngle(){
		return halfAngle;
	}

	public void setIsMostAccurate(Boolean isMostAccurate){
		this.isMostAccurate = isMostAccurate;
	}

	public Boolean isIsMostAccurate(){
		return isMostAccurate;
	}

	public void setMeasurementTechnique(String measurementTechnique){
		this.measurementTechnique = measurementTechnique;
	}

	public String getMeasurementTechnique(){
		return measurementTechnique;
	}

	public void setImageType(Object imageType){
		this.imageType = imageType;
	}

	public Object getImageType(){
		return imageType;
	}

	public void setTime215(String time215){
		this.time215 = time215;
	}

	public String getTime215(){
		return time215;
	}

	public void setLongitude(Object longitude){
		this.longitude = longitude;
	}

	public Object getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"CmeAnalysesItem{" + 
			"enlilList = '" + enlilList + '\'' + 
			",note = '" + note + '\'' + 
			",levelOfData = '" + levelOfData + '\'' + 
			",featureCode = '" + featureCode + '\'' + 
			",minorHalfWidth = '" + minorHalfWidth + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",link = '" + link + '\'' + 
			",tilt = '" + tilt + '\'' + 
			",type = '" + type + '\'' + 
			",speed = '" + speed + '\'' + 
			",submissionTime = '" + submissionTime + '\'' + 
			",speedMeasuredAtHeight = '" + speedMeasuredAtHeight + '\'' + 
			",halfAngle = '" + halfAngle + '\'' + 
			",isMostAccurate = '" + isMostAccurate + '\'' + 
			",measurementTechnique = '" + measurementTechnique + '\'' + 
			",imageType = '" + imageType + '\'' + 
			",time21_5 = '" + time215 + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}
