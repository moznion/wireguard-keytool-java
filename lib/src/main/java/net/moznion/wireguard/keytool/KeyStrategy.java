package net.moznion.wireguard.keytool;

interface KeyStrategy {
	byte[] generatePrivateKey();

	byte[] publicFromPrivate(byte[] privateKey) throws InvalidPrivateKeyException;
}
