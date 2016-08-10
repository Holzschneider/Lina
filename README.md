# Lina
Linear Algebra for Java optimized for elegance and ease-of-use instead of raw speed.


Release
-------

The current state of the project is to be considered "incomplete and in development".

Releases are deployed automatically to the deploy branch of this github repostory. 
To add a dependency using maven, modify your *repositories* section to include the git based repository.

	<repositories>
	 ...
	  <repository>
	    <id>Lina-Repository</id>
	    <name>Lina Git-based repo</name>
	    <url>https://raw.githubusercontent.com/Holzschneider/Lina/deploy/</url>
	  </repository>
	...
	</repositories>
	
and modify your *dependencies* section to include the dependency
 
	  <dependencies>
	  ...
	  	<dependency>
	  		<groupId>de.dualuse.commons</groupId>
	  		<artifactId>Lina</artifactId>
	  		<version>LATEST</version>
	  	</dependency>
	  ...
	  </dependencies>



To add the repository and the dependency using gradle refer to this

	repositories {
	    maven {
	        url "https://raw.githubusercontent.com/Holzschneider/Lina/deploy/"
	    }
	}

and this

	dependencies {
	  compile 'de.dualuse.commons:Lina:0.+'
	}
