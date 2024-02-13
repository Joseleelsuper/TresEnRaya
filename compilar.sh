#!/bin/bash

#
#  Nombre: compilar.sh
#  Descripción: Script para compilar el proyecto
#  @author: José Gallardo Caballero
#  @date: 12/02/2024
#  @version: 1.0
#  @license: MIT
#

if [ ! -d ./bin ]; then
    mkdir bin
fi

javac -classpath ./bin:./lib/* \
-encoding UTF-8 \
-d bin \
-sourcepath ./src \
./src/juego/util/*.java \
./src/juego/modelo/*.java \
./src/juego/control/*.java \
./src/juego/textui/*.java