package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.model.Review;

@Service
public class ReviewService {

	public List<Review> getReviewList(List<Integer> idList) {
		if (CollectionUtils.isEmpty(idList)) {
			List<Review> review = new ArrayList<>();
			idList.forEach(ele -> {

				review.add(getReview(ele));
			});

			return review;

		}

		return Collections.emptyList();
	}

	private Review getReview(Integer id) {
		Review review1 = new Review();
		review1.setStartRating(1);

		return review1;
	}

}
