package br.com.sistema.api.model.consulta;

import java.time.LocalDateTime;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String observacao;

    private Paciente paciente;
    private Medico medico;
    private LocalDateTime data;

    private Status status;

    //Terceiro construtor da classe Consulta que recebe a convrrsão do DadosAgendamentoConsulta
    //O this.medico = new Medico() cria um novo objeto Medico vazio.Quando você tentar inserir o id neese novo medico criado, o ide, e o BD saberá que aquele id ja existe e trará as informações com o id daqueçe irá receber 

    public Consulta(DadosAgendamentoConsulta dados) {
        this.medico = new Medico();
        this.medico.setId(dados.medicoid());
        this.paciente = new Paciente();
        this.paciente.setId(dados.pacienteId());
        this.status = dados.status();
        this.observacao = dados.observacao();
        this.data = dados.data();
    }
}
