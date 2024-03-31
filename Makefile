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
start: stop start-prometheus start-grafana start-weather

.PHONY: stop
stop: stop-prometheus stop-grafana stop-weather

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

.PHONY: start-weather
start-weather: stop-weather
	docker-compose -f ./docker-compose.yml up -d

.PHONY: stop-weather
stop-weather:
	docker-compose -f ./docker-compose.yml rm -s -f

.PHONY: build
build:
	cd ./weather-service; ./gradlew clean assemble
	cd ./weather-service; docker build --build-arg target=weather-service -t weather-service -f ./Dockerfile .
