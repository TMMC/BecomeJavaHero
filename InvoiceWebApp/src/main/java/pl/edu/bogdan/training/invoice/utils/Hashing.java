package pl.edu.bogdan.training.invoice.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hashing {
	public static String hash(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(msg.getBytes());
			Base64.Encoder encoder = Base64.getEncoder();
			return encoder.encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			return msg;
		}
	}
}
