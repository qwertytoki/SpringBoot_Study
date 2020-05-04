This is POC by using SpringBoot + Thymeleaf
# How to Run by using Docker.
1. Install Docker
    Mac : https://docs.docker.com/docker-for-mac/  </br>
    Windows : https://docs.docker.com/docker-for-windows/

2. Build the docker image  
    ```docker build -t springio/search  .```

3. Run the docker container  
    ```docker run -p 8080:8080 springio/search```

4. Access URL   
    ```http://localhost:8080/user/list```

# How to start developing
Follow below guidance. You will be able to start developing in 15mins.
https://spring.io/guides/gs/serving-web-content/

In the above guidance, you can generate project by using Spring Initializer.
Do add Thymeleaf,Spring web, lombok for dependencies. 
