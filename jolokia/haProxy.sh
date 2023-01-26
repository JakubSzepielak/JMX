#!/bin/bash

pushd .
cd haproxy
echo '-------'
echo $(pwd)
echo '-------'
docker build -t ha_proxy_jolokia . &&
echo 'docker builded'
docker run -it --rm ha_proxy_jolokia haproxy -c -f /usr/local/etc/haproxy/haproxy.cfg &&
echo 'cfg rested'
docker run -d ha_proxy_jolokia -p 8080:80 &&
echo 'docker runing'
popd
