# Automatización Mobile - SwagLabs (Serenity BDD + Cucumber + Appium)

## Requisitos
- **JDK**: 8, 11 o 17 (recomendado 11)
- **Maven**: 3.9.1
- **Android Studio/SDK** con `adb` y un emulador Android 10+ (o dispositivo real con Depuración USB)
- **Node.js** y **Appium Server**:
  ```bash
  npm install -g appium appium-doctor
  appium-doctor --android
  ```

## Configuración
1. Descarga el APK de SwagLabs (Android) y coloca su **ruta absoluta** en `serenity.properties` en la clave:
   ```
   appium.app=${user.dir}/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk
   ```

2. Prepara credenciales (opcional): el test leerá primero `src/test/resources/data/credentials.json`; si no lo encuentra o está vacío, intentará `credentials.csv`; si tampoco está, usará por defecto `standard_user / secret_sauce`.
   - JSON (`src/test/resources/data/credentials.json`):
     ```json
     { "user": "standard_user", "pass": "secret_sauce" }
     ```
   - CSV (`src/test/resources/data/credentials.csv`):
     ```csv
     user,pass
     standard_user,secret_sauce
     ```

## Ejecutar
1. Inicia Appium en una terminal:
   ```bash
   appium --base-path /wd/hub
   ```
2. Inicia/empareja tu emulador o conecta el dispositivo y verifica con:
   ```bash
   adb devices
   ```
3. En el proyecto:
   ```bash
   mvn clean test
   ```

## Reportes
- Abre `target/site/serenity/index.html` tras la ejecución.

## Estructura (Screenplay)
- **UI**: `screenplay/ui` (elementos/locators)
- **Tasks**: `screenplay/tasks` (acciones del actor)
- **Questions**: `screenplay/questions` (validaciones)
- **Steps**: `stepdefinitions` (Glue Cucumber)
- **Runner**: `runner/CucumberTestSuite.java`
- **Feature**: `src/test/resources/features/login.feature`

## Notas
- Si un locator falla, inspecciónalo con **Appium Inspector** y ajusta los XPaths/IDs.
- Recomendado fijar JAVA_HOME y ANDROID_HOME correctamente, y tener habilitado `adb` en PATH.
