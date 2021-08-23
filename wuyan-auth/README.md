## 生成秘钥

``` shell
keytool -genkey -alias jwt -keyalg RSA -keypass wuyan.admin -keystore jwt.jks -storepass wuyan.admin -deststoretype pkcs12
```

``
-alias 别名 -keyalg 密钥算法 -keypass 密钥口令 -keystore 生成密钥库的存储路径和名称 -storepass 密钥库口令
``

## 生成公钥

``` shell
keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey
```