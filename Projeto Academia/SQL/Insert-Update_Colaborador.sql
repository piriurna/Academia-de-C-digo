CREATE OR REPLACE PROCEDURE UPDATE_COLABORADOR 
(
  vNOME IN VARCHAR2 
, vNUMCARTAOCIDADAO IN VARCHAR2 
, vMORADA IN VARCHAR2 
, vTELEMOVEL IN VARCHAR2 
, vEMAIL IN VARCHAR2 
, vDATANASCIMENTO IN DATE
, vFOTO IN BLOB 
, vCV IN BLOB 
) AS 
    vNum_Registros INT;
BEGIN
    SELECT COUNT(*) INTO vNum_Registros FROM Colaborador WHERE numcartaocidadao = vnumcartaocidadao;

  IF vNum_Registros < 1 THEN
    INSERT INTO Colaborador(id, nome, Numcartaocidadao, Morada, Telemovel, Email, Datanascimento, Foto, Cv) 
    VALUES (COLABORADOR_SEQUENCE.nextval, vNome, vNumcartaocidadao, vMorada, vTelemovel, vEmail, vDatanascimento, vFoto, vCv);
  ELSE
    UPDATE Colaborador
    SET Colaborador.nome = vNome,
        Colaborador.Morada = vMorada,
        Colaborador.telemovel = vTelemovel,
        colaborador.email = vEmail,
        colaborador.datanascimento = vDatanascimento,
        colaborador.foto = vFoto,
        colaborador.cv = cv;
  END IF;
END UPDATE_COLABORADOR;
