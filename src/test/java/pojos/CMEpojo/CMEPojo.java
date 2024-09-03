package pojos.CMEpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CMEPojo{
	private String activityID;
	private String note;
	private Integer versionId;
	private List<InstrumentsItem> instruments;
	private Object activeRegionNum;
	private String catalog;
	private String link;
	private Object linkedEvents;
	private String startTime;
	private String sourceLocation;
	private List<CmeAnalysesItem> cmeAnalyses;
	private String submissionTime;

	public void setActivityID(String activityID){
		this.activityID = activityID;
	}

	public String getActivityID(){
		return activityID;
	}

	public void setNote(String note){
		this.note = note;
	}

	public String getNote(){
		return note;
	}

	public void setVersionId(Integer versionId){
		this.versionId = versionId;
	}

	public Integer getVersionId(){
		return versionId;
	}

	public void setInstruments(List<InstrumentsItem> instruments){
		this.instruments = instruments;
	}

	public List<InstrumentsItem> getInstruments(){
		return instruments;
	}

	public void setActiveRegionNum(Object activeRegionNum){
		this.activeRegionNum = activeRegionNum;
	}

	public Object getActiveRegionNum(){
		return activeRegionNum;
	}

	public void setCatalog(String catalog){
		this.catalog = catalog;
	}

	public String getCatalog(){
		return catalog;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setLinkedEvents(Object linkedEvents){
		this.linkedEvents = linkedEvents;
	}

	public Object getLinkedEvents(){
		return linkedEvents;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setSourceLocation(String sourceLocation){
		this.sourceLocation = sourceLocation;
	}

	public String getSourceLocation(){
		return sourceLocation;
	}

	public void setCmeAnalyses(List<CmeAnalysesItem> cmeAnalyses){
		this.cmeAnalyses = cmeAnalyses;
	}

	public List<CmeAnalysesItem> getCmeAnalyses(){
		return cmeAnalyses;
	}

	public void setSubmissionTime(String submissionTime){
		this.submissionTime = submissionTime;
	}

	public String getSubmissionTime(){
		return submissionTime;
	}

	@Override
 	public String toString(){
		return 
			"CMEPojo{" + 
			"activityID = '" + activityID + '\'' + 
			",note = '" + note + '\'' + 
			",versionId = '" + versionId + '\'' + 
			",instruments = '" + instruments + '\'' + 
			",activeRegionNum = '" + activeRegionNum + '\'' + 
			",catalog = '" + catalog + '\'' + 
			",link = '" + link + '\'' + 
			",linkedEvents = '" + linkedEvents + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",sourceLocation = '" + sourceLocation + '\'' + 
			",cmeAnalyses = '" + cmeAnalyses + '\'' + 
			",submissionTime = '" + submissionTime + '\'' + 
			"}";
		}
}