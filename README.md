### Successful Progress
![Success Message](./successmsg.gif)


<br>
<br>

### Failure Progress
![Success Message](./failuremsg.gif)


### How to use it in your project

#### Step 1: Add it in your settings.gradle.kts at the end of repositories:
```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://www.jitpack.io") }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        implementation("com.github.i-sachinkumar:ProgressIndicatorWithActionMessage:-SNAPSHOT")
	}
```
