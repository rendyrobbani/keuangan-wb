package com.rendyrobbani.keuangan.common.schema.constraint.primary;

import java.util.List;

record PrimaryConstraintImpl(List<String> columnNames) implements PrimaryConstraint {

}