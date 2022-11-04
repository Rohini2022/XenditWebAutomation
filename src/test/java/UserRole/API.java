package UserRole;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class API 

{
	
	/*public static void main(String[] args) throws Exception 
	{
       // String otp = getOtpGlobe("manasasmyuktha@gmail.com", "09171646913","ADD_MOBILE_ACCOUNT");//09658061816//09658061684
       // String otp = getOtpGlobe("UFTGlobeDomain@gmail.com", "09171278198","ADD_MOBILE_ACCOUNT");//09658061816//09658061684

	//	String otp = getOtpGlobe("znk@globe.com.ph", "09171861914","ADD_WIRELINE_ACCOUNT");
		//System.out.println(otp);
	}*/

	public static String KavyaUser(String role, String grp) throws Exception
	{
		String FN = "Kavya";
		String MN = "M P";
		String LN = "P";
		String email = "zkmp@globe.com.ph";
		String result = "";
		HttpPatch post = new HttpPatch("https://edo-dev-data-engineering.globe.com.ph/ph2/lmx/rbac/api/sailpoint/lmx/employee/ztie0197");
		post.addHeader("Content-Type","application/json");
		post.addHeader("Authorization","Basic YWRtaW46YWRtaW4");
		String block = "{\"firstName\":\""+FN+"\",\"middleName\":\""+MN+"\",\"lastName\":\""+LN+"\",\"emailAddress\":\""+email+"\",\"role\":\""+role+"\",\"group\":[\""+grp+"\"]}";
		post.setEntity(new StringEntity(block));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}
//		String otp = result.split("\"role\":", 2)[1].replace("\"", "").replace("}", "");;
//		System.out.println(otp);
		//System.out.println("Result"+result);
		return result;
	}
	
	public static String FrancisUser(String role, String grp) throws Exception
	{
		String FN = "Francis";
		String MN = "Tojo";
		String LN = "Sebastian";
		String email = "zfsebastian@globe.com.ph";
		String result = "";
		HttpPatch post = new HttpPatch("https://edo-dev-data-engineering.globe.com.ph/ph2/lmx/rbac/api/sailpoint/lmx/employee/ztie0151");
		post.addHeader("Content-Type","application/json");
		post.addHeader("Authorization","Basic YWRtaW46YWRtaW4");
		String block = "{\"firstName\":\""+FN+"\",\"middleName\":\""+MN+"\",\"lastName\":\""+LN+"\",\"emailAddress\":\""+email+"\",\"role\":\""+role+"\",\"group\":[\""+grp+"\"]}";
		post.setEntity(new StringEntity(block));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}
//		String otp = result.split("\"role\":", 2)[1].replace("\"", "").replace("}", "");;
//		System.out.println(otp);
		//System.out.println("Result"+result);
		return result;
	}
	
	public static String VidhyaUser(String role, String grp) throws Exception
	{
		String FN = "Vidhya";
		String MN = "K";
		String LN = "V";
		String email = "zvkv@globe.com.ph";
		String result = "";
		HttpPatch post = new HttpPatch("https://edo-dev-data-engineering.globe.com.ph/ph2/lmx/rbac/api/sailpoint/lmx/employee/ztie0246");
		post.addHeader("Content-Type","application/json");
		post.addHeader("Authorization","Basic YWRtaW46YWRtaW4");
		String block = "{\"firstName\":\""+FN+"\",\"middleName\":\""+MN+"\",\"lastName\":\""+LN+"\",\"emailAddress\":\""+email+"\",\"role\":\""+role+"\",\"group\":[\""+grp+"\"]}";
		post.setEntity(new StringEntity(block));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}
//		String otp = result.split("\"role\":", 2)[1].replace("\"", "").replace("}", "");;
//		System.out.println(otp);
		//System.out.println("Result"+result);
		return result;
	}
	
	public static String NagaveniUser(String role, String grp) throws Exception
	{
		String FN = "Nagaveni";
		String MN = "K";
		String LN = "K";
		String email = "znk@globe.com.ph";
		String result = "";
		HttpPatch post = new HttpPatch("https://edo-dev-data-engineering.globe.com.ph/ph2/lmx/rbac/api/sailpoint/lmx/employee/ztie0202");
		post.addHeader("Content-Type","application/json");
		post.addHeader("Authorization","Basic YWRtaW46YWRtaW4");
		String block = "{\"firstName\":\""+FN+"\",\"middleName\":\""+MN+"\",\"lastName\":\""+LN+"\",\"emailAddress\":\""+email+"\",\"role\":\""+role+"\",\"group\":[\""+grp+"\"]}";
		post.setEntity(new StringEntity(block));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}
//		String otp = result.split("\"role\":", 2)[1].replace("\"", "").replace("}", "");;
//		System.out.println(otp);
		//System.out.println("Result"+result);
		return result;
	}
	
	public static String ThomasUser(String role, String grp) throws Exception
	{
		String FN = "Thomas";
		String MN = " ";
		String LN = "Kurian";
		String email = "ztkurian@globe.com.ph";
		String result = "";
		HttpPatch post = new HttpPatch("https://edo-dev-data-engineering.globe.com.ph/ph2/lmx/rbac/api/sailpoint/lmx/employee/ztie0247");
		post.addHeader("Content-Type","application/json");
		post.addHeader("Authorization","Basic YWRtaW46YWRtaW4");
		String block = "{\"firstName\":\""+FN+"\",\"middleName\":\""+MN+"\",\"lastName\":\""+LN+"\",\"emailAddress\":\""+email+"\",\"role\":\""+role+"\",\"group\":[\""+grp+"\"]}";
		post.setEntity(new StringEntity(block));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}
//		String otp = result.split("\"role\":", 2)[1].replace("\"", "").replace("}", "");;
//		System.out.println(otp);
		//System.out.println("Result"+result);
		return result;
	}
	public static String ManasaUser(String role, String grp) throws Exception
	{
		String FN = "Manasa";
		String MN = " ";
		String LN = "SangiReddy";
		String email = "zmsangireddy@globe.com.ph";
		String result = "";
		HttpPatch post = new HttpPatch("https://edo-dev-data-engineering.globe.com.ph/ph2/lmx/rbac/api/sailpoint/lmx/employee/ztie0201");
		post.addHeader("Content-Type","application/json");
		post.addHeader("Authorization","Basic YWRtaW46YWRtaW4");
		String block = "{\"firstName\":\""+FN+"\",\"middleName\":\""+MN+"\",\"lastName\":\""+LN+"\",\"emailAddress\":\""+email+"\",\"role\":\""+role+"\",\"group\":[\""+grp+"\"]}";
		post.setEntity(new StringEntity(block));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}
//		String otp = result.split("\"role\":", 2)[1].replace("\"", "").replace("}", "");;
//		System.out.println(otp);
		//System.out.println("Result"+result);
		return result;
	}
}
