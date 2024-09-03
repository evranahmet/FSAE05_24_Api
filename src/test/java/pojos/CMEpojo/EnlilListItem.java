package pojos.CMEpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class EnlilListItem{
	private Object estimatedShockArrivalTime;
	private Object kp180;
	private List<String> cmeIDs;
	private String link;
	private Object kp90;
	private Object estimatedDuration;
	private String modelCompletionTime;
	private Boolean isEarthGB;
	private Object rminRe;
	private Object au;
	private Object kp135;
	private Object kp18;
	private List<ImpactListItem> impactList;

	public void setEstimatedShockArrivalTime(Object estimatedShockArrivalTime){
		this.estimatedShockArrivalTime = estimatedShockArrivalTime;
	}

	public Object getEstimatedShockArrivalTime(){
		return estimatedShockArrivalTime;
	}

	public void setKp180(Object kp180){
		this.kp180 = kp180;
	}

	public Object getKp180(){
		return kp180;
	}

	public void setCmeIDs(List<String> cmeIDs){
		this.cmeIDs = cmeIDs;
	}

	public List<String> getCmeIDs(){
		return cmeIDs;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setKp90(Object kp90){
		this.kp90 = kp90;
	}

	public Object getKp90(){
		return kp90;
	}

	public void setEstimatedDuration(Object estimatedDuration){
		this.estimatedDuration = estimatedDuration;
	}

	public Object getEstimatedDuration(){
		return estimatedDuration;
	}

	public void setModelCompletionTime(String modelCompletionTime){
		this.modelCompletionTime = modelCompletionTime;
	}

	public String getModelCompletionTime(){
		return modelCompletionTime;
	}

	public void setIsEarthGB(Boolean isEarthGB){
		this.isEarthGB = isEarthGB;
	}

	public Boolean isIsEarthGB(){
		return isEarthGB;
	}

	public void setRminRe(Object rminRe){
		this.rminRe = rminRe;
	}

	public Object getRminRe(){
		return rminRe;
	}

	public void setAu(Object au){
		this.au = au;
	}

	public Object getAu(){
		return au;
	}

	public void setKp135(Object kp135){
		this.kp135 = kp135;
	}

	public Object getKp135(){
		return kp135;
	}

	public void setKp18(Object kp18){
		this.kp18 = kp18;
	}

	public Object getKp18(){
		return kp18;
	}

	public void setImpactList(List<ImpactListItem> impactList){
		this.impactList = impactList;
	}

	public List<ImpactListItem> getImpactList(){
		return impactList;
	}

	@Override
 	public String toString(){
		return 
			"EnlilListItem{" + 
			"estimatedShockArrivalTime = '" + estimatedShockArrivalTime + '\'' + 
			",kp_180 = '" + kp180 + '\'' + 
			",cmeIDs = '" + cmeIDs + '\'' + 
			",link = '" + link + '\'' + 
			",kp_90 = '" + kp90 + '\'' + 
			",estimatedDuration = '" + estimatedDuration + '\'' + 
			",modelCompletionTime = '" + modelCompletionTime + '\'' + 
			",isEarthGB = '" + isEarthGB + '\'' + 
			",rmin_re = '" + rminRe + '\'' + 
			",au = '" + au + '\'' + 
			",kp_135 = '" + kp135 + '\'' + 
			",kp_18 = '" + kp18 + '\'' + 
			",impactList = '" + impactList + '\'' + 
			"}";
		}
}