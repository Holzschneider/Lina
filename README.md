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

**doubles only**: (a) yields simpler code for JavaScript, (b) code-inlined math is expected to never be a performance bottleneck, (c) serious bulk math operations are supposed to be done with serious bulk math libraries, or off-loaded to CUDA/OpenCL/Compute-whatever (d) shut up, already.

**2D/3D/4D**: (a) the d does not denote storage class but dimensionality, (b) in every printed medium that refers to 3D as three-dimensions the "D" is in caps

**transform/concatenate/concatenation**: A Matrix multiplication produces a result matrix with different sizes, depending on the sizes of the multiplication parameters. A result matrix C = A.B is sized NxM if A is sized NxP and B is PxM. *transform* and *concatenate* are 2 argument in-place operations that constrain these sizes: 

- ``A.concatenate(B) : A <- A.B `` uses A as result container, therefore implies the constraint P=M. 
- ``A.transform(B)   : B <- A.B `` uses B as result container, hence the constraint is P=N. 

This implicitely limits the use of *concatenate* and *transform* to typical cases that as implied by their name:  
i.e. ``v = P.concatenate(T).concatenate(R).transform(v)``, as in using projection Matrix P (4x4) concatenated to a translation matrix T (4x4) and a rotation Matrix R (4x4) to transform Vector v (4x1) and retrieve it as a result.

    
