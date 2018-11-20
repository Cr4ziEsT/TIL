package examples.boot.malljpa.service;

import examples.boot.malljpa.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
//    Page<Item> getItemListSearch(ItemSearch itemSearch);
    Page<Item> getMainItemList(Pageable pageable);
    Item getItem(Long itemId);
}
