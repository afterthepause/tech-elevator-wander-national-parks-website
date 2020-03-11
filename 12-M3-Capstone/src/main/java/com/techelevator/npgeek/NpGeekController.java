package com.techelevator.npgeek;

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
import com.techelevator.model.Parks;

@Controller
@SessionAttributes()
public class NpGeekController {

	@Autowired
	private ParksDao parksDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Parks> parks = parksDao.getAllParks();
		request.setAttribute("parks", parks);
		return "homePage";
	}
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String parkDetailPage(@RequestParam String parkCode, ModelMap map) {
		Parks park = parksDao.getByCode(parkCode);
		map.addAttribute("park", park);
		return "parkDetail";
	}
	
	
	
}
