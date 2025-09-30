# Demo de Cifrado AES en Modo CTR (Counter)

Este proyecto demuestra la implementación de cifrado y descifrado simétrico utilizando el algoritmo AES (Advanced Encryption Standard) en modo CTR (Counter) en Java.

## ¿Qué es el Modo CTR?

El modo CTR (Counter) es un modo de operación de cifrado por bloques que convierte un cifrado por bloques en un cifrado de flujo. Funciona generando un flujo de claves mediante el cifrado de valores consecutivos de un "contador".

### Ventajas del modo CTR:

- **Paralelización**: Permite el procesamiento en paralelo, lo que mejora el rendimiento.
- **Sin relleno**: No requiere relleno (padding) de los datos.
- **Acceso aleatorio**: Se puede acceder aleatoriamente a los datos cifrados.
- **Seguridad**: Es seguro cuando se implementa correctamente con un IV (vector de inicialización) único para cada mensaje.

## Estructura del Proyecto

```
ctrcounter/
├── src/
│   ├── CTRDemoInteractive.java  # Clase principal con implementación de cifrado/descifrado
├── .idea/                       # Configuración de IntelliJ IDEA
├── ctrcounter.iml               # Archivo de módulo de IntelliJ
└── README.md                    # Este archivo
```

## Funcionalidades Implementadas

1. **Generación de Claves**: Creación de claves seguras para AES.
2. **Generación de IV**: Creación de vectores de inicialización aleatorios.
3. **Cifrado**: Transformación de texto plano a texto cifrado usando AES/CTR.
4. **Descifrado**: Recuperación del texto original a partir del texto cifrado.
5. **Codificación Base64**: Para representar los datos binarios cifrados como texto.
6. **Simulación de Contador**: Visualización de cómo cambia el contador por cada bloque (en la versión interactiva).
7. **Entrada Interactiva**: Posibilidad de ingresar texto personalizado para cifrar (en la versión interactiva).

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **javax.crypto**: API de Java para operaciones criptográficas.
- **IntelliJ IDEA**: Entorno de desarrollo integrado.
- **Scanner**: Para la entrada interactiva de usuario.

## Cómo Ejecutar

### Versión Interactiva
1. Abra el proyecto en IntelliJ IDEA.
2. Ejecute la clase `CTRDemoInteractive.java`.
3. Siga las instrucciones en la consola para ingresar texto y ver el proceso de cifrado/descifrado.
4. Observe la simulación del contador que muestra cómo cambia para cada bloque de datos.

## Ejemplo de Uso

```java
// Generar clave y vector de inicialización
SecretKey secretKey = generateKey();
byte[] iv = generateIV();

// Cifrar un mensaje
String originalText = "Mensaje secreto";
String encryptedText = encrypt(originalText, secretKey, iv);

// Descifrar el mensaje
String decryptedText = decrypt(encryptedText, secretKey, iv);
```

## Seguridad

- Utiliza claves AES de 256 bits para máxima seguridad.
- Genera vectores de inicialización aleatorios para cada operación de cifrado.
- Implementa el modo CTR que es resistente a ataques de texto plano conocido.

## Participantes

- Isael Fatama (isael.fatama@vallegrande.edu.pe)
- Maria Lazaro (maria.lazaro@vallegrande.edu.pe)
- Johan Malasquez (johan.malasquez@vallegrande.edu.pe)

## Iconos y Recursos

🔐 Cifrado Seguro
🔑 Gestión de Claves
🔄 Modo CTR
📊 Procesamiento de Datos
🛡️ Seguridad de la Información