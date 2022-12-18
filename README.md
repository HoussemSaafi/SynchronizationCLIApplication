# SynchronizationCLIApplication using Picocli

#Synchronize between two local directories in an optimized way through running the command  "sync -s 'PathToYourSourceFolder' -d 'PathToYourDestinationFolder' "


##Install The SyncApp :  Use the build automation tool : Maven


  ###If you are using IntelliJ IDEA then you can use the maven integrated plugin to clean and install the application.

  ###Else have maven installed in your local environment, then with the command line; change the directory to point to your project folder (where the pom.xml file is)     ###then run "mvn clean install" 
  ###What does mvn clean install do in Maven?
  ###mvn clean install tells Maven to do the clean phase in each module before running the install phase for each module. What this does is clear any compiled files you   ###have, making sure that you're really compiling each module from scratch.


##Run The SyncApp : 

  ###Having built our project now under the target folder you could find the build jar file. 
  ###To run the application open the command line prompt and point to the target folder where the jar file is located.
  ###Finally run the jar file using the command :java -jar "nameOfYourJarFile"
  
##Create a .cmd file to run your application with the above mentionned command :
  ###Inside your file insert this line: @java -jar myapp-1.0-SNAPSHOT-shaded.jar %*
