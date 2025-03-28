SELECT
    dc.reg_ans AS Registro_ANS,
    oa.Razao_Social,
    SUM(dc.vl_saldo_final) AS total_despesas,
    COUNT(*) AS qtde_registros,
    CONCAT(YEAR(dc.data), ' - ', QUARTER(dc.data), 'º Trim') AS periodo
FROM (
    -- Dados de 2023
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis_01_2023
    UNION ALL
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis_04_2023
    UNION ALL
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis_07_2023
    UNION ALL
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis_10_2023
    UNION ALL
    -- Dados de 2024
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis_julho
    UNION ALL
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis_outubro
    UNION ALL
    SELECT reg_ans, descricao, vl_saldo_final, data FROM balanco_financeiro
    UNION ALL
    SELECT reg_ans, descricao, vl_saldo_final, data FROM demonstracoes_contabeis
) AS dc
JOIN operadoras_ativas oa ON dc.reg_ans = oa.Registro_ANS
WHERE dc.descricao LIKE '%EVENTOS/%SINISTROS%ASSISTÊNCIA%A SAÚDE%MEDICO HOSPITALAR%'
AND YEAR(dc.data) IN (2023, 2024)
GROUP BY dc.reg_ans, oa.Razao_Social, YEAR(dc.data), QUARTER(dc.data)
ORDER BY YEAR(dc.data) DESC, QUARTER(dc.data) DESC, total_despesas DESC
LIMIT 10;
