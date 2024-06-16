# Endpoints de la API

## Equipos

### Obtener todos los equipos
- **Endpoint:** `/equipo`
- **Método:** GET
- **Respuesta:** Lista de equipos (200 OK), No encontrado (404).

### Obtener un equipo por ID
- **Endpoint:** `/equipo/{id}`
- **Método:** GET
- **Respuesta:** Detalles del equipo (200 OK), No encontrado (404).

### Obtener los puntos totales de un equipo por ID
- **Endpoint:** `/equipo/{id}/puntos`
- **Método:** GET
- **Respuesta:** Puntos totales del equipo (200 OK), No encontrado (404).

### Crear un nuevo equipo
- **Endpoint:** `/equipo`
- **Método:** POST
- **Cuerpo:** `{"name": "Nombre", "emblema": "URL"}`
- **Respuesta:** Equipo creado (201 Created), Solicitud incorrecta (400 Bad Request).

### Actualizar un equipo por ID
- **Endpoint:** `/equipo/{id}`
- **Método:** PUT
- **Cuerpo:** `{"name": "Nuevo Nombre", "emblema": "Nueva URL", "puntuacion": "Nueva Puntuacion"}`
- **Respuesta:** Equipo actualizado (200 OK), No encontrado (404).

### Eliminar un equipo por ID
- **Endpoint:** `/equipo/{id}`
- **Método:** DELETE
- **Respuesta:** Equipo eliminado (200 OK), No encontrado (404).

## Jugadores

### Obtener todos los jugadores
- **Endpoint:** `/jugador`
- **Método:** GET
- **Respuesta:** Lista de jugadores (200 OK), No encontrado (404).

### Obtener un jugador por ID
- **Endpoint:** `/jugador/{id}`
- **Método:** GET
- **Respuesta:** Detalles del jugador (200 OK), No encontrado (404).

### Crear un nuevo jugador
- **Endpoint:** `/jugador`
- **Método:** POST
- **Cuerpo:** `{"user": "Nombre", "avatarimg": "URL", "equipo": "ID del equipo"}`
- **Respuesta:** Jugador creado (201 Created).

### Actualizar un jugador por ID
- **Endpoint:** `/jugador/{id}`
- **Método:** PUT
- **Cuerpo:** `{"user": "Nuevo Nombre", "avatarimg": "Nueva URL", "equipo": "Nuevo ID del equipo"}`
- **Respuesta:** Jugador actualizado (200 OK), No encontrado (404).

### Eliminar un jugador por ID
- **Endpoint:** `/jugador/{id}`
- **Método:** DELETE
- **Respuesta:** Jugador eliminado (200 OK), No encontrado (404).

### Obtener jugadores por ID de equipo
- **Endpoint:** `/equipo/{id_equipo}/jugadores`
- **Método:** GET
- **Respuesta:** Lista de jugadores del equipo (200 OK), No encontrado (404).

## Juegos

### Obtener todos los juegos
- **Endpoint:** `/juego`
- **Método:** GET
- **Respuesta:** Lista de juegos (200 OK), No encontrado (404).

### Obtener un juego por ID
- **Endpoint:** `/juego/{id}`
- **Método:** GET
- **Respuesta:** Detalles del juego (200 OK), No encontrado (404).

### Crear un nuevo juego
- **Endpoint:** `/juego`
- **Método:** POST
- **Cuerpo:** `{"dificultadjuego": "Dificultad", "descripcion": "Descripción", "intentosDificultad": "Intentos"}`
- **Respuesta:** Juego creado (201 Created).

### Actualizar un juego por ID
- **Endpoint:** `/juego/{id}`
- **Método:** PUT
- **Cuerpo:** `{"dificultadjuego": "Nueva Dificultad", "descripcion": "Nueva Descripción", "intentosDificultad": "Nuevos Intentos"}`
- **Respuesta:** Juego actualizado (200 OK), No encontrado (404).

### Eliminar un juego por ID
- **Endpoint:** `/juego/{id}`
- **Método:** DELETE
- **Respuesta:** Juego eliminado (200 OK), No encontrado (404).

## Palabras

### Obtener una palabra aleatoria
- **Endpoint:** `/palabra`
- **Método:** GET
- **Respuesta:** Palabra aleatoria (200 OK), No encontrado (404).

### Obtener todas las palabras
- **Endpoint:** `/palabras`
- **Método:** GET
- **Respuesta:** Lista de palabras (200 OK), No encontrado (404).

### Obtener un número específico de palabras
- **Endpoint:** `/palabras/{numero}`
- **Método:** GET
- **Respuesta:** Lista de palabras (200 OK), No encontrado (404).

### Obtener una palabra filtrada
- **Endpoint:** `/palabra/filtro={filtro}`
- **Método:** GET
- **Respuesta:** Palabra filtrada (200 OK), No encontrado (404).

### Obtener todas las palabras filtradas
- **Endpoint:** `/palabras/filtro={filtro}`
- **Método:** GET
- **Respuesta:** Lista de palabras filtradas (200 OK), No encontrado (404).

## Partidas

### Obtener todas las partidas
- **Endpoint:** `/partida`
- **Método:** GET
- **Respuesta:** Lista de partidas (200 OK), No encontrado (404).

### Obtener una partida por ID
- **Endpoint:** `/partida/{id}`
- **Método:** GET
- **Respuesta:** Detalles de la partida (200 OK), No encontrado (404).

### Obtener puntos totales de un jugador
- **Endpoint:** `/jugador/{id}/puntos`
- **Método:** GET
- **Respuesta:** Puntos totales del jugador (200 OK), No encontrado (404).

### Crear una nueva partida
- **Endpoint:** `/partida`
- **Método:** POST
- **Cuerpo:** `{"startTime": "Fecha Inicio", "endTime": "Fecha Fin", "intentos": "Número de Intentos", "palabraRonda": "Palabra", "puntuacion": "Puntuación"}`
- **Respuesta:** Partida creada (201 Created).

### Actualizar una partida por ID
- **Endpoint:** `/partida/{id}`
- **Método:** PUT
- **Cuerpo:** `{"startTime": "Nueva Fecha Inicio", "endTime": "Nueva Fecha Fin", "intentos": "Nuevo Número de Intentos", "palabraRonda": "Nueva Palabra", "puntuacion": "Nueva Puntuación"}`
- **Respuesta:** Partida actualizada (200 OK), No encontrado (404).

### Eliminar una partida por ID
- **Endpoint:** `/partida/{id}`
- **Método:** DELETE
- **Respuesta:** Partida eliminada (200 OK), No encontrado (404).
