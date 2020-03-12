package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.ParksDao;
import com.techelevator.dao.SurveyDao;
import com.techelevator.model.Parks;
import com.techelevator.model.Survey;
import com.techelevator.model.Weather;

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
		List<Weather> weatherList = parksDao.getWeatherByCode(currentParkCode);
		map.addAttribute("park", park);
		map.addAttribute("weatherList", weatherList);
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyPage(ModelMap map) {
		
		if(! map.containsAttribute("newSurvey")) {
			map.addAttribute("newSurvey", new Survey());
		}
		
		
		
		
		return "survey";
	}
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String surveyForm(@Valid @ModelAttribute("newSurvey") Survey newSurvey,
			BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors() ) {
			return "survey";
		}
//		survey.setParkCode(parkCode);
//		survey.setEmail(email);
//		survey.setState(state);
//		survey.setActivityLevel(activityLevel);
//		
//		surveyDao.save(survey);
		
		return "redirect:/favoriteParks";
	}
	@RequestMapping(path="/favoriteParks", method=RequestMethod.GET)
	public String showFavoriteParksPage(HttpServletRequest request) {
		List<Survey> surveys = surveyDao.getAllSurveys();
		request.setAttribute("surveys", surveys);
		return "favoriteParks";
	}
	
}
