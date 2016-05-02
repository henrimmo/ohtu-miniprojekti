#!/usr/bin/env bash
# Start a server specifically for easyB tests
java -Dspring.profiles.active=dev -Dserver.port=8080 -jar  target/ohtu-miniprojekti-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &
SPRING_PID=$!
echo $SPRING_PID

sleep 30s # Give the server enough time to start

mvn integration-test
RETURN_CODE=$?

# If integration test didn't succeed, exit with an error to signal
# the tests failed
if [ $RETURN_CODE != 0 ]; then
	kill $SPRING_PID;
	exit 1;
fi

# Shutdown the easyB server
kill $SPRING_PID
