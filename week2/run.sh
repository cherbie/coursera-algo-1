#!/bin/zsh

export CP=.:./out:../lib/algs4.jar

java -cp $CP -ea PercolationUnitTest PercolationUnitTest
java -cp $CP -ea PercolationStatsUnitTest PercolationStatsUnitTest
