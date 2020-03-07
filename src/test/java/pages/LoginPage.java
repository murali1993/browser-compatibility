package pages;

import java.util.HashMap;
import java.util.Map;

import pageobjects.LoginObj;
import utils.Utils;

public class LoginPage extends BasePage {

	Map<String, String> s2bUserMap = new HashMap<String, String>();
	Map<String, String> s2bColUser1Map = new HashMap<String, String>();
	Map<String, String> s2bColUser2Map = new HashMap<String, String>();
	Map<String, String> s2bColUser3Map = new HashMap<String, String>();

	public Map getCredentials(String role) {
		if (role.equals("s2bUser")) {
			s2bUserMap.put("userName", "user000015");
			s2bUserMap.put("group", "uatsgee1");
			return s2bUserMap;
		} else if((role.equals("s2bCol1User"))){
			s2bColUser1Map.put("userName", "NTBUSER01");
			s2bColUser1Map.put("group", "HKSEPCO1");
			return s2bColUser1Map;
		}else if((role.equals("s2bCol2User"))){
			s2bColUser2Map.put("userName", "NTBUSER02");
			s2bColUser2Map.put("group", "HKSEPCO1");
			return s2bColUser2Map;
			
		}else{
			s2bColUser3Map.put("userName", "NTBUSER03");
			s2bColUser3Map.put("group", "HKSEPCO1");
			return s2bColUser3Map;
		}
	}

	public void launchUrl() {
		driver.get(Utils.getValue("launchUrl"));
		ThreadWait(2000);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	public void loginToS2B(String userRole) throws InterruptedException {

		LoginObj obj = new LoginObj(driver);
		Map<String, String> loginMap = getCredentials(userRole);
		launchUrl();

		obj.getUserID().sendKeys(loginMap.get("userName"));
		obj.getGroupID().sendKeys(loginMap.get("group"));

		// obj.getRemCk().click();
		obj.getContBtn().click();
		obj.getPassword().sendKeys("dummyaaaa");
		Thread.sleep(5000);
		obj.getLoginBtn().click();
		implicitWait();
	}

}