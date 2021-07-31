COMPILER := javac

SRCDIR := ./src
OBJDIR := ./out
LIBDIR := ../lib

SRCS := \
	CompressedWeightedQuickUnion.java \
	IPercolation.java \
	Percolation.java \
	PercolationUnitTest.java \
	QuickFind.java \
	QuickUnion.java \
	WeightedQuickUnion.java

# java class path
CP := ./src:$(LIBDIR)/algs4.jar

# object files, auto generated from source files
OBJS := $(patsubst %,$(OBJDIR)/%.class,$(basename $(SRCS)))


.phony : clean


all : $(OBJS)


$(OBJDIR)/%.class : $(SRCDIR)/%.java
	$(COMPILER) -d $(OBJDIR) -cp "$(CP)" $^


clean :
	rm -dfr $(OBJDIR)
