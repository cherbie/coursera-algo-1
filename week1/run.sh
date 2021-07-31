#!/bin/zsh

export CP=./out:../lib/algs4.jar

java -cp $CP HelloWorld $*
java -cp $CP HelloGoodbye $*
java -cp $CP RandomWorld
