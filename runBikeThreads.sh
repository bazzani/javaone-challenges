#!/usr/bin/env bash
outDir=out;
clear;pwd;
mkdir -p ${outDir};
find . -name "*.java" -print0 | xargs --null javac -d ${outDir} -Xlint:none;
clear;

for ((i=1;i<=$1;i++))
do
   echo "Running Thread Challenge #$i";
   java -cp out com.javachallenges.ljc.ThreadChallenge ${i};
done

rm -rf ${outDir};
