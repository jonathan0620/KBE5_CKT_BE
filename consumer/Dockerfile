# 사용할 기본 이미지
FROM amazoncorretto:17

# 작업 디렉토리
WORKDIR /app

# Pinpoint Agent 복사 (collector에서 한 것처럼)
COPY pinpoint-agent-2.5.4 /app/pinpoint-agent-2.5.4

# JAR 파일 복사
COPY ./collector/build/libs/*.jar app.jar

# Pinpoint agent 적용
ENTRYPOINT ["java", \
  "-javaagent:/app/pinpoint-agent-2.5.4/pinpoint-bootstrap-2.5.4.jar", \
  "-Dpinpoint.agentId=${HOSTNAME}-consumer", \
  "-Dpinpoint.applicationName=consumer-app", \
  "-Dprofiler.transport.grpc.collector.ip=pinpoint-collector", \
  "-Dprofiler.transport.grpc.collector.port=9991", \
  "-Dprofiler.collector.ip=pinpoint-collector", \
  "-Dprofiler.collector.agent.port=9991", \
  "-Dprofiler.collector.span.port=9996", \
  "-Dprofiler.collector.stat.port=9995", \
  "-Dprofiler.collector.tcp.port=9994", \
  "-jar", "app.jar"]
