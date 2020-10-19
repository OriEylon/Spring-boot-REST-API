package io.swagger.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepo;

    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        itemRepo.findAll().forEach(list::add);
        return list;
    }

    public int deleteItem(Integer item_no) {
        Item toDelete = itemRepo.findByItemNo(item_no);
        if (toDelete == null)
            return 1;
        itemRepo.delete(toDelete);
        return 0;
    }

    public int addItem(Integer item_no, String name, Integer amount) {
        Item i = itemRepo.findByItemNo(item_no);
        if (i != null)
            return 1;

        Item newitem = new Item(item_no, name, amount);
        itemRepo.save(newitem);
        return 0;
    }

    public Item getItem(Integer item_no) {
        return itemRepo.findByItemNo(item_no);
    }

    public int withrawlItem(Integer item_no, Integer amount) {
        Item i = itemRepo.findByItemNo(item_no);
        if (i == null)
            return 1;
        if (amount > i.getAmount())
            return 2;
        i.setAmount(i.getAmount() - amount);
        itemRepo.save(i);
        return 0;
    }

    public int depositItem(Integer item_no, Integer amount) {
        Item i = itemRepo.findByItemNo(item_no);
        if (i == null)
            return 1;

        i.setAmount(i.getAmount() + amount);
        itemRepo.save(i);
        return 0;
    }

}
