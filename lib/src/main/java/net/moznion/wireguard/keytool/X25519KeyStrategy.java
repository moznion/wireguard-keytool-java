package net.moznion.wireguard.keytool;

import com.google.crypto.tink.subtle.X25519;

class X25519KeyStrategy implements KeyStrategy {
	@Override
	public byte[] generatePrivateKey() {
		return X25519.generatePrivateKey();
	}

	@Override
	public byte[] publicFromPrivate(byte[] privateKey) throws InvalidPrivateKeyException {
		try {
			return X25519.publicFromPrivate(privateKey);
		} catch (java.security.InvalidKeyException e) {
			throw new InvalidPrivateKeyException(e);
		}
	}
}
