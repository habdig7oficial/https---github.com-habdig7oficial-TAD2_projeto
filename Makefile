bytecode:
	javac lib/DataStructs/*.java tokens/*.java tokens/asm/*.java Program.java

run: bytecode
	java Program