#!/bin/bash

cd rmi
javac *.java
cd ..
rmic rmi.BatalhaServer
rmic rmi.Client
clear
echo "carregando ."
rmiregistry &
sleep 1
clear
echo "carregando .."
sleep 1
clear
echo "carregando ..."
sleep 1
clear
echo "carregando ...."
sleep 1
clear
echo "Server OK"
echo
java rmi.ServerDriver
for x in $(jobs -p); do kill $x; done
cd rmi
rm *.class
