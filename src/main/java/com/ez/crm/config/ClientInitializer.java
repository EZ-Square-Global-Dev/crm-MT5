package com.ez.crm.config;



import com.ez.crm.module.client.core.entity.ClientEntity;
import com.ez.crm.module.client.repository.ClientRepository;
import com.ez.crm.module.client.util.ClientUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ClientInitializer {

    private final ClientRepository clientRepository;

    public ClientInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostConstruct
    public void initDefaultClient() {
        String adminEmail = "admin@gmail.com";

        if (clientRepository.existsByEmail(adminEmail)) {
            return;
        }

        ClientEntity client = new ClientEntity();
        client.setEmail(adminEmail);
        client.setPassword(ClientUtil.sha256("123456"));
        client.setLanguage("En");
        client.setBalance(0.0);
        client.setTradingEnabled(true);
        client.setParticipationCount(0);

        clientRepository.save(client);
        System.out.println("✅ Default client created: " + adminEmail);
    }
}

