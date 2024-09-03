package pojos.CMEpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ImpactListItem{
	private String arrivalTime;
	private String location;
	private Boolean isGlancingBlow;

	public void setArrivalTime(String arrivalTime){
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalTime(){
		return arrivalTime;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setIsGlancingBlow(Boolean isGlancingBlow){
		this.isGlancingBlow = isGlancingBlow;
	}

	public Boolean isIsGlancingBlow(){
		return isGlancingBlow;
	}

	@Override
 	public String toString(){
		return 
			"ImpactListItem{" + 
			"arrivalTime = '" + arrivalTime + '\'' + 
			",location = '" + location + '\'' + 
			",isGlancingBlow = '" + isGlancingBlow + '\'' + 
			"}";
		}
}
