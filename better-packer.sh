#!/usr/bin/env bash

## ===================================================================================
## MAIN   MAIN   MAIN   MAIN   MAIN   MAIN   MAIN   MAIN   MAIN   MAIN   MAIN   MAIN
## ===================================================================================
DeveloperName=$(whoami)

# optionally use the developer name if supplied as the first script argument
if [ $# -eq 1 ]; then
  DeveloperName=$1
fi

ArchiveBasename=xamini-payments-service-submit
BuildDistDir=build/dist
PackagerName=${ArchiveBasename}-${DeveloperName}-$(date "+%Y%m%d")
PackagerDir=${BuildDistDir}/${PackagerName}

cat << EOF
Here is a much Better Packer
By Peter Pilgrim
7th December 2022

=====================================================================================
    Creating package name: ${PackagerName}
   Distribution directory: ${BuildDistDir}
=====================================================================================

EOF

mkdir -p "${PackagerDir}"

cp *.md *.sh .gitignore gradlew gradlew.bat build.gradle.kts "${PackagerDir}"
cp -r src "${PackagerDir}"



pushd ${BuildDistDir}

JarFileName=${PackagerName}.jar

cat << EOF

=====================================================================================
    Creating JarFileName [$JarFileName]
====================================================================================="

EOF

jar cvf ${JarFileName} ${PackagerName}



ZipFileName=${PackagerName}.zip

cat << EOF

=====================================================================================
    Creating ZipFileName [$ZipFileName]
====================================================================================="

EOF

zip -r ${ZipFileName}  ${PackagerName}

popd

echo "All Done."


