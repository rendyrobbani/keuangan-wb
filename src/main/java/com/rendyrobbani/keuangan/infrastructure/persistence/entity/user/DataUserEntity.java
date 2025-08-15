package com.rendyrobbani.keuangan.infrastructure.persistence.entity.user;

import com.rendyrobbani.keuangan.schema.user.DataUserTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = DataUserTable.NAME)
public class DataUserEntity extends AbstractDataUserEntity {

}