package com.shows.api.datafetcher;

import java.util.List;
import java.util.stream.Collectors;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.shows.api.model.Show;

@DgsComponent
public class ShowsDatafetcher {

	private final List<Show> shows = List.of(new Show("Stranger Things", 2016, 1), new Show("Ozark", 2017, 2),
			new Show("The Crown", 2016, 3), new Show("Dead to Me", 2019, 4),
			new Show("Orange is the New Black", 2013, 5));

	@DgsData(parentType = "Query", field = "shows")
	public List<Show> shows(@InputArgument String titleFilter) {
		if (titleFilter == null) {
			return shows;
		}

		return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
	}
}
