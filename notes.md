# RESTful Web Services

Social Media Application Resource Mappings

User -> Posts

- Retrieve all Users        - GET       /users
- Create a User             - POST      /users
- Retrieve one User         - GET       /users/{id}
- Delete a User             - DELETE    /users/{id}


- Retrieve all posts from a User        - GET   /users/{id}/posts
- Create a post for a User              - POST  /users/{id}/posts
- Retrieve details of a post            - GET   /users/{id}/posts/{postId}