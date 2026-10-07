$ErrorActionPreference = "Stop"
if (-not $env:JAVA8_HOME) {
    $localJava8 = Join-Path $env:USERPROFILE ".jdks\azul-1.8.0_504"
    if (Test-Path -LiteralPath $localJava8) { $env:JAVA8_HOME = $localJava8 }
}
& (Join-Path $PSScriptRoot "gradlew.bat") -p $PSScriptRoot clean build
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
