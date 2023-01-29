# INSTALLING TOOLS 

## Mac OS X and Linux and other Unicen

If you happen to using Mac OS X, you can install Java 11 using the [SDK Manager](https://sdkman.io/).

    "SDKMAN! is a tool for managing parallel versions of multiple Software Development Kits on most Unix based systems."

List the available Java versions and providers that SDK Man can install
```bash
sdk list java
```

You will see something like this:

```
================================================================================
Available Java Versions for macOS 64bit
================================================================================
 Vendor        | Use | Version      | Dist    | Status     | Identifier
--------------------------------------------------------------------------------
 Corretto      |     | 19           | amzn    |            | 19-amzn             
               |     | 19.0.1       | amzn    |            | 19.0.1-amzn         
               |     | 17.0.5       | amzn    |            | 17.0.5-amzn         
               |     | 17.0.4       | amzn    |            | 17.0.4-amzn         
               |     | 11.0.17      | amzn    |            | 11.0.17-amzn        
               |     | 11.0.16      | amzn    |            | 11.0.16-amzn        
               |     | 8.0.352      | amzn    |            | 8.0.352-amzn        
               |     | 8.0.342      | amzn    |            | 8.0.342-amzn   
 Temurin       |     | 19           | tem     |            | 19-tem              
               |     | 17.0.4.1     | tem     |            | 17.0.4.1-tem        
               |     | 11.0.16.1    | tem     |            | 11.0.16.1-tem       
               |     | 8.0.345      | tem     |            | 8.0.345-tem      
 ...
```

I strongly recommend installing the *AdoptOpenJDk* version of the JDK also known as *Temurin*.
Install the Temurin OpenJDK and use it for this project.

```
sdk install java   11.0.16.1-tem 
```


You can use SDK Man to install `gradle` like so:

```bash
sdk install gradle
```


## Windows

For Windows 10, you could try the Windows System for Linux (WSL v2.0) for the brave. 

I strongly recommend downloading the individual Installer EXE for Windows 10 from OpenJDK project.

In fact, Microsoft are now supporting official OpenJDK as from 2022.

You can now try the [Microsoft Build of the OpenJDK](https://learn.microsoft.com/en-us/java/openjdk/download).
When I last looked the latest version was OpenJDK 11.0.17 LTS

From there, you download Gradle 7 or better [Gradle releases distribution](https://services.gradle.org/distributions/).
Choose the binary ZIP file for example `gradle-7.5.1-bin.zip`.
Unzip the distribution file into your local drive for example `C:\tools`

Set up a user system or user environment variable called `GRADLE_HOME` and point to the unpacked location, 
for example `C:\tools\gradle-7.5.1`

Modify your Windows PATH to include this new environment variable, for example

    PATH=...;C:\bin;%GRADLE_HOME%\bin;C:\Program Files\...

Save and close the environment dialog.

Open a new Command Terminal and type in the following

   `gradle -v`

You see the gradle version come up.


