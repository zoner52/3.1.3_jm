package com.crud.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.crud.springboot.model.Role;
import com.crud.springboot.model.User;
import com.crud.springboot.service.RoleService;
import com.crud.springboot.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public AdminController() {
    }

    @GetMapping("/admin/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", roleService.getAllRoles());
        return "/admins-page/add";
    }

    @GetMapping("/admin")
    public String printUsers(Model model) {
        model.addAttribute("user", userService.getUsers());
        return "/admin";
    }

    @PostMapping("/admin")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam(value = "select_role", required = false) String[] roles) {
        Set<Role> role = new HashSet<>();
        role.add(roleService.getAllRoles().get(1));
        for (String s : roles) {
            if (s.equals("ROLE_ADMIN")) {
                role.add(roleService.getAllRoles().get(0));
            }
        }
        user.setRoles(role);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String editUser(@PathVariable("id") long id,
                           Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/admins-page/edit";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userService.updateUser(user, id);
        return "redirect:/admin";
    }
}
