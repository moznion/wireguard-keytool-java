package net.moznion.wireguard.keytool;

/**
 * InvalidKeyException is an exception class that is raised when the private key is invalid.
 */
public class InvalidPrivateKeyException extends Exception {
	private static final long serialVersionUID = -2057633104607917355L;

	InvalidPrivateKeyException(final Throwable e) {
		super(e);
	}
}
