package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;

@RestController
public class ReviewByIdController {

	@Autowired
	ReviewService reviewService;

	public List<Review> getReview(List<Integer> idList) {

		return reviewService.getReviewList(idList);

	}

}
