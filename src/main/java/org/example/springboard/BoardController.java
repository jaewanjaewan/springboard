package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller //자바에서의 빈등록, 서블릿역할을한다고 생각하면됨(필수)
@RequestMapping("/board")
public class BoardController {
    @Autowired //자동으로 주소값이 들어오게한다
    private BoardService service; //여기에 들어갈수있는 빈은 유일해야함

    @GetMapping("/list")
    public void list(Model model){ //void일경우 폴더구조도 맞춰줘야됨
        model.addAttribute("list", service.selBoardList()); /*req.setAttribute랑 비슷*/
    }

    @GetMapping("/detail")
    public void detail(Model model, BoardEntity entity){
        service.updBoardHitsUp(entity);
        model.addAttribute("data", service.selBoard(entity));
    }

    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write") /*controller -> service -> mapper*/
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr){
        System.out.println(entity);
        int result = service.insBoard(entity);
        if(result == 0){
            reAttr.addFlashAttribute("msg", "글 등록에 실패하였습니다"); /*addFlashAttribue는 request에 담아서 보내준다*/
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/del")
    public String delProc(BoardEntity entity, RedirectAttributes reAttr){
        int result = service.delBoard(entity);
        if(result == 0){
            reAttr.addAttribute("iboard", entity.getIboard());
            reAttr.addFlashAttribute("msg", "글 삭제에 실패하였습니다");
            return "redirect:/board/detail";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/mod")
    public void mod(Model model, BoardEntity entity){
        model.addAttribute("data", service.selBoard(entity));
    }

    @PostMapping("/mod")
    public String modProc(BoardEntity entity, RedirectAttributes reAttr){
        int result = service.updBoard(entity);
        if(result == 0){
            reAttr.addFlashAttribute("msg", "글 수정에 실패하였습니다.");
            return "redirect:/board/mod?iboard="+entity.getIboard();
        }
        return "redirect:/board/detail?iboard="+entity.getIboard();
    }
}
