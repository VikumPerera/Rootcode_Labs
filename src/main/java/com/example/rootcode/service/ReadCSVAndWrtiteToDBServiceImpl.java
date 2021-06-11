package com.example.rootcode.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rootcode.entity.CountryCode;
import com.example.rootcode.entity.GDP;
import com.example.rootcode.repository.CountryCodeRepository;
import com.example.rootcode.repository.GDPRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class ReadCSVAndWrtiteToDBServiceImpl implements ReadCSVAndWrtiteToDBService {
	
	final private String file1 = "All country GDP Dataset - gdp_csv.csv";
	final private String file2 = "Country code Alpha-2 Alpha-3 conversion dataset - Sheet1.csv";

	@Autowired
	private GDPRepository gDPRepository;
	
	@Autowired
	private CountryCodeRepository countryCodeRepository;

	@Override
	public String saveDataToDB(String filename) {
		CSVReader reader;
		String[] lineInArray;
		try {
			
			switch (filename) {
				case file1:
					reader = new CSVReader(new FileReader("src/main/resources/"+filename));
					reader.readNext(); // this will skip the first line(Header)
					
					if (gDPRepository.findGDPEmptyOrNot() > 0) {
						gDPRepository.deleteAll();
					}

					while ((lineInArray = reader.readNext()) != null) {
						GDP gdp = new GDP();
						gdp.setCountry(lineInArray[0]);
						gdp.setAlpha3(lineInArray[1]);
						gdp.setYear(Integer.parseInt(lineInArray[2]));
						gdp.setValue(Double.parseDouble(lineInArray[3]));
						gDPRepository.save(gdp);
					}
					break;
				case file2:
					reader = new CSVReader(new FileReader("src/main/resources/"+filename));
					reader.readNext(); // this will skip the first line(Header)
					
					if (countryCodeRepository.findCountryCodeEmptyOrNot() > 0) {
						countryCodeRepository.deleteAll();
					}
					
					while ((lineInArray = reader.readNext()) != null) {
						CountryCode countryCode = new CountryCode();
						countryCode.setCountry(lineInArray[0]);
						countryCode.setAlpha2(lineInArray[1]);
						countryCode.setAlpha3(lineInArray[2]);
						countryCode.setNumeric_value(Integer.parseInt(lineInArray[3]));
						countryCodeRepository.save(countryCode);
					}
					break;
				
				default:
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Data Saved Successfully...";

	}

}
