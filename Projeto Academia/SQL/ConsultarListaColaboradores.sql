create or replace FUNCTION ConsultarListaColaboradores
RETURN SYS_REFCURSOR IS My_Cursor SYS_REFCURSOR;
BEGIN
  OPEN My_Cursor FOR SELECT
    Colaborador.ID,
    Colaborador.Nome,
    Colaborador.NumCartaoCidadao
  FROM System.Colaborador;
  RETURN My_Cursor;
END ConsultarListaColaboradores;