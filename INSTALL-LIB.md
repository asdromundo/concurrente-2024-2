Instalación y Uso de las Bibliotecas del Libro
==============================================

#### Descarga el archivo hartley.tar.gz desde la siguiente dirección: [Archivos de "Concurrent Programming: The Java Programming Language", de S.J. Hartley (1998)](http://lya.fciencias.unam.mx/jloa/hartley.tar.gz). Una vez descargado, descomprímelo.

#### Dentro de la carpeta resultante, encontrarás una subcarpeta llamada `lib`. Ubica la ruta absoluta de esta carpeta utilizando el siguiente comando:
    
    $ pwd 

#### Finalmente, define la variable `CLASSPATH` para que Java pueda detectar las bibliotecas, debes cambiar la ruta `/home/mau/Downloads/hartley/lib` por la ruta de la carpeta `lib` en tu computadora.

    $ export CLASSPATH=/usr/local/JDK/lib/classes.zip:/home/mau/Downloads/hartley/lib:.

####  Con estos pasos completados, las bibliotecas del libro estarán listas para ser utilizadas en tu entorno de desarrollo Java.
