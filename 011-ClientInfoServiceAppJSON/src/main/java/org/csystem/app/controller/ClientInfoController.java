package org.csystem.app.controller;

import org.csystem.app.data.ClientInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
@Scope("prototype")
public class ClientInfoController {
    private final ClientInfo m_clientInfo;

    public ClientInfoController(ClientInfo clientInfo) {
        m_clientInfo = clientInfo;
    }

    @GetMapping("info")
    public ClientInfo getClientInfo() {
        return m_clientInfo;
    }
}
