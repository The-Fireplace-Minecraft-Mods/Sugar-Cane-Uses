@ECHO OFF
TITLE The_Fireplace's Forge Tools - High Allocation Setup v1.0
call gradlew -DXmx4g setupDecompWorkspace idea
ECHO ****************************
ECHO Forge idea workspace setup complete!
ECHO ****************************
PAUSE