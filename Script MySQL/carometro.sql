-- Criando Banco de Dados Para a Aplicação
CREATE DATABASE carometro
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_general_ci;

-- Criando usuario que irá acessar o Banco
CREATE USER "MySQL"@"localhost" IDENTIFIED BY "123456";
GRANT SELECT ON carometro.* TO "MySQL"@"localhost";

USE carometro;

-- Tabela aluno
CREATE TABLE aluno (
    ra VARCHAR(255) NOT NULL,
    curso VARCHAR(255),
    foto VARCHAR(255),
    nome VARCHAR(255),
    semestreconclusao DATE,
    PRIMARY KEY (ra)
) ENGINE=InnoDB;

-- Tabela aluno_links
CREATE TABLE aluno_links (
    aluno_ra VARCHAR(255) NOT NULL,
    url VARCHAR(255),
    tipo_link VARCHAR(255) NOT NULL,
    PRIMARY KEY (aluno_ra, tipo_link),
    CONSTRAINT fk_aluno_links_aluno FOREIGN KEY (aluno_ra) REFERENCES aluno(ra) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Tabela comentario
CREATE TABLE comentario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data DATE,
    descricao VARCHAR(255),
    tipo VARCHAR(255),
    aluno_ra VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT fk_comentario_aluno FOREIGN KEY (aluno_ra) REFERENCES aluno(ra) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Tabela historico
CREATE TABLE historico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    atividade VARCHAR(255),
    empresa VARCHAR(255),
    tempoempresa DATE,
    aluno_ra VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT fk_historico_aluno FOREIGN KEY (aluno_ra) REFERENCES aluno(ra) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
