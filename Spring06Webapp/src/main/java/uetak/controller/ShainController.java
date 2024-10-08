package uetak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //import 2つ候補がでるけどSpringの方
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/update")
	public String update(
			@RequestParam("id") int id,
			Model model) {

		//対象データを取得
		Shain shain = shainService.findByShainId(id);

		// JSPに渡す
		model.addAttribute("shain", shain);

		// JSPに転送
		return "update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Shain request) {

		//パラメータ値から社員作成
		Shain shain = shainService.makeShain(request);

		//DB更新
		shainService.updateShain(shain);

		// リダイレクト
		return "redirect:/index";
	}

	@GetMapping("/delete")
	public String delete(
			@RequestParam("id") int id,
			Model model) {
		//対象データを取得
		Shain shain = shainService.findByShainId(id);

		//jspに渡す
		model.addAttribute("shain", shain);
		return "delete";
	}

	@PostMapping("/delete")
	public String delete(
			@RequestParam("id") int id) {

		//dbから削除
		shainService.deleteShain(id);

		//リダイレクト
		return "redirect:/index";
	}

}
