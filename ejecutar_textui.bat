::
::  Nombre: ejecutar_textui.bat
::  Descripción: Script para ejecutar el juego en modo texto
::  @author: José Gallardo Caballero
::  @date: 12/02/2024
::  @version: 1.0
::  @license: MIT
::

@echo off
set /p nombreJugador1="Introduce el nombre del primer jugador: "
set /p nombreJugador2="Introduce el nombre del segundo jugador: "

java -cp .\bin; juego.textui.TresEnRaya %nombreJugador1% %nombreJugador2%

pause