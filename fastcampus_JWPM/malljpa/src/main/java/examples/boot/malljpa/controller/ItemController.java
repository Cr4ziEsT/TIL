package examples.boot.malljpa.controller;

import examples.boot.malljpa.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String GetItemList(ModelMap modelMap) throws Exception{
        Pageable pageable = PageRequest.of(0, 5);
        modelMap.addAttribute("items", itemService.getMainItemList(pageable));
        return "items/list";
    }
}
