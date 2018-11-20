package examples.boot.malljpa.service;

import examples.boot.malljpa.domain.Item;
import examples.boot.malljpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Item> getMainItemList(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Item getItem(Long itemId) {
        return itemRepository.getItem(itemId);
    }
}
