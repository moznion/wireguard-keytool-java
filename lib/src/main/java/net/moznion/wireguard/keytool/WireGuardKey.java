package net.moznion.wireguard.keytool;

import java.util.Base64;

/**
 * WireGuardKey is a data class for the WireGuard key-pair.
 */
public class WireGuardKey {
	private static final KeyStrategy keyStrategy = new X25519KeyStrategy();

	private final byte[] privateKey;

	/**
	 * A constructor for WireGuardKey.
	 *
	 * @param privateKey a bytes array of the private key.
	 */
	public WireGuardKey(final byte[] privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * A constructor for WireGuardKey.
	 *
	 * @param base64PrivateKey a base64 encoded private key string.
	 */
	public WireGuardKey(final String base64PrivateKey) {
		privateKey = Base64.getDecoder().decode(base64PrivateKey);
	}

	/**
	 * generate generates a WireGuardKey according to Curve25519 algorithm.
	 *
	 * @return a generated key.
	 */
	public static WireGuardKey generate() {
		return new WireGuardKey(keyStrategy.generatePrivateKey());
	}

	/**
	 * getPrivateKey returns a private key bytes array.
	 *
	 * @return a bytes array of the private key.
	 */
	public byte[] getPrivateKey() {
		return privateKey;
	}

	/**
	 * getBase64PrivateKey returns a base64 encoded private key.
	 *
	 * @return a base64 encoded private key.
	 */
	public String getBase64PrivateKey() {
		return Base64.getEncoder().encodeToString(getPrivateKey());
	}

	/**
	 * getPublicKey returns a public key bytes array that is associated with the private key.
	 *
	 * @return a bytes array of the public key
	 * @throws InvalidPrivateKeyException raises when the private key is invalid.
	 */
	public byte[] getPublicKey() throws InvalidPrivateKeyException {
		return keyStrategy.publicFromPrivate(getPrivateKey());
	}

	/**
	 * getBase64PublicKey returns a base64 encoded public key string that is associated with the private key.
	 *
	 * @return a base64 encoded public key string
	 * @throws InvalidPrivateKeyException raises when the private key is invalid.
	 */
	public String getBase64PublicKey() throws InvalidPrivateKeyException {
		return Base64.getEncoder().encodeToString(keyStrategy.publicFromPrivate(getPrivateKey()));
	}
}
