$ErrorActionPreference = "Stop"
& (Join-Path $PSScriptRoot "gradlew.bat") -p $PSScriptRoot clean build
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
