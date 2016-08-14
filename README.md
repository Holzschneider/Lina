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

	
FAQ
--------------------

*Design Decisions*

**doubles only**: (a) yields simpler code for JavaScript, (b) code-inlined math is expected to never be a performance bottleneck, (c) serious bulk math operations are supposed to be done with serious bulk math libraries, or off-loaded to CUDA/OpenCL/Compute-whatever 

**2D/3D/4D**: (a) the d does not denote storage class but dimensionality, (b) in every printed medium that refers to 3D as three-dimensions the "D" is in caps