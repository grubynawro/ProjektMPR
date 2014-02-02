package db;

import db.EntityOper;

public abstract class Entity {

	protected int id;

	protected EntityOper operation = EntityOper.none;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntityOper getOper() {
		return operation;
	}

	public void setOperation(EntityOper operation) {
		this.operation = operation;
	}
	
}