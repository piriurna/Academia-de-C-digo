CREATE TABLE Colaboradores (
    ColaboradorID INT PRIMARY KEY,
    NOME VARCHAR2(250) NOT NULL,
    NumCartaoCidadao VARCHAR2(12) NOT NULL,
    Morada VARCHAR2(400) NULL,
    Telemovel VARCHAR2(12) NULL,
    Email VARCHAR2(256) NULL,
    DataNascimento DATE NULL,
    Foto BLOB NULL,
    CV BLOB NULL
);