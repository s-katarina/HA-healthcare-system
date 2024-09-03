FROM bitnami/postgresql:latest

COPY init-db.sh /docker-entrypoint-initd.b/
RUN chmod +x /docker-entrypoint-initd.b/init-db.sh

COPY ./init-primary.sh /init_primary.sh
RUN chmod +x /init-primary.sh
ENTRYPOINT ["/init_primary.sh"]

ENV POSTGRESQL_REPLICATION_MODE=master
ENV POSTGRESQL_REPLICATION_USER=replicator
ENV POSTGRESQL_REPLICATION_PASSWORD=replicator
ENV POSTGRESQL_USERNAME=admin
ENV POSTGRESQL_PASSWORD=admin
ENV POSTGRESQL_DATABASE=patient_core_db

EXPOSE 5432
