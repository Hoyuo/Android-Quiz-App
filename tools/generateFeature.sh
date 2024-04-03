set -e

SCRIPT_DIR=$(dirname $0)
cd $SCRIPT_DIR/..

./gradlew --quiet tools:feature-template:clean
./gradlew --quiet tools:feature-template:installDist

exec ./tools/feature-template/build/install/feature-template/bin/feature-template

