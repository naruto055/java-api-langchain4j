package com.naruto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naruto.entity.Appointment;

/**
 * @author wenqunsheng
 * @date 2025/5/13 9:25
 */
public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}
