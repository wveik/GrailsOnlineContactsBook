dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            pooled = true
            logSql = true
            dbCreate = "update" // one of 'create',create-drop 'create-drop','update'
            url = "jdbc:postgresql://localhost:5432/online_contacts_book"
            driverClassName = "org.postgresql.Driver"
            username = "admin"
            password = "123456"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            pooled = true
            logSql = false
            dbCreate = "update" // one of 'create',create-drop 'create-drop','update'
//            jndiName = "java:comp/env/jdbc/ctservice"

            url = "jdbc:postgresql://localhost:5432/online_contacts_book"
            driverClassName = "org.postgresql.Driver"
            username = "admin"
            password = "123456"
        }
    }
}