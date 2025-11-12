bytecode:
	javac lib/DataStructs/*.java tokens/*.java Program.java

run: bytecode
	java Program