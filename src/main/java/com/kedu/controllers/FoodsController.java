package com.kedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.FoodsDAO;
import com.kedu.dto.FoodsDTO;

@Controller
@RequestMapping("/food")
public class FoodsController {
	@Autowired
	private FoodsDAO dao;

	@RequestMapping("/insert")
	public String insert(FoodsDTO dto) throws Exception {
		dao.insert(dto);

		return "redirect:home";
	}

	@RequestMapping("/delete")
	public String delete(FoodsDTO dto)throws Exception {
		dao.delete(dto.getSeq());

		return "list";
	}
	@RequestMapping("/update")
	public String update(FoodsDTO dto) throws Exception{
		dao.update(dto);
		return "list";
	}	
	@RequestMapping("/list")
	public String list(Model model) {
		List<FoodsDTO> list = dao.selectAll();
		model.addAttribute("list", list ); //jsp로 보내는 역할을 담당하나다.

		return "list";
	}
}
