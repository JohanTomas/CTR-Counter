import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.util.Scanner;

public class CTRDemoInteractive {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 1️⃣ Solicitar texto al usuario
        System.out.print("Ingrese el texto a cifrar: ");
        String plaintext = scanner.nextLine();

        // 2️⃣ Generar clave AES (128 bits)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        // 3️⃣ Crear un IV de 16 bytes (contador inicial)
        byte[] ivBytes = new byte[16];
        for (int i = 0; i < ivBytes.length; i++) {
            ivBytes[i] = (byte) (Math.random() * 256);
        }
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        System.out.println("\n🔐 Clave generada (Base64): " + Base64.getEncoder().encodeToString(key.getEncoded()));
        System.out.println("🧮 IV inicial (contador) Base64: " + Base64.getEncoder().encodeToString(ivBytes));

        // 4️⃣ Configurar modo CTR
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");

        // 5️⃣ Cifrar
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        String encryptedBase64 = Base64.getEncoder().encodeToString(ciphertext);

        System.out.println("\n--- Resultado del Cifrado ---");
        System.out.println("Texto original: " + plaintext);
        System.out.println("Texto cifrado (Base64): " + encryptedBase64);

        // 6️⃣ Simular contador (mostrar cómo cambia por bloque)
        System.out.println("\n🔢 Simulación del contador en bloques:");
        for (int i = 0; i < ciphertext.length / 16 + 1; i++) {
            byte[] counter = ivBytes.clone();
            counter[15] += i; // Incrementamos el último byte
            System.out.printf("Bloque %d → IV actual: %s\n", i,
                    Base64.getEncoder().encodeToString(counter));
        }

        // 7️⃣ Descifrar
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decrypted = cipher.doFinal(ciphertext);

        System.out.println("\n--- Resultado del Descifrado ---");
        System.out.println("Texto descifrado: " + new String(decrypted));

        scanner.close();
    }
}
