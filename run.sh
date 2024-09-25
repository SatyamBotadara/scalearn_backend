docker build -t scalearn:latest . &&
docker run -d -p 8082:8082 --network=scalearn_net --name=backend scalearn:latest 