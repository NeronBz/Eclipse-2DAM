package Ejercicios;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class FirmarDocumento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			KeyPairGenerator claves = KeyPairGenerator.getInstance("RSA");
			claves.initialize(2048);
			KeyPair parDeClaves = claves.generateKeyPair();

			PrivateKey clavePrivada = parDeClaves.getPrivate();
			PublicKey clavePublica = parDeClaves.getPublic();

			// Mensaje o documento a firmar
			String mensaje = "Documento a firmar - IES Augustobriga";
			byte[] datos = mensaje.getBytes("UTF-8");

			// Crear la firma
			Signature firma = Signature.getInstance("SHA256withRSA");

			firma.initSign(clavePrivada);
			firma.update(datos);

			// Firmamos digitalmente los datos
			byte[] firmaBytes = firma.sign();

			System.out.println("Firma: " + java.util.Base64.getEncoder().encodeToString(firmaBytes));

			// Comprobación -- se debería de hacer en otro equipo
			Signature verificador = Signature.getInstance("SHA256withRSA");
			verificador.initVerify(clavePublica);
			verificador.update(datos);

			boolean esValida = verificador.verify(firmaBytes);

			System.out.println("¿Firma válida? " + esValida);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
