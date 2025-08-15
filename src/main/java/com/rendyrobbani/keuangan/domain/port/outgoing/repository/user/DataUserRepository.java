package com.rendyrobbani.keuangan.domain.port.outgoing.repository.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.*;

public interface DataUserRepository extends SelectRepository<DataUser, String>,
                                            CreateRepository<DataUser, String>,
                                            UpdateRepository<DataUser, String>,
                                            DeleteRepository<DataUser, String>,
                                            LockedRepository<DataUser, String> {

}