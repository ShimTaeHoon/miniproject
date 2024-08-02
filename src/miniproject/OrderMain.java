package miniproject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderMain {
	
	static int orderNo = 1;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> cus = new ArrayList<>();
		
		
		FileOutputStream fos = new FileOutputStream("order.txt");
		OutputStreamWriter bos = new OutputStreamWriter(fos);

		System.out.println("1. 상품 주문하기");
		System.out.println("2. 전체 주문 이력 보기");
		System.out.println("3. 고객별 주문 이력 보기");
		System.out.println("4. 특정날짜에 들어온 주문이력 보기");
		System.out.println("5. 끝내기");
		
		while(true) {
			
			System.out.print("옵션을 선택하세요: ");
			String option = scanner.nextLine();
			
			if(option.equals("1")) {
				System.out.print("고객명: ");
				String cusName = scanner.nextLine();
				
				System.out.print("제품명: ");
				String proName = scanner.nextLine();

				System.out.print("제품의수량: ");
				int proQuan = scanner.nextInt();

				System.out.print("제품의가격: ");
				int price = scanner.nextInt();
				
				LocalDateTime curDateTime= LocalDateTime.now();
				DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDate = curDateTime.format(formatter);
//				cus.add(new Customer(orderNo++, cusName, proName, proQuan, price, formatDate));
				
				scanner.nextLine();
				
				Customer order = new Customer(orderNo++, cusName, proName, proQuan, price, formatDate);
				cus.add(order);
				bos.write(order.toString() + '\n');
				bos.flush();
				
				System.out.println(order.toString());
				
				System.out.println("주문이 완료되었습니다!");
			
			} else if(option.equals("2")) {
				System.out.println("2번 테스트");
			} else if(option.equals("5")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			
		}

	}

}

class Customer {

	int orderNo;
	String cusName;
	String proName;
	int orderQuan;
	int price;
	String date;
	
	public Customer(int orderNo, String cusName, String proName, int orderQuan, int price, String date) {
		super();
		this.orderNo = orderNo;
		this.cusName = cusName;
		this.proName = proName;
		this.orderQuan = orderQuan;
		this.price = price;
		this.date = date;
	}
	
	public Customer(String cusName, String proName, int orderQuan, int price) {
		this.cusName = cusName;
		this.proName = proName;
		this.orderQuan = orderQuan;
		this.price = price;
		
	}

	@Override
	public String toString() {
		return "주문번호: " + orderNo + ", 고객명: " + cusName + ", 제품명: " + proName + ", 주문수량: "
				+ orderQuan + ", 가격: " + price + ", 주문일시: " + date + "]";
	}

}