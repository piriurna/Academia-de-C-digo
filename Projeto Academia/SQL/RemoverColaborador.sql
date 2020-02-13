create or replace NONEDITIONABLE PROCEDURE RemoverColaborador
(
    vNumCartaoCidadao IN VARCHAR2
)
AS
BEGIN
    IF vNumCartaoCidadao IS NOT NULL THEN
        DELETE FROM Colaborador
        WHERE NumCartaoCidadao = vNumCartaoCidadao;
    END IF;
END;
