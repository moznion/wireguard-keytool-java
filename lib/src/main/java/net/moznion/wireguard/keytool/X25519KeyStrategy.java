package net.moznion.wireguard.keytool;

import com.google.crypto.tink.subtle.X25519;
import java.security.InvalidKeyException;

class X25519KeyStrategy implements KeyStrategy {
	@Override
	public byte[] generatePrivateKey() {
		return X25519.generatePrivateKey();
	}

	@Override
	public byte[] publicFromPrivate(final byte[] privateKey) throws InvalidPrivateKeyException {
		try {
			return X25519.publicFromPrivate(privateKey);
		} catch (java.security.InvalidKeyException e) {
			throw new InvalidPrivateKeyException(e);
		}
	}

	@Override
	public boolean isValidKey(final byte[] key) {
		try {
			X25519.publicFromPrivate(key);
		} catch (InvalidKeyException e) {
			return false;
		}
		return true;
	}
}
