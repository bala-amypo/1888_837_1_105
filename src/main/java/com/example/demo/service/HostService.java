package com.example.demo.service;

import com.example.demo.entity.Host;

import java.util.List;

public interface HostService {

    Host saveHost(Host host);

    List<Host> getAllHosts();

    Host getHostById(Long id);
}
