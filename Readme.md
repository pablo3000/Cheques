## :mega: Cheques
Imprima cheques personalizados con este software de impresión de cheques escrito en Java.

Este es un ejemplo sencillo de cómo desarrollar una aplicación que permita utilizar:
* Java Swing
* Maven
* Jasper Resport
* JDatePicker
* Carga de librerías en tiempo de ejecución (Addons)
* Extensión de componentes para que se adapte a nuestras necesidades (JXTextField,JXButton)
* Ejecución parametrizada
* I18N

## :rocket: Comenzando
_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de educación._

Mira **Deployment** para conocer como desplegar el proyecto.

## :clipboard: Pre-requisitos
* JAVA JDK  para corren Maven y ejecutar el proyecyo.
https://www.java.com/es/

* Maven  para compilar el proyecto.
https://maven.apache.org/

* Proyecto principal:
  * https://github.com/pablo3000/Cheques/tree/master/Cheques
  * https://github.com/pablo3000/Cheques/tree/master/chequescommon

* Addons
  * https://github.com/pablo3000/Cheques/tree/master/addons/Calculator
  * https://github.com/pablo3000/Cheques/tree/master/addons/asterix
  * https://github.com/pablo3000/Cheques/tree/master/addons/2Upper

## :wrench: Instalación
Maven compila y genere una version portable del la aplicación.
En el directorio "distribution" se alojará una copia de la aplcicación lista para utilizar

## 📦  Deployment
1) Ir a directorio del proyecto
2) Ejecutar el comando Maven que generará el despligue
    ```
    mvn clean package assembly:single
    ```
3) Se creará una carpeta llamada "distribution" con todo el contenido de la aplicacion lista para utilizar.

**Estructura básica de directorios para la ejecución de la aplicación**
```.
├── Cheques
    ├── addons
    │   ├── ....
    │   └── ....
    ├── cheques.jar
    └── cheque.jrxml
 ```
## :flags: Parámetros opcionales de la aplicación
*   -info
_Muestra por consola la información de la aplicación_
*   -noaddons
_Inicia la aplicación sin cargar los addons_
*   -res_%archivo%
_Carga otro archivo de recurso con los textos de la aplicación_
_%archivo% = archivo propeties con los textos
_ejemplo: "-res_portugues.propeties"_

## :hammer: Construido con
Este proyecto fue escrito utilizando las siguientes herramientas

* [Java](https://www.java.com/es/) - Lenguaje de programación.
* [Netbeans](https://netbeans.org/) - IDE de programación.
* [Maven](https://maven.apache.org/) - Manejador de dependencias.
* [Jasper Report](https://www.jaspersoft.com/) - Usado para generar la impresion.
* [JDatePicker](https://github.com/JDatePicker/JDatePicker) - Componente Swing para el ingreso de fechas.

## :family: Contribuir
¿Quiere hacer su aporte? 
Es un honor recibir sus contribuciones. ¡Muchas gracias! 
Desde sugerir una idea, hasta hacer un cambio, todo es bienvenido. Hay varias cosas por hacer: documentación, apariencia visual, pruebas del producto,etc.
Necesitamos probar el sistema, así que simplemente instálelo y denos su retroalimentación.

## :black_nib: Autor
* **Pablo Mariani** - *Trabajo Inicial y Documentación* - [e-mail](mailto:soyelpablo@gmail.com)
    Chabás - Santa Fe - Argentina 

## :page_with_curl: Licencia
Este proyecto está bajo la Licencia (MIT) - mira el archivo [LICENSE.md](https://github.com/pablo3000/cheques/blob/master/LICENSE) para detalles

## :newspaper: Disclaimer
El código de esta aplicación y la aplicación compilada puede que no se ejecute de una manera óptima y contenga algunas fallas.
El proyecto fue escrito solo para propósitos educativos.
El autor no se hace responsable por el uso, modificación y distribución de todo el contenido perteneciente a este repositorio.

## :camera: ScreenShots
![ScreenShot](https://github.com/pablo3000/Cheques/blob/master/resources/scr01.png)
![ScreenShot](https://github.com/pablo3000/Cheques/blob/master/resources/scr02.png)
![ScreenShot](https://github.com/pablo3000/Cheques/blob/master/resources/scr03.png)
![ScreenShot](https://github.com/pablo3000/Cheques/blob/master/resources/scr04.png)

## :gift: Gracias!!!
* Muchas gracias a totas las personas que participaron en el desarrollo del lenguaje JAVA. Les debo una  :beer:

---
