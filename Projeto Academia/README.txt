Formatação do Projeto:

Etapa 1

* Sistema autenticação
* Lista de colaboradores
* Inserir colaboradores
* Alterar colaboradores
* Consultar colaboradores
* Remover colaboradores

	Informação do Colaborador:
	
	* Nome, morada, telemóvel, idade, foto, e-mail, nº do doc de informação, pode adicionar CV em pdf
	* Pode alterar a foto

Etapa 2

Chat

Formato:

nome da pessoa: mensagem

nome da pessoa: mensagem

nome da pessoa: mensagem

caixa de introdução de texto, botão enviar

Usando Web Services


Base de Dados:

CREATE TABLE Colaboradores (
    ColaboradorID INT PRIMARY KEY,
    NOME VARCHAR2(250) NOT NULL,
    NumCartaoCidadao VARCHAR2(12) NULL,
    Morada VARCHAR2(400) NULL,
    Telemovel VARCHAR2(12) NULL,
    Email VARCHAR2(256) NULL,
    DataNascimento DATE NULL,
    Foto BLOB NULL,
    CV BLOB NULL
);


Users
	* Id -> PK   INT (not null)
	* Username   VARCHAR2 (20) (not null)
	* Password   VARCHAR2 (200) (not null)
	
Sessions
	* Id -> PK  INT (not null)
	* Id_User   VARCHAR2 (20) (not null)
	* S_Start   TIMESTAMP
	* S_Last    TIMESTAMP

