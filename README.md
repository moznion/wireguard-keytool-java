# wireguard-keytool-java

[![CI Check](https://github.com/moznion/wireguard-keytool-java/actions/workflows/check.yml/badge.svg)](https://github.com/moznion/wireguard-keytool-java/actions/workflows/check.yml) [![codecov](https://codecov.io/gh/moznion/wireguard-keytool-java/branch/main/graph/badge.svg?token=kuDdw3vYER)](https://codecov.io/gh/moznion/wireguard-keytool-java) [![Maven Central](https://img.shields.io/maven-central/v/net.moznion/wireguard-keytool.svg)](https://search.maven.org/artifact/net.moznion/wireguard-keytool/) [![javadoc](https://javadoc.io/badge2/net.moznion/wireguard-keytool/javadoc.svg)](https://javadoc.io/doc/net.moznion/wireguard-keytool)

An utility library for [WireGuard](https://www.wireguard.com/) keys that written in Java.

## Synopsis

```java
import net.moznion.wireguard.keytool.InvalidPrivateKeyException;
import net.moznion.wireguard.keytool.WireGuardKey;

class App {
    public static void doSomething() throws InvalidPrivateKeyException {
        final WireGuardKey generatedKey = WireGuardKey.generate();
        System.out.println(generatedKey.getBase64PrivateKey()); // => output: base64 encoded private key
        System.out.println(generatedKey.getBase64PublicKey()); // => output: base64 encoded public key
    }
}
```

## Documents

Please refer to the [![javadoc](https://javadoc.io/badge2/net.moznion/wireguard-keytool/javadoc.svg)](https://javadoc.io/doc/net.moznion/wireguard-keytool).

## Author

moznion (<moznion@mail.moznion.net>)
