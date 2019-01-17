import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class test {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/foreign-exchange-rates").get();
		String title = doc.title();
		System.out.println(title);
		
		String time = doc.select("span[id=LbQuoteTime]").text();
		String[] a = doc.select("a[href*=/personal/deposit/rate/forex/exchange-rate-chart?]").text().split(" ");
		String[] buy=doc.select("td[data-name=即期買入匯率]").text().split(" ");
		String[] sell=doc.select("td[data-name=即期賣出匯率]").text().split(" ");
		System.out.println(time);
		
		//美元匯率
		Map<String,String> USD = new HashMap<String,String>();
		USD.put("time", time);
		USD.put("Currency", a[0]);
		USD.put("buy", buy[0]);
		USD.put("sell", sell[0]);
		JSONObject jsonObjectUSD = new JSONObject(USD);
		System.out.println(jsonObjectUSD);
		
		//日圓匯率
		Map<String,String> JPY = new HashMap<String,String>();
		JPY.put("time", time);
		JPY.put("Currency", a[3]);
		JPY.put("buy", buy[3]);
		JPY.put("sell", sell[3]);
		JSONObject jsonObjectJPY = new JSONObject(JPY);
		System.out.println(jsonObjectJPY);
		
		//歐元匯率
		Map<String,String> EUR = new HashMap<String,String>();
		EUR.put("time", time);
		EUR.put("Currency", a[4]);
		EUR.put("buy", buy[4]);
		EUR.put("sell", sell[4]);
		JSONObject jsonObjectEUR = new JSONObject(EUR);
		System.out.println(jsonObjectEUR);
		
		//英鎊匯率
		Map<String,String> GBP = new HashMap<String,String>();
		GBP.put("time", time);
		GBP.put("Currency", a[7]);
		GBP.put("buy", buy[7]);
		GBP.put("sell", sell[7]);
		JSONObject jsonObjectGBP = new JSONObject(GBP);
		System.out.println(jsonObjectGBP);
		
		//人民幣匯率
		Map<String,String> CNY = new HashMap<String,String>();
		CNY.put("time", time);
		CNY.put("Currency", a[1]);
		CNY.put("buy", buy[1]);
		CNY.put("sell", sell[1]);
		JSONObject jsonObjectCNY = new JSONObject(CNY);
		System.out.println(jsonObjectCNY);
		
		
		
		/*System.out.println("幣別\t\t買入\t賣出");
		for(int i = 0;i<buy.length;i++) {
			System.out.println(a[i]+"\t"+buy[i]+"\t"+sell[i]);
		}*/
		
	}

}
