# API de Registro de Bitácora y Gestión de Empleados

Esta API proporciona endpoints para registrar eventos en la bitácora y gestionar empleados. A continuación, se detallan los endpoints y cómo utilizarlos.

## Tabla de Contenido

1. [Bitacora](#bitacora)
2. [Empleados](#empleados)
3. [Errores](#errores)

---

## Bitacora

### Obtener Bitácora

- **URL**: `/bitacora`
- **Método HTTP**: GET
- **Descripción**: Obtiene la lista de eventos registrados en la bitácora.

### Ejemplo de Solicitud

```http
GET /bitacora
```
### Ejemplo de respuesta exitosa:
```json
[
    {
        "metodo": "getEmpleados",
        "input": "NA",
        "output": "{\"status\":\"OK\",\"headers\":{},\"body\":[{\"id\":1,\"primerNombre\":\"Juan\",\"segundoNombre\":\"Carlos\",\"apellidoPaterno\":\"González\",\"apellidoMaterno\":\"Pérez\",\"edad\":28,\"sexo\":\"Masculino\",\"fechaNacimiento\":\"ene 15, 1985\",\"puesto\":\"Gerente de Proyectos\"},{\"id\":2,\"primerNombre\":\"María\",\"segundoNombre\":\"Isabel\",\"apellidoPaterno\":\"López\",\"apellidoMaterno\":\"Martínez\",\"edad\":32,\"sexo\":\"Femenino\",\"fechaNacimiento\":\"feb 15, 1986\",\"puesto\":\"Analista de Datos\"},{\"id\":3,\"primerNombre\":\"Pedro\",\"segundoNombre\":\"Antonio\",\"apellidoPaterno\":\"Ramírez\",\"apellidoMaterno\":\"Rodríguez\",\"edad\":25,\"sexo\":\"Masculino\",\"fechaNacimiento\":\"mar 15, 1987\",\"puesto\":\"Desarrollador Senior\"},{\"id\":4,\"primerNombre\":\"Laura\",\"segundoNombre\":\"Patricia\",\"apellidoPaterno\":\"Díaz\",\"apellidoMaterno\":\"Fernández\",\"edad\":29,\"sexo\":\"Femenino\",\"fechaNacimiento\":\"abr 15, 1988\",\"puesto\":\"Diseñadora Gráfica\"},{\"id\":5,\"primerNombre\":\"Roberto\",\"segundoNombre\":\"José\",\"apellidoPaterno\":\"Sánchez\",\"apellidoMaterno\":\"Gómez\",\"edad\":35,\"sexo\":\"Masculino\",\"fechaNacimiento\":\"abr 15, 1989\",\"puesto\":\"Ingeniero de Software\"},{\"id\":6,\"primerNombre\":\"Ana\",\"segundoNombre\":\"María\",\"apellidoPaterno\":\"Hernández\",\"apellidoMaterno\":\"López\",\"edad\":27,\"sexo\":\"Femenino\",\"fechaNacimiento\":\"jun 15, 1990\",\"puesto\":\"Analista de Negocios\"},{\"id\":7,\"primerNombre\":\"Carlos\",\"segundoNombre\":\"Andrés\",\"apellidoPaterno\":\"Martínez\",\"apellidoMaterno\":\"García\",\"edad\":30,\"sexo\":\"Masculino\",\"fechaNacimiento\":\"jul 15, 1991\",\"puesto\":\"Desarrollador Frontend\"},{\"id\":8,\"primerNombre\":\"Sofía\",\"segundoNombre\":\"Cristina\",\"apellidoPaterno\":\"Pérez\",\"apellidoMaterno\":\"Fuentes\",\"edad\":31,\"sexo\":\"Femenino\",\"fechaNacimiento\":\"ago 15, 1992\",\"puesto\":\"Gerente de Recursos Humanos\"},{\"id\":9,\"primerNombre\":\"Luis\",\"segundoNombre\":\"Fernando\",\"apellidoPaterno\":\"Gómez\",\"apellidoMaterno\":\"Vargas\",\"edad\":33,\"sexo\":\"Masculino\",\"fechaNacimiento\":\"sep 15, 1993\",\"puesto\":\"Arquitecto de Soluciones\"},{\"id\":10,\"primerNombre\":\"Elena\",\"segundoNombre\":\"Isabel\",\"apellidoPaterno\":\"Rodríguez\",\"apellidoMaterno\":\"Torres\",\"edad\":26,\"sexo\":\"Femenino\",\"fechaNacimiento\":\"oct 15, 1994\",\"puesto\":\"Analista de QA\"}]}",
        "httpCodeResponse": "200 OK",
        "fechaEjecucion": "24-10-2023"
    }
]
```

---

## Empleados

### Obtener Empleados

- **URL**: `/empleado`
- **Método HTTP**: GET
- **Descripción**: Obtiene la lista de empleados registrados.

### Ejemplo de Solicitud

```http
GET /empleado
```

### Ejemplo de respuesta exitosa:

```json
[
    {
        "id": 1,
        "primerNombre": "Juan",
        "segundoNombre": "Carlos",
        "apellidoPaterno": "González",
        "apellidoMaterno": "Pérez",
        "edad": 28,
        "sexo": "Masculino",
        "fechaNacimiento": "15-01-1985",
        "puesto": "Gerente de Proyectos"
    },
    {
        "id": 2,
        "primerNombre": "María",
        "segundoNombre": "Isabel",
        "apellidoPaterno": "López",
        "apellidoMaterno": "Martínez",
        "edad": 32,
        "sexo": "Femenino",
        "fechaNacimiento": "15-02-1986",
        "puesto": "Analista de Datos"
    },
    {
        "id": 3,
        "primerNombre": "Pedro",
        "segundoNombre": "Antonio",
        "apellidoPaterno": "Ramírez",
        "apellidoMaterno": "Rodríguez",
        "edad": 25,
        "sexo": "Masculino",
        "fechaNacimiento": "15-03-1987",
        "puesto": "Desarrollador Senior"
    }
]
```

### Eliminar Empleado Por ID

- **URL**: `/empleado`
- **Método HTTP**: DELETE
- **Descripción**: Elimina empleados por ID.
- **Solicitud (HTTP 204 No Content)**:

### Ejemplo de Solicitud

```http
DELETE /empleado/{idEmpleado}
```

### Actualiza Empleado

- **URL**: `/empleado`
- **Método HTTP**: PATCH
- **Descripción**: Actualiza empleados por ID.
- **Solicitud (HTTP 200 OK)**:

### Ejemplo de Solicitud

```http
PATCH /empleado/{idEmpleado}
```
```json
{
    "primerNombre": "Otro",
    "segundoNombre": "jose",
    "apellidoPaterno": "González",
    "apellidoMaterno": "rfffff",
    "edad": 28,
    "sexo": "Masculino",
    "fechaNacimiento": "15-05-1990",
    "puesto": "Gerente de ffff"
}
```

### Ejemplo de respuesta exitosa:

```json
{
    "id": 1,
    "primerNombre": "Otro",
    "segundoNombre": "jose",
    "apellidoPaterno": "González",
    "apellidoMaterno": "rfffff",
    "edad": 28,
    "sexo": "Masculino",
    "fechaNacimiento": "10-10-0020",
    "puesto": "Gerente de ffff"
}
```

### Inserta Empleados

- **URL**: `/empleado`
- **Método HTTP**: POST
- **Descripción**: Registra empleados.
- **Solicitud (HTTP 200 OK)**:

### Ejemplo de Solicitud

```http
POST /empleado
```
```json
[
    {
        "primerNombre": "dededde",
        "segundoNombre": "jose",
        "apellidoPaterno": "González",
        "apellidoMaterno": "rfffff",
        "edad": 28,
        "sexo": "Masculino",
        "fechaNacimiento": "15-05-1990",
        "puesto": "Gerente de ffff"
    },{
        "primerNombre": "ccccc",
        "segundoNombre": "jose",
        "apellidoPaterno": "González",
        "apellidoMaterno": "rfffff",
        "edad": 28,
        "sexo": "Masculino",
        "fechaNacimiento": "15-05-1990",
        "puesto": "Gerente de ffff"
    }
]
```

### Ejemplo de respuesta exitosa:

```json
[
    {
        "id": 11,
        "primerNombre": "dededde",
        "segundoNombre": "jose",
        "apellidoPaterno": "González",
        "apellidoMaterno": "rfffff",
        "edad": 28,
        "sexo": "Masculino",
        "fechaNacimiento": "15-05-1990",
        "puesto": "Gerente de ffff"
    },
    {
        "id": 12,
        "primerNombre": "ccccc",
        "segundoNombre": "jose",
        "apellidoPaterno": "González",
        "apellidoMaterno": "rfffff",
        "edad": 28,
        "sexo": "Masculino",
        "fechaNacimiento": "15-05-1990",
        "puesto": "Gerente de ffff"
    }
]
```



### Errores

### Estandar de errores
- **Descripción**: Todos los errores detonados por la aplicacion se visualizaran de la siguiente forma
### Ejemplo estandar de error:

```json
{
    "mensaje": "Request method 'DELETE' not supported",
    "code": "400 BAD_REQUEST"
}
```

## Contacto

- **Nombre Desarrollador**: Karla Montserrat Camacho Dominguez
- **Email**: karlacamacho535.d@gmail.com
- **Telefono**: 5620252061
