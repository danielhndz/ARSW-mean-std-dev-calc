# Escuela Colombiana de Ingeniería Julio Garavito
## Arquitecturas de Software (ARSW)

### :pushpin: Daniel Felipe Hernández Mancipe

<br/>

# :hammer_and_wrench: Mean and Standard Deviation Calculator

Programa para calcular la media y desviación estándar de un conjunto de número reales leídos desde un archivo.

Se usa una **implementación propia** de una [**lista enlazada**](/src/main/java/edu/escuelaing/arsw/labs/calc/linkedList/MyLinkedList.java) que **cumple** con la **API Collections** de Java.

## Getting Started

### Prerequisites

* Java >= 11.x
* Maven >= 3.x
* Git >= 2.x
* JUnit 4.x

### Installing

Simplemente clone el repositorio:

```
git clone https://github.com/danielhndz/ARSW-mean-std-dev-calc.git
```

Luego compile el proyecto con maven:

```
mvn compile
```

Si salió bien, debería tener una salida similar a esta:

![](../media/mvn_compile.png?raw?=true)

### Using

Para ejecutar correctamente siempre debe estar en el folder del proyecto. Suponiendo que el proyecto está en la carpeta `Descargas`, haga lo siguiente:

* En una consola dirígase al folder del proyecto

![](../media/move_to_folder.png?raw=true)

* Antes de usarlo, se listan los archivos con el nombre `data1.txt` y `data2.txt` que se encuentran en el directorio `home`, el que la aplicación usa como raíz para buscar los archivos por el nombre dado, para mi caso es `/home/daniel/`

![](../media/finding_files.png?raw=true)

Como se observa, se encuentran dos veces los dos archivos de prueba de este proyecto [**data1.txt**](/src/test/res/data1.txt) y [**data2.txt**](/src/test/res/data2.txt), su salida puede ser similar a la mía.

* Ahora, se procede a ejecutar el programa

![](../media/data1.txt.png?raw=true)

Como se observa, los números del archivo tienen **mean = 550.6** y **stdDev = 572.02**, según el programa.

![](../media/data2.txt.png?raw=true)

Como se observa, los números del archivo tienen **mean = 60.32** y **stdDev = 62.25**, según el programa.

## Running the tests

Apuntando hacia el directorio del proyecto, ejecute en una línea de comandos

```
mvn test
```

Se debe obtener una salida similar a esta:

![](../media/mvn_test1.png)

![](../media/mvn_test2.png)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](https://git-scm.com/) - Version Management
* [JUnit4](https://junit.org/junit4/) - Unit testing framework for Java

## Design Metaphor

* Autor: Daniel Hernández
* Última modificación: 08/06/2022

### Class Diagram

Primero se muestra el diagrama de clases del paquete *iterator*. 

![](../media/pkg_iterator_diagram.png?raw=true)

El *iterator* [`MyIterator`](/src/main/java/edu/escuelaing/arsw/labs/calc/iterator/MyIterator.java) implementa la interfaz [`Iterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html). El *iterator* [`MyListIterator`](/src/main/java/edu/escuelaing/arsw/labs/calc/iterator/MyIterator.java) implementa la interfaz [`ListIterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ListIterator.html).

Luego se muestra el diagrama de clases del paquete *linkedList*.

![](../media/pkg_linkedList_diagram.png?raw=true)

La clase [`MyLinkedList`](/src/main/java/edu/escuelaing/arsw/labs/calc/linkedList/MyLinkedList.java) es una implementación propia de una lista enlaza, extiende de la clase [`AbstractSequentialList`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/AbstractSequentialList.html) e implementa las interfaces [`Deque`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html), [`Cloneable`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Cloneable.html) y [`Serializable`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html)

## Authors

* **Daniel Hernández** - *Initial work* - [danielhndz](https://github.com/danielhndz)

## License

This project is licensed under the GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details

## Javadoc

Para generar Javadocs independientes para el proyecto en la carpeta `/target/site/apidocs` ejecute:

```
mvn javadoc:javadoc
```
