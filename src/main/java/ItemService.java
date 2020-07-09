import java.util.List;

public class ItemService {
    ItemDAO itemDAO = new ItemDAO();

    public Item save(Item item){
        return itemDAO.save(item);
    }

    public Item update(Item item){
        return itemDAO.update(item);
    }

    public void delete(Long id){
        itemDAO.delete(id);
    }

    public Item findById(Long id){
        return itemDAO.findById(id);
    }

    public List getAllItems(){
        return itemDAO.getAllItems();
    }
}
