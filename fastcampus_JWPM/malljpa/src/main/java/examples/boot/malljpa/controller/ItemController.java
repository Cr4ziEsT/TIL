package examples.boot.malljpa.controller;

import examples.boot.malljpa.domain.Item;
import examples.boot.malljpa.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String GetItemList(ModelMap modelMap) throws Exception{
        List<Item> items = itemService.getItemList();
        modelMap.addAttribute("items", items);
        return "items/list";
    }

    @GetMapping("/{itemId}")
    public String GetItemDetail(@PathVariable(value = "itemId")Long itemId, ModelMap modelMap){
        Item item = itemService.getItem(itemId);
        modelMap.addAttribute("item", item);
        return "items/detail";
    }
}
