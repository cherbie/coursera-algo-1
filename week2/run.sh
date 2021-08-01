#!/bin/zsh

export CP=.:./out:../lib/algs4.jar

java -cp $CP -ea PercolationUnitTest PercolationUnitTest
java -cp $CP -ea PercolationStats PercolationStats

zip -j submission.zip */Percolation.java */PercolationStats.java && echo "...created submission.zip"