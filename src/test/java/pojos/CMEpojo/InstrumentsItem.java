package pojos.CMEpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class InstrumentsItem{
	private String displayName;

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	@Override
 	public String toString(){
		return 
			"InstrumentsItem{" + 
			"displayName = '" + displayName + '\'' + 
			"}";
		}
}
