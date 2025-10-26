# 📱 SwagLabs Mobile — Serenity BDD + Appium (Android)

Automatización móvil del flujo **Login → Productos** en la app **SwagLabs (Android nativa)** usando:

- **Java 11**
- **Maven**
- **Serenity BDD (Screenplay + Cucumber)**
- **Appium (UiAutomator2)**

---

## ✅ Requisitos previos (una sola vez en tu PC)

1. **Java (JDK 11 o superior)**  
   Verifica:
   ```bash
   java -version
   ```

2. **Maven 3.9.x o superior**  
   Verifica:
   ```bash
   mvn -version
   ```

3. **Node.js y npm**  
   Verifica:
   ```bash
   node -v
   npm -v
   ```

4. **Appium Server**
   ```bash
   npm install -g appium
   appium -v
   appium driver install uiautomator2
   appium driver list   # Debe mostrar uiautomator2 instalado
   ```

5. **Android SDK / Platform Tools**
   ```bash
   adb version
   ```

6. (Opcional) **Verificar entorno**
   ```bash
   npm install -g appium-doctor
   appium-doctor --android
   ```

> ⚠️ El **APK de SwagLabs ya está incluido** en el proyecto (`apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk`).  
> No necesitas descargarlo manualmente.

---

## 📦 Clonar el proyecto

```bash
git clone https://github.com/<tu-usuario>/serenity-appium-swaglabs-mobile-tests.git
cd serenity-appium-swaglabs-mobile-tests
```

---

## 📱 Iniciar un dispositivo Android

1. Abre Android Studio → Device Manager  
2. Crea un emulador (Android 11+) y ejecútalo  
3. Verifica con `adb devices` que aparezca como `emulator-5554`

---

---

## ▶️ Ejecución de pruebas

1️⃣ Inicia Appium Server:
```bash
appium --base-path /wd/hub
```

2️⃣ Ejecuta las pruebas:
```bash
mvn clean test
```

---

## 📊 Reportes Serenity

Se generan automáticamente en:
```
target/site/serenity/index.html
```

### Cómo abrirlo
- IntelliJ → clic derecho → *Open in Browser → Chrome*  
- Explorador (Windows): `C:\Users\<TU_USUARIO>\Documents\serenity-appium-swaglabs-mobile-tests\target\site\serenity\index.html`

---


**Autor:** Jordy Ávila  
**Proyecto:** Serenity BDD + Appium Mobile Automation — SwagLabs (Android)
