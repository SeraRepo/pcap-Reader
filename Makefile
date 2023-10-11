JFLAGS = -g -sourcepath . 
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	find . -type f -path "./*" -name "*.class" -delete

run:
	java Main