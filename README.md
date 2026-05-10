# Taller Java - Huella de Carbono

## 1. Analisis del problema

El caso de estudio pide modelar tres clases independientes:

- `Edificio`
- `Carro`
- `Bicicleta`

Las tres clases no deben heredar entre si, pero si deben compartir un comportamiento comun: calcular su huella de carbono.

Por eso se creo la interfaz `HuellaCarbono`, la cual define dos metodos:

- `getHuellaCarbono()`: calcula la huella de carbono.
- `getInfo()`: devuelve informacion basica del objeto.

## 2. Diseno de la solucion

Se aplico polimorfismo usando un `ArrayList<HuellaCarbono>`.

Esto permite guardar en una sola lista objetos de diferentes clases, siempre que implementen la interfaz.

Luego, al recorrer la lista, el programa llama a `getHuellaCarbono()` de forma polimorfica. Es decir, cada objeto responde segun su propio tipo.

## 3. Clases del programa

### `HuellaCarbono`
Es la interfaz principal del programa.

### `Edificio`
Representa un edificio.

Atributos principales:

- nombre
- direccion
- pisos
- areaMetrosCuadrados
- consumoElectricoAnualKwh
- consumoGasAnualM3
- ocupantes

La huella se calcula con el consumo de electricidad y gas.

### `Carro`
Representa un carro.

Atributos principales:

- marca
- modelo
- año
- color
- eficienciaKmPorLitro
- kilometrosPorAño
- tipoCombustible

La huella se calcula segun el tipo de combustible y los kilometros recorridos.

### `Bicicleta`
Representa una bicicleta.

Atributos principales:

- propietario
- marca
- tipo
- cambios
- kilometrosPorAño
- vidaUtilEnAños
- carbonoFabricacionKg
- costoMantenimientoAnual

La bicicleta no emite gases directamente al usarse, pero si se considero una huella por fabricacion y mantenimiento.

### `AplicacionHuellaCarbono`
Es la clase principal que:

- crea los objetos
- los guarda en un `ArrayList<HuellaCarbono>`
- recorre la lista
- muestra la informacion y la huella de cada objeto
- calcula el total

### `GestorArchivo`
Guarda el reporte en un archivo de texto.

## 4. Principios de POO aplicados

- Encapsulamiento: los atributos son privados y se accede a ellos con getters y setters.
- Abstraccion: la interfaz `HuellaCarbono` define el comportamiento comun.
- Polimorfismo: un mismo metodo (`getHuellaCarbono`) se comporta diferente segun el objeto.
- Organizacion simple del sistema: cada clase cumple una funcion concreta.

## 5. Principio SOLID aplicado

Se aplico especialmente el principio de responsabilidad unica:

- `Edificio`, `Carro` y `Bicicleta` modelan entidades.
- `AplicacionHuellaCarbono` ejecuta el programa.
- `GestorArchivo` maneja el archivo de salida.

## 6. Pruebas

Se dejaron pruebas simples en Java puro:

- `PruebaEdificio`
- `PruebaCarro`
- `PruebaBicicleta`
- `PruebaIntegracionHuellaCarbono`

Estas pruebas validan:

- calculos de huella
- funcionamiento de metodos
- uso del polimorfismo
- funcionamiento general del programa

## 7. Como ejecutar

Compilar:

```bash
javac *.java
```

Ejecutar aplicacion principal:

```bash
java AplicacionHuellaCarbono
```

Ejecutar pruebas:

```bash
java PruebaEdificio
java PruebaCarro
java PruebaBicicleta
java PruebaIntegracionHuellaCarbono
```

## 8. Conclusion

La solucion cumple con el caso de estudio porque implementa tres clases independientes, una interfaz comun, el uso de `ArrayList<HuellaCarbono>`, polimorfismo, calculo de huella de carbono, documentacion basica y pruebas del programa.
