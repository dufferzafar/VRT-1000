all: clean compile run

clean:
	@rm -rf *.class

compile:
	@javac Main.java

run:
	@java Main
