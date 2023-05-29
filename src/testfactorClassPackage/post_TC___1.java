package testfactorClassPackage;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import comaFunctionPackage.CommonAPIFunctions;
import comaFunctionPackage.CommonUtilityFunctions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reqRepoPackage.Re_Po_Repository;
public class post_TC___1
{  @Test
	public static void execute() throws IOException 
	{       
	    for(int i=0;i<5;i++)
		{
		int res_statuscode=CommonAPIFunctions.res_statusCode(Re_Po_Repository.base_URI(),
				Re_Po_Repository.post_req_tc1(),Re_Po_Repository.post_resource());
	    if( res_statuscode == 201 ) 
	    {
    	String res_responseBody=CommonAPIFunctions.res_responseBody(Re_Po_Repository.base_URI(),
    			Re_Po_Repository.post_req_tc1(),Re_Po_Repository.post_resource());	
	    post_TC___1.validator(res_responseBody, res_statuscode);
	    CommonUtilityFunctions.evidencecreator("Post_TC1",Re_Po_Repository.post_req_tc1(),res_responseBody);
	    break;
	    }
	    else
	    {
	    	System.out.println("Correct status code is not found hence retrying the API");
	    }
		}
		}		
		public static void validator(String res_responseBody,int res_statuscode) throws IOException 
	{
		//parse	the response body
		JsonPath jsp=new JsonPath(res_responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
	//	String res_id=jsp.getString("id");
	//	String res_createdAt=jsp.getString("createdAt");
		//System.out.println(res_name);
		System.out.println(res_name);
		System.out.println(res_job);
	//	System.out.println(res_id);
	//	System.out.println(res_createdAt);

		//request body
		JsonPath jspreq=new JsonPath(Re_Po_Repository.post_req_tc1());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
		
				//validate response body 
		Assert.assertEquals(res_statuscode,201);
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
//		Assert.assertNotNull(res_id,"15");
//		Assert.assertNotNull(res_createdAt,"2023-05-05T08:28:13.425Z");

	}
}







