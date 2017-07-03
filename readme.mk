### AndFix使用Demo

apkpatch.bat -f fix_test2.apk -t fix_test1.apk -o output -k fix.jks -p 123456 -a key0 -e 123456
apkpatch.bat -f 新apk -t 旧apk -o 输出目录 -k app签名文件 -p 签名文件密码 -a 签名文件别名 -e 别名密码