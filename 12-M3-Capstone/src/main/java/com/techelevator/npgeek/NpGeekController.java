package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.dao.ParksDao;
import com.techelevator.model.Parks;

@Controller
public class NpGeekController {

	@Autowired
	private ParksDao parksDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Parks> parks = parksDao.getAllParks();
		request.setAttribute("parks", parks);
		return "homePage";
	}
	
	
	
	
}
