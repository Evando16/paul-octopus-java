package com.ciandt.paul.entity;

public class TeamCupDetails {

	private Integer year;
	private FifaRank fifaRank;
	private Integer goolsMade;
	private Integer goolsSuffered;
	private Integer goolsMadeAVG;
	private Integer goolsSufferedAVG;
	private Integer numberOfMatches;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public FifaRank getFifaRank() {
		return fifaRank;
	}

	public void setFifaRank(FifaRank fifaRank) {
		this.fifaRank = fifaRank;
	}

	public void addGoolsMade(Integer numGools) {
		this.goolsMade += numGools;
	}

	public void addGoolsSuffered(Integer numSuffered) {
		this.goolsSuffered += numSuffered;
	}

	public void addMatch() {
		numberOfMatches++;
	}

	public Double getGoolsMadeAVG() {
		return (double) (goolsMadeAVG / numberOfMatches);
	}

	public Double getGoolsSufferedAVG() {
		return (double) (goolsSufferedAVG / numberOfMatches);
	}

}
