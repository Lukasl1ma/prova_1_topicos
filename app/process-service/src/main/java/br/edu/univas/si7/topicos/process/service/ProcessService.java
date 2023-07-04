package br.edu.univas.si7.topicos.process.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.topicos.process.dto.ProcessDto;
import br.edu.univas.si7.topicos.process.entity.ProcessEntity;
import br.edu.univas.si7.topicos.process.exception.ProcessException;
import br.edu.univas.si7.topicos.process.exception.ObjectNotFoundException;
import br.edu.univas.si7.topicos.process.repository.ProcessRepository;

@Service
public class ProcessService {

	private ProcessRepository repo;

	@Autowired
	public ProcessService(ProcessRepository repo) {
		this.repo = repo;
	}

	public List<ProcessDto> findAll() {
		return repo.findAll().stream().map(p -> new ProcessDto(p)).collect(Collectors.toList());
	}

	public ProcessEntity findById(String id) {
		Optional<ProcessEntity> obj = repo.findById(id);
		ProcessEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Process " + id + " not found"));
		return entity;
	}

	public void createProcess(ProcessDto process) {
		repo.save(toEntity(process));
	}

	public ProcessEntity toEntity(ProcessDto process) {
		return new ProcessEntity(process.getCode(), process.getResponsable(), process.getLastReviewCode(),
				process.getDurationInMinute(), process.getMeanCost(), process.getActive());
	}

	public void updateProcess(ProcessEntity process, String id) {
		if (id == null || process == null || !id.equals(process.getCode())) {
			throw new ProcessException("Invalid process id.");
		}
		ProcessEntity existingObj = findById(id);
		updateData(existingObj, process);
		repo.save(existingObj);
	}

	private void updateData(ProcessEntity existingObj, ProcessEntity obj) {
		existingObj.setResponsable(obj.getResponsable());
		existingObj.setLastReviewCode(obj.getLastReviewCode());
		existingObj.setDurationInMinute(obj.getDurationInMinute());
		existingObj.setMeanCost(obj.getMeanCost());
		existingObj.setActive(obj.getActive());
	}

	public void deleteProcess(String id) {
		if (id == null) {
			throw new ProcessException("Process code can not be null.");
		}

		ProcessEntity obj = findById(id);
		repo.delete(obj);

	}

}
