package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller //자바에서의 빈등록, 서블릿역할을한다고 생각하면됨
@RequestMapping("/board")
public class BoardController {
    @Autowired //자동으로 주소값이 들어오게한다
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model){
        List<BoardEntity> list = service.selBoardList();
        model.addAttribute("list", list); /*req.setAttribute랑 비슷*/
    }

    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write") /*controller -> service -> mapper*/
    public String writeProc(BoardEntity entity){
        System.out.println(entity);
        int result = service.insBoard(entity);
        return "redirect:/board/list";
    }
}
