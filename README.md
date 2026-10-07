# DunkySpigot

Servidor Minecraft 1.8.8 da rede Dunky, baseado no WindSpigot.

## CompilaÃ§Ã£o

Requer JDK 21 para compilar. Configure `JAVA_HOME` para esse JDK. O servidor mantÃ©m o requisito de Java 11 ou superior da base.

```powershell
./gradlew.bat clean build
```

Artefatos: `DunkySpigot-Server/build/libs/DunkySpigot.jar` e `DunkySpigot-API/build/libs/DunkySpigot-API.jar`.

```text
java -Duser.timezone=America/Sao_Paulo -Xms512M -Xmx2G -jar DunkySpigot.jar nogui
```

## Identidade e compatibilidade

O nome exibido pelo servidor, a versÃ£o, a configuraÃ§Ã£o e os artefatos usam DunkySpigot. Config principal: `dunkyspigot.yml`. Use `--dunkyspigot-settings` para indicar outro arquivo; a opÃ§Ã£o original `--windspigot-settings` tambÃ©m funciona.
Os pacotes internos e os mÃ©todos pÃºblicos do WindSpigot foram preservados para manter a compatibilidade com plugins. Bukkit, Spigot e NMS tambÃ©m mantÃªm seus nomes originais.
As estatÃ­sticas enviadas ao projeto original ficam desativadas por padrÃ£o neste fork. As implementaÃ§Ãµes de gameplay e otimizaÃ§Ã£o sÃ£o as da base.

## Base e licenÃ§a

Veja [UPSTREAM.md](UPSTREAM.md), o [README original](README-UPSTREAM.md) e a [licenÃ§a](LICENSE). Os autores e os crÃ©ditos dos patches foram preservados no cÃ³digo e no histÃ³rico Git.

O `build` também copia o JAR validado para `servers/lobby`, `servers/bridge` e `servers/bedwars`, quando a pasta da rede existe ao lado de `github`. Os arquivos `start.bat` desses servidores usam o DunkySpigot com Java 21 e fuso `America/Sao_Paulo`.
