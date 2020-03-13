package com.techelevator.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
@SessionAttributes({"parks", "weather"})
public class NpGeekController {

	@Autowired
	private ParksDao parksDao;
	

	@Autowired
	private SurveyDao surveyDao;
	

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		List<Parks> parks = parksDao.getAllParks();
		map.addAttribute("parks", parks);
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
	@RequestMapping(path="/weatherRefresh", method=RequestMethod.POST)
	public String weatherRefresh(@RequestParam String tempUnit, ModelMap map) {
		if(! map.containsAttribute("weather")) {
			map.addAttribute("weather", tempUnit);
		} else { map.replace("weather", tempUnit);
		}
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
		

		surveyDao.save(newSurvey);
		attr.addFlashAttribute("survey",newSurvey);
		

		return "redirect:/favoriteParks";
	}
	
	@RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
	public String showFavoriteParksPage(ModelMap map) {
	Map<Parks, Integer> parkMap = new LinkedHashMap<Parks, Integer>();
	for (Entry entry : surveyDao.getCountOfSurveysPerParkCode().entrySet()) {
	parkMap.put(parksDao.getByCode((String) entry.getKey()), ((Integer) entry.getValue()));
	}
	map.addAttribute("surveyCount", parkMap);

	return "favoriteParks";
	}
	

}