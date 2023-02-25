package com.example.proje;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
public class ProjeController {

	@Autowired
	public ProjeController() {
		super();
		
	}
	
	
	@GetMapping("/")
	public String viewHomePage(HttpServletRequest request) 	
	{
		Locale currentLocale = request.getLocale();
		String countryCode = currentLocale.getCountry();
		String countryName = currentLocale.getDisplayCountry();
		
		String langCode = currentLocale.getLanguage();
		String langName = currentLocale.getDisplayLanguage();
		
		System.out.println(countryCode +":"+countryName);
		System.out.println(langCode + ":" + langName);
		
		System.out.println("============");
		String[] languages = Locale.getISOLanguages();
		
		for(String language : languages) {
			Locale locale = new Locale(language);
			System.out.println(language + ":" + locale.getDisplayLanguage());
		}
		
		return "index";
	}
	
	
	@PostMapping(value="/add")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String number1 = request.getParameter("no1");
		String number2 = request.getParameter("no2");
		
		int no1= Integer.parseInt(number1);
		int no2= Integer.parseInt(number2);
		
		int sum = no1+no2;
		
		//String result = String.valueOf("sum");
		
		String result=String.valueOf(sum);
		
		//String result = Integer.toString(sum);
		
        int grupSayisi = 6;
		
        String yazi ="";
		
		String[] birler = { "", "BİR ", "İKİ ", "ÜÇ ", "DÖRT ", "BEŞ ", "ALTI ", "YEDİ ", "SEKİZ ", "DOKUZ " };
        String[] onlar = { "", "ON ", "YİRMİ ", "OTUZ ", "KIRK ", "ELLİ ", "ALTMIŞ ", "YETMİŞ ", "SEKSEN ", "DOKSAN " };
        String[] binler = { "KATRİLYON ", "TRİLYON ", "MİLYAR ", "MİLYON ", "BİN ", "" };
        
        
        
        for(int i = 0; i < grupSayisi; i += 1)
        {
        	String grupDegeri = "";
            String s = result.substring(i, 1);
            if (s != "0")
                grupDegeri += birler[Integer.parseInt(result.substring(i, 1))] + "YÜZ"; //yüzler            
            if (grupDegeri == "BİRYÜZ") //biryüz düzeltiliyor.         
                grupDegeri = "YÜZ";
            grupDegeri += onlar[Integer.parseInt(result.substring(i + 1, 1))]; //onlar  
            grupDegeri += birler[Integer.parseInt(result.substring(i + 2, 1))]; //birler    
            if (grupDegeri != "") //binler    
                grupDegeri += binler[i / 3];
            if (grupDegeri == "BİRBİN") //birbin düzeltiliyor.         
                grupDegeri = "BİN";
            yazi += grupDegeri;
        }
		
		request.setAttribute("result",yazi);
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
	    rd.forward(request,response);
	}
	
	
	
	@GetMapping(value="/add")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	@PostMapping(value="/subtract")
	protected void dosubtractPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String number1 = request.getParameter("no1");
		String number2 = request.getParameter("no2");
		
		int no1= Integer.parseInt(number1);
		int no2= Integer.parseInt(number2);
		
		int subtract = no1-no2;
		
		//String result = String.valueOf("sum");
		
		String result=String.valueOf(subtract);
		
		//String result = Integer.toString(sum);
		
		
        int grupSayisi = 6;
		
        String yazi ="";
		
		String[] birler = { "", "BİR ", "İKİ ", "ÜÇ ", "DÖRT ", "BEŞ ", "ALTI ", "YEDİ ", "SEKİZ ", "DOKUZ " };
        String[] onlar = { "", "ON ", "YİRMİ ", "OTUZ ", "KIRK ", "ELLİ ", "ALTMIŞ ", "YETMİŞ ", "SEKSEN ", "DOKSAN " };
        String[] binler = { "KATRİLYON ", "TRİLYON ", "MİLYAR ", "MİLYON ", "BİN ", "" };
        
        
        
        for(int i = 0; i < grupSayisi; i += 1)
        {
        	String grupDegeri = "";
            String s = result.substring(i, 1);
            if (s != "0")
                grupDegeri += birler[Integer.parseInt(result.substring(i, 1))] + "YÜZ"; //yüzler            
            if (grupDegeri == "BİRYÜZ") //biryüz düzeltiliyor.         
                grupDegeri = "YÜZ";
            grupDegeri += onlar[Integer.parseInt(result.substring(i + 1, 1))]; //onlar  
            grupDegeri += birler[Integer.parseInt(result.substring(i + 2, 1))]; //birler    
            if (grupDegeri != "") //binler    
                grupDegeri += binler[i / 3];
            if (grupDegeri == "BİRBİN") //birbin düzeltiliyor.         
                grupDegeri = "BİN";
            yazi += grupDegeri;
        }
		
		request.setAttribute("result",yazi);
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
	    rd.forward(request,response);
	}
	
	@GetMapping(value="/subtract")
	protected void dosubtractGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@PostMapping(value="/multiplication")
	protected void domultiplicationPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String number1 = request.getParameter("no1");
		String number2 = request.getParameter("no2");
		
		int no1= Integer.parseInt(number1);
		int no2= Integer.parseInt(number2);
		
		int multiplication = no1*no2;
		
		//String result = String.valueOf("sum");
		
		String result=String.valueOf(multiplication);
		
		//String result = Integer.toString(sum);
		
		int grupSayisi = 6;
		
        String yazi ="";
		
		String[] birler = { "", "BİR ", "İKİ ", "ÜÇ ", "DÖRT ", "BEŞ ", "ALTI ", "YEDİ ", "SEKİZ ", "DOKUZ " };
        String[] onlar = { "", "ON ", "YİRMİ ", "OTUZ ", "KIRK ", "ELLİ ", "ALTMIŞ ", "YETMİŞ ", "SEKSEN ", "DOKSAN " };
        String[] binler = { "KATRİLYON ", "TRİLYON ", "MİLYAR ", "MİLYON ", "BİN ", "" };
        
        
        
        for(int i = 0; i < grupSayisi; i += 1)
        {
        	String grupDegeri = "";
            String s = result.substring(i, 1);
            if (s != "0")
                grupDegeri += birler[Integer.parseInt(result.substring(i, 1))] + "YÜZ"; //yüzler            
            if (grupDegeri == "BİRYÜZ") //biryüz düzeltiliyor.         
                grupDegeri = "YÜZ";
            grupDegeri += onlar[Integer.parseInt(result.substring(i + 1, 1))]; //onlar  
            grupDegeri += birler[Integer.parseInt(result.substring(i + 2, 1))]; //birler    
            if (grupDegeri != "") //binler    
                grupDegeri += binler[i / 3];
            if (grupDegeri == "BİRBİN") //birbin düzeltiliyor.         
                grupDegeri = "BİN";
            yazi += grupDegeri;
        }
		
		request.setAttribute("result",yazi);
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
	    rd.forward(request,response);
	}
	
	@GetMapping(value="/multiplication")
	protected void domultiplicationGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	@PostMapping(value="/division")
	protected void dodivisionPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String number1 = request.getParameter("no1");
		String number2 = request.getParameter("no2");
		
		int no1= Integer.parseInt(number1);
		int no2= Integer.parseInt(number2);
		
		int division = no1/no2;
		
		//String result = String.valueOf("sum");
		
		String result=String.valueOf(division);
				
	    //String result = Integer.toString(sum);
		
		//String result="";
		
		int grupSayisi = 6;
		
		String yazi ="";
		
		String[] birler = { "", "BİR ", "İKİ ", "ÜÇ ", "DÖRT ", "BEŞ ", "ALTI ", "YEDİ ", "SEKİZ ", "DOKUZ " };
        String[] onlar = { "", "ON ", "YİRMİ ", "OTUZ ", "KIRK ", "ELLİ ", "ALTMIŞ ", "YETMİŞ ", "SEKSEN ", "DOKSAN " };
        String[] binler = { "KATRİLYON ", "TRİLYON ", "MİLYAR ", "MİLYON ", "BİN ", "" };
        
        
        for(int i = 0; i < grupSayisi; i += 1)
        {
        	String grupDegeri = "";
            String s = result.substring(i, 1);
            if (s != "0")
                grupDegeri += birler[Integer.parseInt(result.substring(i, 1))] + "YÜZ"; //yüzler            
            if (grupDegeri == "BİRYÜZ") //biryüz düzeltiliyor.         
                grupDegeri = "YÜZ";
            grupDegeri += onlar[Integer.parseInt(result.substring(i + 1, 1))]; //onlar  
            grupDegeri += birler[Integer.parseInt(result.substring(i + 2, 1))]; //birler    
            if (grupDegeri != "") //binler    
                grupDegeri += binler[i / 3];
            if (grupDegeri == "BİRBİN") //birbin düzeltiliyor.         
                grupDegeri = "BİN";
            yazi += grupDegeri;
        }
		
		request.setAttribute("result",yazi);
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
	    rd.forward(request,response);
	}
	
	@GetMapping(value="/division")
	protected void dodivisionGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}

