package com.rendyrobbani.keuangan.common.schema.constraint.foreign;

import java.util.List;

record ForeignKeyConstraintImpl(String name, List<String> columnNames, String referenceTableName, List<String> referenceColumnNames) implements ForeignKeyConstraint {

}