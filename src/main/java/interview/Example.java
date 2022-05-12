package interview;
public class Example {
	
	public static void main(String[] args) {
		/*

		This project contains the base framework of API and E2E testing.
		Also, some String utils to generate random strings are included.

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


		3. Requirement: Verify the user can't publish article with the same title.

		UI -> Once you sign in (user: interview@start.com/password), you can click on "New Post" to create a new article

		POST request:
		-> URL: https://conduit.productionready.io/api/articles
		-> Request body: {"article":{"title":"How to train your dragon", "description":"Ever wonder how?", "body":"Very carefully.", "tagList":["training", "dragons"]}}
		-> headers:
			Content-Type:application/json
			X-Requested-With:XMLHttpRequest
			Authorization:Token {{token}}


		API spec: https://github.com/gothinkster/realworld/blob/main/api/Conduit.postman_collection.json
		User Details: email/pwd is interview@start.com/password

		4. User can update their profile and change the email address.
		- If the email already exists, it should not allow the user to update

		PUT request:
		-> URL: https://conduit.productionready.io/api/user
		-> Request body: {"user":{"email":"{{EMAIL}}"}}
		-> headers:
			Content-Type:application/json
			X-Requested-With:XMLHttpRequest
			Authorization:Token {{token}}

		5. Validate all your favourite articles displayed in "Favourite Articles" tab
		Flow:
		- After login (email/pwd is interview@start.com/password), you could click on the "Global Feed" tab to view all the articles.
		- The article where _heart_ is highlighted in green are favourite ones
		- If you want to add to your favourite, click on the "heart" button. If you click again, it removes it from favourite.

		- How to view the favourite articles:
		- After login (email/pwd is interview@start.com/password) -> click on the user profile pic, then click on "Favourite Article" tab

		6. Validate GET Tags return all the distinct tags
		GET:
		-> URL: https://conduit.productionready.io/api/tags
		-> headers:
			Content-Type:application/json
			X-Requested-With:XMLHttpRequest
			Authorization:Token {{token}}

			Sample test is created under API_TagsTest but is pending for full implementation


		 */
	}
}
