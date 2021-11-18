package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.contract_dto.ContractDetailDto;
import com.codegym.casestudy.model.contract.AttachService;
import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import com.codegym.casestudy.service.contract.IContractService;
import com.codegym.casestudy.service.contract_detail.IContractDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {

    @Autowired
    IContractDetailService iContractDetailService;

    @Autowired
    IContractService iContractService;

    @ModelAttribute("attachServiceList")
    public List<AttachService> getAttachServiceList() {
        return iContractDetailService.findAllAttachService();
    }

    @ModelAttribute("contractList")
    public List<Contract> getContractList() {
        return iContractService.findAll();
    }

    @GetMapping({""})
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {

        Page<ContractDetail> contractDetailList = iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetailList", contractDetailList);
        return "contract_detail/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract_detail/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "/contract_detail/create";
        }

        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Added new contractDetail have successfully");
        return "redirect:/contractDetail";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Optional<Integer> id, Model model) {
        ContractDetail contractDetail = iContractDetailService.findById(id.get());
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        BeanUtils.copyProperties(contractDetail, contractDetailDto);
        model.addAttribute("contractDetailDto", contractDetailDto);
        return "/contract_detail/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "/contract_detail/edit";
        }

        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        iContractDetailService.save(contractDetail);
        return "redirect:/contractDetail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer> id) {
        iContractDetailService.removeById(id.get());
        return "redirect:/contractDetail";
    }


}
