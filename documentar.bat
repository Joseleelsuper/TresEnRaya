::
::  Nombre: documentar.bat
::  Descripción: Script para documentar el juego TresEnRaya
::  @author: José Gallardo Caballero
::  @date: 12/02/2024
::  @version: 1.0
::  @license: MIT
::

:: Documentar el juego
javadoc -author -version -private ^
-encoding UTF-8 -charset UTF-8 ^
-sourcepath .\src -d doc -classpath .\lib\*;.\bin ^
-docencoding UTF-8 ^
-link https://docs.oracle.com/en/java/javase/20/docs/api/ ^
-subpackages juego

:: Pausar la consola para poder ver los resultados.
pause