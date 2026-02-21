# Conversor de Monedas en Java

Una aplicación que permite realizar conversiones de divisas en tiempo real utilizando la API ExchangeRate.

## Características Principales

* Conversión en tiempo real: Se conecta a una API externa para obtener las tasas de cambio más actualizadas.
* Interfaz interactiva: Menú en consola fácil de usar para seleccionar la moneda base y la moneda de destino.
* Validación de datos: Manejo de excepciones con try-catch para evitar que el programa colapse si el usuario ingresa texto no válido o letras en lugar de números.
* Código limpio y modular: Uso de record de java para la lectura de datos JSON.

## Tecnologías Utilizadas

* Java (Uso de HttpClient, HttpRequest y la estructura record).
* Gson: Librería de Google para convertir la respuesta JSON de la API a objetos manejables en Java.
* ExchangeRate: Servicio para obtener los valores de conversión de las divisas.

## Requisitos Previos

Para ejecutar este proyecto en tu entorno local, necesitarás:

1.  Agregar la librería **Gson** a las dependencias de tu proyecto.
2.  Obtener una API Key gratuita en https://www.exchangerate-api.com/ y reemplazar el texto correspondiente en la clase `Monedas.java`.

## Estructura del Proyecto

* Principal.java: Clase principal que contiene el método `main`, gestiona el bucle del menú interactivo, la entrada de datos por teclado y las validaciones.
* ConsultaMoneda.java: Clase encargada de construir la conexión HTTP, realizar la petición a la API y retornar los datos solicitados.
* Monedas.java (Record): Actúa como un Data Transfer Object (DTO) para mapear automáticamente el código base y la lista de tasas de conversión (`conversion_rates`) desde el archivo JSON.

## Cómo usar el programa

1. Al iniciar, el programa desplegará un menú con las opciones de monedas configuradas (Se pueden agregar más monedas si las agregas al diccionario).
2. El sistema solicitará el número correspondiente a la moneda que deseas usar como base.
3. A continuación, pedirá la cantidad de dinero a convertir.
4. Después, solicitará el número de la moneda a la que deseas realizar la conversión.
5. Se imprimirá en consola el cálculo exacto.
6. El ciclo se repetirá para nuevas consultas. Para cerrar la aplicación de forma segura, simplemente ingresa cualquier letra en el menú principal.
