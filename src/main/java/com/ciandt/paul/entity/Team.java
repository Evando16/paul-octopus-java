package com.ciandt.paul.entity;

public class Team {
	private String name;
	private TeamHistory history;
	private TeamCupDetails cupDetails2006;
	private TeamCupDetails cupDetails2010;
	private TeamCupDetails cupDetails2014;
	private TeamCupDetails cupDetails2018;

	public Team() {
		super();
		this.cupDetails2006 = new TeamCupDetails();
		this.cupDetails2010 = new TeamCupDetails();
		this.cupDetails2014 = new TeamCupDetails();
		this.cupDetails2018 = new TeamCupDetails();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamHistory getHistory() {
		return history;
	}

	public void setHistory(TeamHistory history) {
		this.history = history;
	}

	public TeamCupDetails getCupDetails2006() {
		return cupDetails2006;
	}

	public TeamCupDetails getCupDetails2010() {
		return cupDetails2010;
	}

	public TeamCupDetails getCupDetails2014() {
		return cupDetails2014;
	}

	public TeamCupDetails getCupDetails2018() {
		return cupDetails2018;
	}

}
