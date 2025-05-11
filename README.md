# 💱 Conversor de Monedas Java

Este proyecto es un **conversor de monedas** hecho en Java que utiliza la [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio en tiempo real.

### 🚀 Funcionalidades

- Conversión entre monedas:
    - USD ↔ ARS
    - USD ↔ BRL
    - USD ↔ PEN
- Entrada de valores por consola
- Manejo de errores y validación de entradas
- Llamadas HTTP y parseo de JSON usando `HttpClient` y `Gson`

### 🛠️ Tecnologías usadas

- Java 17+ (o compatible)
- [ExchangeRate-API](https://www.exchangerate-api.com/)
- [Gson](https://github.com/google/gson)

### 📦 Estructura del Proyecto

```bash
com.AluraProyecto.ConversorDeDivisas
├── Principal
│ └──Principal.java
├── ConsultaApi
│ └── ConsultaAPI.java
├── Divisa
│ └── Divisa.java
```

### 🧪 Ejecución

#### 1. Clona el repositorio:
```git bash
   git clone https://github.com/zaidarosales/ProyectoAlura--ConversorDeMonedas.git
   cd ConversorDeDivisas
```
#### 2. Asegúrate de tener Java y Gson instalados.

#### 3. Compila y ejecuta:
```bash
  javac -cp gson-2.10.1.jar com/AlurPproyecto/ConversorDeDivisas/**/*.java
  java -cp .:gson-2.10.1.jar com.AluraProyecto.ConversorDeDivisas.Principal
```
📌 Nota: Reemplaza "a5d6e5d386a8e4006adf9d20" con tu propia API Key de ExchangeRate-API para que funcione correctamente.

### 📝 Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](./LICENSE) para más detalles.