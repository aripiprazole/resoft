echo "Generating build files..."
echo "  - clj -T:build uberjar"
clj -T:build uberjar
echo "  - native-image -jar target/resoft.jar --no-fallback --no-server target/resoft"
native-image -jar target/resoft.jar --no-fallback --no-server target/resoft