package com.springsource.greenhouse.config.database;

import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.springsource.greenhouse.database.DatabaseUpgrader;

public class GreenhouseDatabaseInstallerTest {

	@Test
	public void runUpgrader() {
		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
		factory.setDatabaseType(EmbeddedDatabaseType.H2);
		EmbeddedDatabase db = factory.getDatabase();
		DatabaseUpgrader installer = new DatabaseUpgrader(db);
		installer.run();
		installer.run();
		DatabaseUpgrader installer2 = new DatabaseUpgrader(db);
		installer2.run();
	}
}
