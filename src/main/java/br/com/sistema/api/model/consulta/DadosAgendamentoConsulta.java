package br.com.sistema.api.model.consulta;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
    Integer medicoid,
    Integer pacienteId,
    String observacao,
    Status status,
    LocalDateTime data
) {
}
