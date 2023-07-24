package com.epico.efficent.adapters.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralBasePaths.BUDGET)
public class BudgetController
{
  @GetMapping("")
  public String budget() {
    return "Budget";
  }

  @PostMapping("")
  public String budgetPost() {
    return "Budget Post";
  }

  @DeleteMapping("")
  public String budgetDelete() {
    return "Budget Delete";
  }

  @PutMapping("")
  public String budgetPut() {
    return "Budget Put";
  }

  @GetMapping("test")
  public String budgetTest() {
    return "Budget Test";
  }

  @GetMapping("describe")
  public String budgetDescribe() {
    return "Budget Describe";
  }

  @PostMapping("add")
  public String budgetAdd() {
    return "Budget Add";
  }
}
