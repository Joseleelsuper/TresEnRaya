#!/bin/bash

#
#  Nombre: ejecutar_textui.sh
#  Descripción: Script para ejecutar el juego en modo texto
#  @author: José Gallardo Caballero
#  @date: 12/02/2024
#  @version: 1.0
#  @license: MIT
#

read -p "Introduce el nombre del primer jugador: " nombreJugador1
read -p "Introduce el nombre del segundo jugador: " nombreJugador2

java -cp ./bin: juego.textui.TresEnRaya $nombreJugador1 $nombreJugador2

read -p "Press enter to continue"