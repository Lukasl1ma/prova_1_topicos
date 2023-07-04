package br.edu.univas.si7.topicos.process.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.process.dto.ProcessDto;
import br.edu.univas.si7.topicos.process.service.ProcessService;

@RestController

@RequestMapping("/process")
public class ProcessController {

	@Autowired
	private ProcessService service;

	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<ProcessDto> getAllProducts() {
		return service.findAll();
	}

	@GetMapping("/{code}")
	public ResponseEntity<ProcessDto> getProcessById(@PathVariable String code) {
		ProcessDto dto = new ProcessDto(service.findById(code));
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody @Valid ProcessDto process) {
		service.createProcess(process);
	}

	@PutMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProcess(@RequestBody @Valid ProcessDto dto, @PathVariable String code) {
		service.updateProcess(service.toEntity(dto), code);
	}

	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProcess(@PathVariable String code) {
		service.deleteProcess(code);
	}

}
