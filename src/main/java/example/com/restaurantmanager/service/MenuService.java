package example.com.restaurantmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.com.restaurantmanager.exception.UserNotFoundException;
import example.com.restaurantmanager.model.Menu;
import example.com.restaurantmanager.repo.MenuRepo;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepo menuRepo;

    @Autowired
    public MenuService(MenuRepo menuRepo){
        this.menuRepo = menuRepo;
    }
    public Menu addMenu(Menu menu){
        return menuRepo.save(menu);
    }
    public List<Menu> findAllMenu(){
        return menuRepo.findAll();
    }
    public Menu updateMenu(Menu menu){
        return menuRepo.save(menu);
    }
    public Menu findMenuById(Long id){
        return menuRepo.findMenuById(id)
                .orElseThrow(()->new UserNotFoundException("Menu by id "+ id + "was not foud"));
    }
    public void deleteMenu(Long id){
        menuRepo.deleteById(id);
    }
}
