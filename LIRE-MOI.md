# Asphalte Neon Run — projet Android reconstitue

Les trois fichiers du jeu proviennent du site ASPHALTE existant. L'enveloppe Android a ete recreee. Aucune publicite, permission Internet ou connexion joueur. Le record reste sur l'appareil.

Ce ZIP contient le projet, pas une application installable. La compilation et les tests sur Android n'ont pas encore ete executes. Java 17, Gradle 8.13, Android Gradle Plugin 8.13.0, SDK 36.

## Depuis un telephone
1. Se connecter sur github.com et creer un depot PRIVE, par exemple asphalte-android.
2. Extraire le ZIP. Mettre les fichiers du dossier Asphalte-Android a la racine du depot (app, settings.gradle, build.gradle, etc.). Ne pas envoyer seulement le ZIP : GitHub ne le decompresse pas pour compiler.
3. Creer le fichier .github/workflows/android.yml en copiant le contenu du fichier fourni si le gestionnaire de fichiers du telephone masque le dossier .github. Le site GitHub en mode « Site pour ordinateur » peut faciliter ces operations.
4. Dans Actions, choisir « Compiler Android », puis « Run workflow ».
5. Une fois termine avec succes, telecharger Asphalte-APK-test dans Artifacts et extraire l'APK pour tester sur le telephone. L'APK est signe automatiquement avec une cle de TEST.
6. Asphalte-AAB-NON-SIGNE contient un AAB non signe : NE PAS le deposer sur Google Play. Une cle de signature d'envoi durable doit etre configuree avant publication. Ne pas generer une nouvelle cle a chaque compilation. Conserver la cle et ses mots de passe dans un endroit prive et sauvegarde.

## Avant Google Play
Confirmer l'identifiant com.sabaros.asphalteneon avant la premiere publication ; verifier les commandes, la mise en pause, les collisions, le record et la rotation sur un appareil reel. Preparer la signature d'envoi, la fiche, les captures, les declarations et les tests demandes dans votre Play Console. L'acceptation par Google n'est pas garantie.

## Compilation locale facultative
Avec JDK 17, SDK Android 36 et Gradle 8.13 installes :
`gradle assembleDebug bundleRelease lintDebug`

Sources outils : https://developer.android.com/build/releases/about-agp et https://docs.github.com/en/actions/tutorials/build-and-test-code/java-with-gradle
