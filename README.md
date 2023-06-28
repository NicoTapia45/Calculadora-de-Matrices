# Calculadora-de-Matrices

#Proyecto acerca de creacion de una calculadora de matrices que permite suma, resta, multiplicacion y calculo de inversa, entre dos matrices de 3x3 usando java y javafx.

## Integrantes
- Aymara Rojas
- Nicolás Tapia
- Maria Guzman

## Archivos que componen el proyecto
* El archivo makefile
* Las clases "AplicacionMatriz, Matriz, OperacionesMatriz, OperacionesMatrizImpl, PanelMatriz" (todo con el tipo de formato.java)
* Imagen del diagrama de clases del proyecto 

## Requerimientos
1) Consola o terminal para ejecutar el programa (Ej: Cmd Windows o Terminal Linux)
2) Tener instalado la ultima version de java
3) Tener instalado la version 20 del Software Development Kit(SDK)
4) Tener instalado javaFX, en su versión 20
5) Tener instalado make

## Como compilar
1) Dirigirse al directorio en donde está guardado el proyecto 
2) Abrir el archivo makefile y cambiar el parametro JFX_OPTIONS para que apunte al directorio de javaFX donde usted lo haya instalado
3) Iniciar la terminal en el stage que desea compilar 
4) Ejecutar el comando "make"


## Ejecucción 
* Para ejecutar el programa realizar el comando "make run".
* Para limpiar la carpeta de los archivos de compilación ejecutar el comando "make clean"

## Consideraciones
*Tener instalado javafx en su version 20, puesto que este proyecto no funcionara sin el.
*Este programa esta hecho solamente para matrices de 3x3, no intente colocar matrices mas grandes.

## Documentacion Javadoc
Para generar la documentacion en IntelliJ IDEA, se debe de abrir el proyecto en este IDE y luego ir a la pestaña de "Tools" y seleccionar la opcion "Generate JavaDoc". Luego de esto se debe de seleccionar la carpeta donde se guardara la documentacion y presionar "Ok". Finalmente se debe de abrir el archivo index.html o cualquier otro con la misma extension, que se encuentren en la carpeta seleccionada para ver la documentacion.
