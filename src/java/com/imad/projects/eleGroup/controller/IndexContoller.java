/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imad.projects.eleGroup.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ibakli
 */
@Controller
public class IndexContoller {
    
    @RequestMapping(value = "/login" , method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth instanceof AnonymousAuthenticationToken){
           model.setViewName("security/login");
        }else{
          model.setViewName("redirect:/accueil");
        } 
        return model;
    }
}
