# jpa-ddl

Use JPA 2.1 to generate database tables, load initial data via SQL statements, and emit DDL statements.

Two versions are presented, one that uses plain Tomcat with EclipseLink bundled in the WAR file, and another one that uses TomEE with EclipseLink (this version needs EclipseLink to be manually installed). The two versions are very similar. The TomEE version is a bit simpler since it utilizes Java EE features such as container managed transactions.
