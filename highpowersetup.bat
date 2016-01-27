@ECHO OFF
TITLE The_Fireplace's Forge Tools - High Allocation Setup v1.0
call gradlew -DXms3g -DXmx6g setupDecompWorkspace idea
ECHO ****************************
ECHO Forge idea workspace setup complete!
ECHO ****************************
PAUSE