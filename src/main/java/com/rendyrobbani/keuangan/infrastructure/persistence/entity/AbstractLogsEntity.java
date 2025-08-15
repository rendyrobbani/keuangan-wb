package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Logs;

public abstract class AbstractLogsEntity<SUBJECT extends AbstractDataEntity<SUBJECT, SUBJECTID>, SUBJECTID> implements Logs<SUBJECT, SUBJECTID> {

}