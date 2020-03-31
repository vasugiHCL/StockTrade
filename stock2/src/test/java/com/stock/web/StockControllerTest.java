package com.stock.web;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stock.dto.MyStockdto;
import com.stock.dto.PurchaseResponseDto;
import com.stock.dto.StockDto;
import com.stock.dto.StockResponse;
import com.stock.entity.MyStock;
import com.stock.entity.Stock;
import com.stock.exception.UserIdNotFoundException;
import com.stock.service.StockService;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {
	
	@Mock
	StockService stockService;
	
	@InjectMocks
	StockController stockController;
	
	Stock stock=null;
	StockDto stockDto=null;
	StockResponse response=null;
	
	MyStock mystock=null;
	MyStockdto mystockDto=null;
	PurchaseResponseDto responsedto=null;
	
	
	
		
	@Test
	public void testGetStockByName() {
		stock=new Stock();
		stock.setStockId(100L);
		stock.setStockName("AXIS");
		
		
		
		stockDto=new StockDto();
		stockDto.setStockId(100L);
		stockDto.setStockName("AXIS");
		
		
		Mockito.when(stockService.getStocks("AXIS")).thenReturn(stockDto);
		ResponseEntity<StockResponse> stock=stockController.getStockbyStockName("AXIS");
		assertEquals(stock.getStatusCode(),HttpStatus.OK );
	}
	
	@Test
	public void testStockById()throws UserIdNotFoundException  {
		
		mystock=new MyStock();
		mystock.setUserId(100L);
		
		mystockDto=new MyStockdto();
		mystockDto.setUserId(100L);
		
		Long userId=100L;
		
		Mockito.when(stockService.getMyStock(mystock)).thenReturn(mystockDto);
		ResponseEntity<List<MyStockdto>> stock=stockController.getStockByuserId(100L);
		assertEquals(stock.getStatusCode(), HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
