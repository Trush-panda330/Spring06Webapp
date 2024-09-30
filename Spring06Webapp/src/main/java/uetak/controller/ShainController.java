package uetak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //import 2つ候補がでるけどSpringの方
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uetak.entity.Shain;
import uetak.service.ShainService;

@Controller
public class ShainController {

	@Autowired
	private ShainService shainService;

	@GetMapping("/index")
	public String index(Model model) {

		//リスト取得
		List<Shain> shainList = shainService.findAll();

		//JSPに渡す
		model.addAttribute("shainList", shainList);
		//JSPに転送
		return "index";
		//本来は return "/WEB-INF/index.jsp"だがapplication.propertiesにて設定を変更している
	}
	
	@GetMapping("/insert")
	public String insert() {
		//JSPに転送
		return "insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute Shain request) {
		//パラメータ値から社員作成
		Shain shain = shainService.makeShain(request);
		
		//DBに挿入
		shainService.insertShain(shain);
		
		//redirect
		return "redirect:/index";
		
	}

}
