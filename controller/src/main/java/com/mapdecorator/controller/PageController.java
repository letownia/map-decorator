package com.mapdecorator.controller;

//import com.google.gson.Gson;
//import org.springframework.beans.factory.annotation.Autowired;

import com.mapdecorator.config.SupportedLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

/**
 * HTML controller for the main page 1.) Home Page
 *
 * @author Borg Lojasiewicz
 */

@Controller
public class PageController {
  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private Environment env;

  @Autowired
  public PageController(Environment env){
    logger.info("Creating paging controller w /env : " + env);
    Arrays.asList(env.getActiveProfiles()).stream().forEach( x -> logger.info("ActiveProfile :" + x));
    this.env = env;
  }


  private final List<SupportedLocale> allSupportedLocales = Arrays.asList(SupportedLocale.values());

  @ModelAttribute("allSupportedLocales")
  public List<SupportedLocale> getAllSupportedLocales() {
    return allSupportedLocales;
  }

  @ModelAttribute("currentSupportedLocale")
  public SupportedLocale getCurrentSupportedLocale() {
    return SupportedLocale.fromLocale(LocaleContextHolder.getLocale());
  }
  @RequestMapping("/dupa")
  public String test(Model model) {
    logger.info("Returning index2");
    return "index2";
  }
  @RequestMapping("/")
  public String welcome(Model model) {
    logger.info("Returning index");
    return "index";
  }
}
