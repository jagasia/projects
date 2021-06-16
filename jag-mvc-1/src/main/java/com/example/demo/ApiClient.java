package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Branch;

@FeignClient(value = "instantwebtools-api", url = "http://third-env.eba-mt8mpdcn.ap-south-1.elasticbeanstalk.com/")
public interface ApiClient {

	
	@GetMapping("/branch")
	public List<Branch> read();
	
	@GetMapping("/branch/{bid}")
	public Branch read(@PathVariable("bid") String bid);

	@PostMapping("/branch")
	public Branch create(@RequestBody Branch branch);

	@PutMapping("/branch")
	public Branch update(@RequestBody Branch branch);
	
	@DeleteMapping("/branch/{bid}")
	public int delete(@PathVariable("bid") String bid);
	
}
