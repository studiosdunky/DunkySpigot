# DunkySpigot

Servidor Minecraft 1.8.8 da rede Dunky, baseado no WindSpigot.

## Compilação

Requer JDK 21 para compilar. Configure `JAVA_HOME` para esse JDK. O servidor mantém o requisito de Java 11 ou superior da base.

```powershell
./gradlew.bat clean build
```

Artefatos: `DunkySpigot-Server/build/libs/DunkySpigot.jar` e `DunkySpigot-API/build/libs/DunkySpigot-API.jar`.

```text
java -Duser.timezone=America/Sao_Paulo -Xms512M -Xmx2G -jar DunkySpigot.jar nogui
```

## Identidade e compatibilidade

O nome exibido pelo servidor, a versão, a configuração e os artefatos usam DunkySpigot. Config principal: `dunkyspigot.yml`. Use `--dunkyspigot-settings` para indicar outro arquivo; a opção original `--windspigot-settings` também funciona.
Os pacotes internos e os métodos públicos do WindSpigot foram preservados para manter a compatibilidade com plugins. Bukkit, Spigot e NMS também mantêm seus nomes originais.
As estatísticas enviadas ao projeto original ficam desativadas por padrão neste fork. As implementações de gameplay e otimização são as da base.

## Base e licença

Veja [UPSTREAM.md](UPSTREAM.md), o [README original](README-UPSTREAM.md) e a [licença](LICENSE). Os autores e os créditos dos patches foram preservados no código e no histórico Git.
