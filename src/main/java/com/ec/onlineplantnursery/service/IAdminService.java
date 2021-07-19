package com.ec.onlineplantnursery.service;

import com.ec.onlineplantnursery.entity.Admin;
import com.ec.onlineplantnursery.exceptions.AdminIdNotFoundException;

public interface IAdminService {

	Admin addAdmin(Admin admin);

    Admin updateAdmin (Admin admin) throws  AdminIdNotFoundException;

    Admin deleteAdmin (int adminId) throws AdminIdNotFoundException;
}
