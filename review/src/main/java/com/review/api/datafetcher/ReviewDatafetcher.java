package com.review.api.datafetcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.review.api.model.Review;
import com.review.api.model.Show;

@DgsComponent
public class ReviewDatafetcher {

	@DgsEntityFetcher(name = "Show")
	public Show getEntity(Map values) {
		return new Show(Integer.parseInt(String.valueOf(values.get("id"))) );
	}

	@DgsData(parentType = "Show", field = "reviews")
	public List<Review> getReviewForShow(DgsDataFetchingEnvironment dfe) {
		Show show = dfe.getSource();
		List<Review> reviewList = getReview(show.getId());
		return reviewList;
	}

	@DgsData(parentType = "Query", field = "reviews")
	public List<Review> getReview(DgsDataFetchingEnvironment dfe) {
		List<Review> reviewList = getReview(1);
		return reviewList;
	}

	private List<Review> getReview(int id) {
		Review review1 = new Review();
		review1.setStartRating(1);
		List<Review> reviewList = new ArrayList<>();
		reviewList.add(review1);
		
		Review review2 = new Review();
		review2.setStartRating(2);
		List<Review> reviewList2 = new ArrayList<>();
		reviewList2.add(review2);
		
		Review review3 = new Review();
		review3.setStartRating(3);
		List<Review> reviewList3 = new ArrayList<>();
		reviewList3.add(review3);
		
		Review review4 = new Review();
		review4.setStartRating(4);
		List<Review> reviewLis4 = new ArrayList<>();
		reviewLis4.add(review4);
		Map<Integer, List<Review>> map=new HashMap<>();
		map.put(1, reviewList);
		map.put(2, reviewList2);
		map.put(3, reviewList3);
		map.put(4, reviewLis4);
		return map.get(id);
	}
}
