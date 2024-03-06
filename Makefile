#   __  __       _         __ _ _
#  |  \/  |     | |       / _(_) |
#  | \  / | __ _| | _____| |_ _| | ___
#  | |\/| |/ _` | |/ / _ \  _| | |/ _ \
#  | |  | | (_| |   <  __/ | | | |  __/
#  |_|  |_|\__,_|_|\_\___|_| |_|_|\___|

.PHONY: all

all:
	echo hey

#  __   __
# |  \ |_  \  /
# |__/ |__  \/
#

.PHONY: start
start: stop start-prometheus start-grafana

.PHONY: stop
stop: stop-prometheus stop-grafana

.PHONY: start-grafana
start-grafana: stop-grafana
	docker-compose -f grafana/docker-compose.yml up -d

.PHONY: stop-grafana
stop-grafana:
	docker-compose -f grafana/docker-compose.yml rm -s -f

.PHONY: start-prometheus
start-prometheus: stop-prometheus
	docker-compose -f prometheus/docker-compose.yml up -d

.PHONY: stop-prometheus
stop-prometheus:
	docker-compose -f prometheus/docker-compose.yml rm -s -f
