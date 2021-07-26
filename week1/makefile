COMPILER = javac
OUTPUT = ./out
SRC = ./src
CLASS_PATH = .:./lib/algs4.jar


.phony : clean


all : $(OUTPUT)/HelloWorld.class $(OUTPUT)/HelloGoodbye.class $(OUTPUT)/RandomWorld.class


$(OUTPUT)/%.class : $(SRC)/%.java
	$(COMPILER) -d $(OUTPUT) -cp "$(CLASS_PATH)" $^

clean :
	rm -dfr $(OUTPUT)
