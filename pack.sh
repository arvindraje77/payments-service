#!/usr/bin/env bash

JarFileName=xamini-payment-service-submit-$(whoami)-$(date "+%Y%m%d").jar

echo "====================================================================================="
echo "Creating JarFileName [$JarFileName]"
echo "====================================================================================="

jar cvf ${JarFileName} *.md *.sh \
  .gitignore gradlew gradlew.bat \
  gradle/wrapper/gradle-wrapper.properties \
  build.gradle.kts src


ZipFileName=xamini-payment-service-submit-$(whoami)-$(date "+%Y%m%d").zip

echo "====================================================================================="
echo "Creating ZipFileName [$ZipFileName]"
echo "====================================================================================="

zip -r ${ZipFileName} *.md *,sh \
  .gitignore gradlew gradlew.bat \
  gradle/wrapper/gradle-wrapper.properties \
  build.gradle.kts src

echo "Done."
