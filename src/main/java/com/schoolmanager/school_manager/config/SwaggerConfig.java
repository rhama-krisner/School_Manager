package com.schoolmanager.school_manager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Impacto Manager API") // Adicione um título mais descritivo para a sua API
                        .version("1.0.0") // Mantenha a versão da sua API atualizada
                        .description("Esta é uma API feita em SpringBoot 3 que permite gerenciar professores e alunos de uma instituição de ensino. A API segue o padrão OpenAPI 3.0.1 e tem dois controladores: professor-controller e aluno-controller. Cada controlador permite operações CRUD (criar, ler, atualizar e deletar) sobre as entidades Professor e Aluno, respectivamente. A API usa o formato JSON para as requisições e respostas.") // Adicione uma descrição mais detalhada para a sua API
                        .license(new License()
                                .name("MIT") // Altere a licença da sua API se necessário
                                .url("https://opensource.org/licenses/MIT")) // Adicione a URL da licença da sua API
                );
    }
}
