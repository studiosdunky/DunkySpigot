# DunkySpigot

Servidor Minecraft 1.8.8 mantido pela StudiosDunky, baseado no WindSpigot.

## Compilação

Requer JDK 21 para executar o build Gradle e JDK 8 para compilar e testar o servidor. Configure `JAVA_HOME` para o JDK 21 e `JAVA8_HOME` para o JDK 8.

```powershell
./gradlew.bat clean build
```

Artefatos: `DunkySpigot-Server/build/libs/DunkySpigot.jar` e `DunkySpigot-API/build/libs/DunkySpigot-API.jar`.

O build também copia o JAR validado para `servers/lobby`, `servers/bridge` e `servers/bedwars` na estrutura local da rede. O servidor roda em Java 8.

```text
java -Duser.timezone=America/Sao_Paulo -Xms512M -Xmx2G -jar DunkySpigot.jar nogui
```

`./gradlew.bat publicarVersao` publica o JAR e seu estado de versão no clone irmão `github/jars`. O fluxo de publicação faz o commit e o push desse repositório.

## Identidade e compatibilidade

O nome exibido, a versão, a configuração principal e os artefatos usam DunkySpigot. A configuração principal é `dunkyspigot.yml`; use `--dunkyspigot-settings` para indicar outro arquivo. As opções e os arquivos legados permanecem disponíveis para preservar as configurações existentes.

Os pacotes internos e métodos públicos do WindSpigot foram preservados para compatibilidade com plugins. Bukkit, Spigot e NMS mantêm seus nomes originais. As estatísticas enviadas ao projeto original ficam desativadas por padrão.

## Atualização do servidor

Toda a lógica de atualização pertence ao DunkyUpdater. Nenhum hook de atualização foi acrescentado ao código deste servidor.

O Updater deixa o core novo em `plugins/DunkyUpdater/runtime/DunkySpigot.jar`. No Linux, o Updater aplica a atualização por troca atômica durante o desligamento. No Windows, os `start.bat` da rede aplicam o arquivo pendente antes da inicialização. Não é necessário mudar o comando de inicialização no Pterodactyl/Linux.

## Créditos

A base direta é [WindSpigot](https://github.com/Wind-Development/WindSpigot), incluindo o trabalho dos seus autores e contribuidores.

A cadeia de origem inclui [NachoSpigot](https://github.com/CobbleSword/NachoSpigot), [TacoSpigot](https://github.com/TacoSpigot/TacoSpigot), [Paper](https://github.com/PaperMC/Paper), [Spigot/CraftBukkit](https://www.spigotmc.org/) e [Bukkit](https://github.com/Bukkit/Bukkit).

Os patches da base também creditam [PandaSpigot](https://github.com/hpfxd/PandaSpigot), [SportPaper](https://github.com/Electroid/SportPaper), Tuinity, InsanePaper, IonSpigot, BeerSpigot, Torch e outros projetos e autores. A lista integral de atribuições está no [README original](README-UPSTREAM.md), nos comentários dos patches e no histórico Git, que foram preservados. Veja [UPSTREAM.md](UPSTREAM.md) para o commit de referência.

## Licença

O projeto mantém a **GNU GPL versão 3**, conforme a [licença original](LICENSE), inclusive a licença da API. As alterações da StudiosDunky seguem essa licença. Os avisos de terceiros e os créditos originais permanecem válidos; veja [COPYRIGHT.md](COPYRIGHT.md).
