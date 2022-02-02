package com.zee.zee5app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {
	
	// By default all tables should end with '_table'
	// We don't want to apply this '_table' for each and every entity specification
	// We want to set it as a thumb rule
	private final static String POSTFIX = "_table";
	
	@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		
		if(identifier == null) {
			return null;
		}
		final String newName = identifier.getText() + POSTFIX;
		// 1.) If @Table annotation is available, then it will use that name
		// 2.) If @Table is not there, then it will take entity name
		// 3.) IF entity name is not available, then by default it will take class name
		return Identifier.toIdentifier(newName);
	}
	
	@Override
	public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment context) {
		
		if(identifier == null) {
			return null;
		}
		
		return Identifier.toIdentifier(identifier.getText().toLowerCase());
	}
	
}
