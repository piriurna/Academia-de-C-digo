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

Colaborador
	* id -> PK   INT (not null)
	* Nome       VARCHAR2 (250) (not null)
	* Morada     VARCHAR2 (100)
	* Número do Documento de Indentificação (NUM_DOC_IDENT) VARCHAR2 (50)
	* Idade      VARCHAR2 (3)
	* E-mail (EMAIL)     VARCHAR2 (256)
	* Telemóvel  VARCHAR2 (20)
	* Foto       BLOB
	* CV         BLOB


Users
	* Id -> PK   INT (not null)
	* Username   VARCHAR2 (20) (not null)
	* Password   VARCHAR2 (200) (not null)
	
Sessions
	* Id -> PK  INT (not null)
	* Id_User   VARCHAR2 (20) (not null)
	* S_Start   TIMESTAMP
	* S_Last    TIMESTAMP

