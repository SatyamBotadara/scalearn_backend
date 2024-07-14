# Setup Database
To start Mongodb service just run
``` $ ./startDb.sh ```
it will create Mongo container. It will provide GUI at 8081 port and database is publish on 27017 port.
if you are getting some permission issue try to give execute permission using command 
``` $ chmod +x ./startDb.sh ```

# Start Application

After starting database service now you can run java service using 
``` $ ./run.sh ```
and it will register service on 8082 port and you can access APIs on 8082 port.
