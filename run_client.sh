#!/bin/bash

abort() {
    echo "$*"; exit 1
}

service_jar=~/.m2/repository/br/assessment/sorting-service/0.0.1-SNAPSHOT/sorting-service-0.0.1-SNAPSHOT.jar

file_path=$1

[ -z "$file_path" ] && file_path=src/main/resources/config.json
[ -f "$file_path" ] || abort "File not found: $file_path";

[ -f "$service_jar" ] || abort "You need to run maven install for the service project first"

client_jar=target/booksortclient-0.0.1-SNAPSHOT.jar
[ -f "$client_jar" ] || mvn clean package
mvn exec:java -Dexec.mainClass=br.assessment.booksortclient.App -Dexec.args="$file_path"
