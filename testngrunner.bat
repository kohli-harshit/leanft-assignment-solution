set projectLocation=C:\Users\leanft\workspace\final assignment solution
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;%projectLocation%\target\classes\*;%projectLocation%\target\test-classes\*;C:\eclipse\eclipse\plugins\org.testng.eclipse_6.11.0.201703011520\lib\*;C:\Program Files (x86)\HP\LeanFT\SDK\Java\*;C:\Users\leanft\.m2\repository\org\apache\poi\poi\3.16\*
java org.testng.TestNG testng.xml
pause