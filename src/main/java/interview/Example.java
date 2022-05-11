package interview;
public class Example {
	
	public static void main(String[] args) {
		/*
		1. Refactor BadExample test (under needRefactoring package)

		2. You are given a requirement user can create a new account with email, username and password
		(all are required fields)
		And if users fail to provide any of the fields, the error message should be displayed on UI
		and the request shouldn't be successful.
		Please explain how would you automate the coverage for the above requirement?

		UI link: https://superlative-fox-61a6f8.netlify.app/register

		API spec: https://github.com/gothinkster/realworld/blob/main/api/Conduit.postman_collection.json
		POST request
		-> URL: https://conduit.productionready.io/api/users
		-> raw body: {"user":{"email":"{{EMAIL}}", "password":"{{PASSWORD}}", "username":"{{USERNAME}}"}}
		-> headers:
			Content-Type:application/json
			X-Requested-With:XMLHttpRequest


		4. Validate user can favorite the article and is displayed in favourite
		UI flow -> login -> click on global Feed -> favourite one or more articles ->
		click on the user profile pic to navigate to articles -> click on favourite articles


		 */
	}
}
