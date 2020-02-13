CREATE OR REPLACE PROCEDURE LOGIN 
(
  vUSERNAME IN VARCHAR2 
, vPASSWORD IN VARCHAR2 
, vSESSION_ID OUT VARCHAR2 
) AS
    vUSER_ID INT;
    vActive_Sessions INT;
BEGIN
    SELECT Users.ID INTO vUSER_ID FROM Users WHERE username = vUSERNAME AND password = vPASSWORD;
    IF vUSER_ID IS NOT NULL THEN 
        SELECT COUNT(sessions.id_user) INTO vActive_Sessions FROM Sessions WHERE sessions.id_user = vUser_id;
        IF vActive_Sessions > 0 THEN
            vSESSION_ID := '-1'; 
        ELSE
            vSESSION_ID := DBMS_RANDOM.STRING('A', 10);
            INSERT INTO Sessions(id, id_user, S_Start, S_Last) VALUES (vSESSION_ID, vUSER_ID, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
        END IF;
    ELSE
        vSESSION_ID := '0';
    END IF;
    
END LOGIN;
