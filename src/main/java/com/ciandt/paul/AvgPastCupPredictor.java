package com.ciandt.paul;

import com.ciandt.paul.context.Context;
import com.ciandt.paul.entity.HistoricalMatch;
import com.ciandt.paul.entity.Match;
import com.ciandt.paul.entity.Prediction;
import com.ciandt.paul.entity.Team;

public class AvgPastCupPredictor implements Predictor {

	@Override
	public Prediction predict(Match match, Context context) {
		Prediction prediction = new Prediction(match);
		Team homeTeam = new Team();
		Team awayTeam = new Team();

		// Get infos about teams
		homeTeam.setName(match.getHomeTeam());
		homeTeam.setHistory(context.getHomeTeamHistory());

		for (HistoricalMatch item : context.getHistoricalMatches()) {
			if (item.getHomeTeam().equalsIgnoreCase(homeTeam.getName())) {
				// home team

				if (item.getYear() == 2006) {
					homeTeam.getCupDetails2006().addGoolsMade(item.getHomeScore());
					homeTeam.getCupDetails2006().addGoolsSuffered(item.getAwayScore());
					homeTeam.getCupDetails2006().addMatch();
				} else if (item.getYear() == 2010) {
					homeTeam.getCupDetails2010().addGoolsMade(item.getHomeScore());
					homeTeam.getCupDetails2010().addGoolsSuffered(item.getAwayScore());
					homeTeam.getCupDetails2010().addMatch();
				} else {
					homeTeam.getCupDetails2014().addGoolsMade(item.getHomeScore());
					homeTeam.getCupDetails2014().addGoolsSuffered(item.getAwayScore());
					homeTeam.getCupDetails2014().addMatch();
				}

			} else {
				// away team

				if (item.getYear() == 2006) {
					awayTeam.getCupDetails2006().addGoolsMade(item.getAwayScore());
					awayTeam.getCupDetails2006().addGoolsSuffered(item.getHomeScore());
					awayTeam.getCupDetails2006().addMatch();
				} else if (item.getYear() == 2010) {
					awayTeam.getCupDetails2010().addGoolsMade(item.getAwayScore());
					awayTeam.getCupDetails2010().addGoolsSuffered(item.getHomeScore());
					awayTeam.getCupDetails2010().addMatch();
				} else {
					awayTeam.getCupDetails2014().addGoolsMade(item.getAwayScore());
					awayTeam.getCupDetails2014().addGoolsSuffered(item.getHomeScore());
					awayTeam.getCupDetails2014().addMatch();
				}
			}
		}

		prediction.setHomeScore(
				(int) ((homeTeam.getCupDetails2006().getGoolsMadeAVG() + homeTeam.getCupDetails2010().getGoolsMadeAVG()
						+ homeTeam.getCupDetails2014().getGoolsMadeAVG()) / 3));

		prediction.setAwayScore(
				(int) ((awayTeam.getCupDetails2006().getGoolsMadeAVG() + awayTeam.getCupDetails2010().getGoolsMadeAVG()
						+ awayTeam.getCupDetails2014().getGoolsMadeAVG()) / 3));

		return prediction;
	}

}
