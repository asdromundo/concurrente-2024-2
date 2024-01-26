# Computación Concurrente 2024-2

Link del curso: [Computación Concurrente](http://lya.fciencias.unam.mx/jloa/curso.compconcur.html)

## Instrucciones y Entregables

Cada práctica cuenta con un archivo `README.md` que contiene las instrucciones detalladas y los entregables correspondientes. Este documento proporciona la guía necesaria para completar la práctica de manera adecuada.

## Plataforma de Entrega

Las prácticas se entregan exclusivamente a través de Google Classroom.

## Modalidad de Trabajo

Las prácticas se realizan en equipos de 2 personas. Esta modalidad fomenta la colaboración y el intercambio de conocimientos entre compañeros.

## Fecha de Entrega

Es fundamental cumplir con la fecha límite de entrega establecida en Google Classroom. Las prácticas deben ser enviadas dentro del plazo indicado para su evaluación.

## Contenido de las Prácticas

Cada práctica está acompañada por un proyecto Maven que incluye pruebas unitarias. Asegúrate de tener instaladas las siguientes versiones necesarias:

### Maven 3
```bash
mvn -v

```

### Java 8
```bash
java -version

```

### Ejecución del Proyecto
Para ejecutar la práctica, sigue estos pasos:

```bash
mvn package
java -jar target/Practica-01-1.0.jar
```

### Pruebas Unitarias

Para ejecutar las pruebas unitarias, utiliza el comando:
```bash
mvn test
```

Si deseas ejecutar solo un tipo específico de pruebas unitarias:
```bash
mvn -Dtests=AppTest test
```

### Ejemplos del libro

Adicionalmente cada práctica incluye archivos Java ubicados al mismo nivel que el `README.md` y el `pom.xml`. Estos archivos contienen ejemplos del libro o material de referencia. Es necesario ejecutar los archivos Java correspondientes y enviar una captura de pantalla que demuestre la correcta ejecución de los mismos.
