package com.vxpx.shouldgo;

import java.util.ArrayList;
import java.util.List;

public class PaginationHelper {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(PaginationHelper.class);

	public static void main(String[] args) {

		int rowCount = 50000; // Size of the list
		int pageSize = 20;

		int pageNo = 50;

		// int pageCount = CommonUtils.isEmpty(pageSize) ? 0 : rowCount /
		// pageSize;
		int pageCount = pageSize != 0 ? 0 : rowCount / pageSize;

		System.out.println("rowCount :: " + String.valueOf(rowCount));
		System.out.println("pageSize :: " + String.valueOf(pageSize));

		final int startRow = (pageNo - 1) * pageSize;

		List<Integer> dimNumberList = new ArrayList<Integer>();

		for (int i = 0; i < 50000; i++) {
			dimNumberList.add((int) (Math.random() * 50000));
		}

		List<List<Integer>> batchList = getBatches(dimNumberList, 1000);
		
		while (batchList != null) {
			
		}
		
		System.out.println(batchList.size());
		
		System.out.println(getListIndex(pageSize,pageNo,1000));
		
	}

	public static <T> List<List<T>> getBatches(List<T> collection, int batchSize) {
		int i = 0;
		List<List<T>> batches = new ArrayList<List<T>>();
		while (i < collection.size()) {
			int nextInc = Math.min(collection.size() - i, batchSize);
			List<T> batch = collection.subList(i, i + nextInc);
			batches.add(batch);
			i = i + nextInc;
		}

		return batches;
	}

	
	public static int getListIndex(int pageSize, int currentPage, int batchSize) {
		
		int listIndex = 0;
		
		if (batchSize != 0) {
			listIndex =  (pageSize * currentPage)/batchSize;
		}
		
		return listIndex;
	}
}
