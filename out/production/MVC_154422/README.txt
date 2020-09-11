*************************************************************************
                           SISTEMA BUSTERBLOCK v1.0
*************************************************************************

Funcionamiento.

El software SISTEMA BUSTERBLOCK v1.0 sirve para mantener una pequeña base de datos dentro de un archivo
sobre los clientes del establecimiento "BUSTERBLOCK". Se pueden dar de alta, baja o modificar la información
de la base de datos y  calcular el monto a pagar (como si fuera una máquina registradora) de la
cantidad de películas rentadas por un cliente.

-------- Comentarios --------

Siempre que la estructura esté vacía, aparecerá una ventana emergente avisando que no hay información.

El sistema en principio no contiene ningún tipo de información, para esto, se tiene que dar de alta un cliente
por primera vez.

*******************************************************************************************************************

Para dar un cliente de alta.

Escribir en los campos correspondientes los datos del cliente.
Después ir al menú "Cliente" y hacer click "Dar de alta a un cliente".

*******************************************************************************************************************

Para guardar los cambios a disco.

Ir al menú "Sistema" y hacer clic en la opción "Guardar cambios". Esto escribirá en el archivo "clientes.txt" la
información añadida a la estructura.

*******************************************************************************************************************

Para navegar a través de los datos contenidos en la estructura, utilizar los botones "Siguiente" y "Anterior".

*******************************************************************************************************************

Para eliminar un dato.

Navegar hasta identificar el dato a borrar. Ir al menu "Cliente" y seleccionar "Borrar este cliente". Para confirmar
el borrado del dato en disco, ir a "Sistema" y "Guardar cambios".

*******************************************************************************************************************

Para modificar un dato.

Navegar hasta identificar el dato a modificar. Ir al menu "Cliente" y seleccionar "Modificar datos del cliente".
Para asegurar los cambios del dato en disco, ir a "Sistema" y "Guardar cambios".

*******************************************************************************************************************

Opción rentar películas.

Una vez que hay un cliente en pantalla, seleccionar "Rentar película(s)" cambiará el valor del campo de las películas
del cliente. Ir a la opción "Guardar cambios" para confirmar la renta de las películas.

Si un cliente ya ha pagado o entregado sus películas, entonces utilizar esta opción para regresar el valor de las
películas rentadas a 0.

*******************************************************************************************************************

Ver adeudo.

Una vez que el cliente ha rentado películas, utlilzar la opción "Ver adeudo del cliente" en el menú "Cliente"
muestra la cantidad que debe pagar el usuario.

*******************************************************************************************************************