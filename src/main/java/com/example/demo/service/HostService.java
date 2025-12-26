package com.example.demo.service;

import com.example.demo.entity.Host;
import java.util.List;

public interface HostService {

    Host createHost(Host host);

    List<Host> getAllHosts();
}
