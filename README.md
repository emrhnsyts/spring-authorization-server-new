# --trying out new authorization server

### in order to get an authorization code, open your browser and paste the address below and login with "username" and "password"

http://localhost:8000/oauth2/authorize?response_type=code&client_id=client&redirect_uri=http://127.0.0.1:8080/authorized&scope=openid

### after receiving your code in the url, add it to the param named "code" and execute a http basic post request with client credentials "client" and "secret" 

http://localhost:8000/oauth2/token?redirect_uri=http://127.0.0.1:8080/authorized&grant_type=authorization_code&code={code}

### having acquired your access token, you can now test the demo url with the access token in the headers

http://localhost:8091/demo