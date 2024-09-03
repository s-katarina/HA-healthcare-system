#!/bin/bash

# Create recovery.conf for replication
echo "standby_mode = 'on'" > /opt/bitnami/postgresql/data/recovery.conf
echo "primary_conninfo = 'host=postgres-primary port=5432 user=repl_user password=repl_password'" >> /opt/bitnami/postgresql/data/recovery.conf
echo "trigger_file = '/tmp/postgresql.trigger'" >> /opt/bitnami/postgresql/data/recovery.conf
