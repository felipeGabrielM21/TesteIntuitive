SELECT
    dc.reg_ans AS Registro_ANS,
    oa.Razao_Social,
    ROUND(SUM(dc.vl_saldo_final), 2) AS total_despesas,
    COUNT(*) AS quantidade_registros,
    '4º Trimestre 2023 (Out-Dez)' AS periodo,
    MIN(dc.data) AS data_inicial,
    MAX(dc.data) AS data_final
FROM (
    SELECT
        reg_ans,
        descricao,
        vl_saldo_final,
        data
    FROM demonstracoes_contabeis_10_2023
    WHERE
        data BETWEEN '2023-10-01' AND '2023-12-31'
        AND descricao LIKE '%EVENTOS/%SINISTROS%ASSISTÊNCIA%SAÚDE%MEDICO%HOSPITALAR%'
) AS dc
JOIN operadoras_ativas oa ON TRIM(dc.reg_ans) = TRIM(oa.Registro_ANS)
GROUP BY
    dc.reg_ans,
    oa.Razao_Social
ORDER BY
    total_despesas DESC
LIMIT 10;
