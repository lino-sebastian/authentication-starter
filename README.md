# authentication-starter
Starter package with JWT supporting authentication and authorization system for development Projects.

This custom spring boot authentication-starter can be used to generate JWT Auth Token and authorize API calls based on the Token expiry.

## JWT 
[JSON Web Token](https://jwt.io/) is a proposed Internet standard for creating data with optional signature and/or optional encryption whose payload holds JSON that asserts some number of claims. 

The tokens are signed either using a private secret or a public/private key.

# Working
**Authentication**
1. Passing the credentials to ```com.post.meridiem.EntryPoint.authenticate```
2. Authenticating incoming credentials with actual credentials(DB stored data)
3. Generating JWT Token

**Authorization**

API url patterns can be added to ```com.post.meridiem.config.WebSecurityConfig.configure``` get excluded from JWT Authorization
1. ```JwtRequestFilter``` intercepts the incoming requests
2. Validates the request JWT Token by checking its validity 