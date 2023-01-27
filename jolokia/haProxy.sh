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
docker run --sysctl net.ipv4.ip_unprivileged_port_start=0  -p 80:80 -p 8000:8000 -p 1936:1936  ha_proxy_jolokia &&
echo 'docker runing'
popd
