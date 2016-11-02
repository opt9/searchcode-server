package com.searchcode.app.config;

import junit.framework.TestCase;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SQLiteDatabaseConfigTest extends TestCase {

    /**
     * This should never fail if it does we have big problems
     */
    public void testConnection() throws Exception {
        SQLiteDatabaseConfig dao = new SQLiteDatabaseConfig();
        assertThat(dao.getConnection()).isNotNull();
    }
}
