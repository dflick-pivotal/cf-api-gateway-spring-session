# cf-api-gateway-spring-session

1. mvn clean install
2. target your pcf space
2. ./scripts/create_services_pcf.sh
2. configure the config-server with https://github.com/dflick-pivotal/api-gateway-config-repo.git
3. initalize the service registry by clicking on manage in the app manager.
4. change manifest-pcf.yml for unique routes
5. cf push -f manifest-pcf.yml
5. browse to the ui app
6. login user/password

You can run the app local too. 

Hystrix dashboard on PCF is not showing data - neet to work on this
Hystrix dashbaord shows data when app runs local

