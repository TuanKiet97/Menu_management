package example.com.restaurantmanager.controller;

import example.com.restaurantmanager.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import example.com.restaurantmanager.model.Menu;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Menu>> getAllMenu() {
        List<Menu> menus = menuService.findAllMenu();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") Long id) {
        Menu menu = menuService.findMenuById(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Menu> addEmployee(@RequestBody Menu menu) {
        Menu newMenu = menuService.addMenu(menu);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
        Menu updateMenu = menuService.updateMenu(menu);
        return new ResponseEntity<>(updateMenu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
