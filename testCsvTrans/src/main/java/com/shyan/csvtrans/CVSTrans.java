package com.shyan.csvtrans;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.shyan.model.vo.TestVO;

public class CVSTrans {

	public static void main(String[] args) {

		// jackson version 2.12.2
		try {
			String fileName = "J:\\Program\\workspace_playground\\testCsvTrans\\src\\main\\resources\\test.csv";
			File csvFile = new File(fileName);
			CsvMapper mapper = new CsvMapper();
			CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
			MappingIterator<TestVO> it = mapper.readerFor(TestVO.class).with(schema).readValues(csvFile);
			List<TestVO> list = new LinkedList<>();
			
			while (it.hasNext()) {
				list.add(it.next());
			}
			
			list.forEach(vo -> System.out.println(vo.toString()));
			
			// 把String的json轉到VO key必須完全一樣
//			MappingIterator<Map<String,String>> it = mapper.readerFor(Map.class).with(schema).readValues(csvFile);
//			List<Map<String, String>> list = new LinkedList<>();
//			
//			while (it.hasNext()) {
//				list.add(it.next());
//			}
//			
//			ObjectMapper omapper = new ObjectMapper();
//			List<TestVO> voList = omapper.readValue(omapper.writeValueAsString(list), new TypeReference<List<TestVO>>() {});
//			
//			voList.forEach(vo -> System.out.println(vo));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
