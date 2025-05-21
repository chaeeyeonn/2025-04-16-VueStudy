package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면 변경 => forward: request(Model) 전송
// return "폴더/파일명"
// sendRedirect => 이미 만들어진 화면으로 이동
@Controller
public class RecipeController {
	@GetMapping("recipe/list.do")
	public String recipe_list()
	{
		return "recipe/list";
	}

	@GetMapping("recipe/detail.do")
	public String recipe_detail()
	{
		return "recipe/detail";
	}
}
