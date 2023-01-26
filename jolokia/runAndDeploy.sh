#!/bin/bash

mvn clean install &&
docker build -t jolokia . &&
docker run -p 8443:8443 -p 5000:5000 -p 5001:5001 jolokia:latest