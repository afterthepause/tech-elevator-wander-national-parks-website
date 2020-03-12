package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.dao.ParksDao;
import com.techelevator.dao.SurveyDao;
import com.techelevator.model.Parks;
import com.techelevator.model.Survey;

@Controller
@SessionAttributes()
public class NpGeekController {

	@Autowired
	private ParksDao parksDao;
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Parks> parks = parksDao.getAllParks();
		request.setAttribute("parks", parks);
		return "homePage";
	}
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String parkDetailPage(@RequestParam String currentParkCode, ModelMap map) {
		Parks park = parksDao.getByCode(currentParkCode);
		map.addAttribute("park", park);
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyPage() {
		return "survey";
	}
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String surveyForm(@RequestParam(required=true) String parkCode, @RequestParam(required=true) String email, @RequestParam(required=true) String state, @RequestParam(required=true) String activityLevel ) {
		
		Survey survey = new Survey();
		survey.setParkCode(parkCode);
		survey.setEmail(email);
		survey.setState(state);
		survey.setActivityLevel(activityLevel);
		
		surveyDao.save(survey);
		
		return "redirect:/favoriteParks";
	}
	
}
