#!/bin/bash

set -e

#echo "host replication repl_user 0.0.0.0/0 md5" >> /opt/bitnami/postgresql/conf/pg_hba.conf
## shellcheck disable=SC2129
#echo "wal_level = replica" >> /opt/bitnami/postgresql/conf/postgresql.conf
#echo "max_wal_senders = 10" >> /opt/bitnami/postgresql/conf/postgresql.conf
#echo "hot_standby = on" >> /opt/bitnami/postgresql/conf/postgresql.conf
#echo "synchronous_commit = on" >> /opt/bitnami/postgresql/conf/postgresql.conf

# Create recovery.conf for replication
echo "standby_mode = 'on'" > /opt/bitnami/postgresql/data/recovery.conf
echo "primary_conninfo = 'host=postgres-primary port=5432 user=replicator password=replicator'" >> /opt/bitnami/postgresql/data/recovery.conf
echo "trigger_file = '/tmp/postgresql.trigger'" >> /opt/bitnami/postgresql/data/recovery.conf
