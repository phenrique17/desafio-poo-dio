package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
public class DesafioDioPooApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioDioPooApplication.class, args);

        final String CONTEUDOS_INSCRITOS = "Conteúdos Inscritos";
        final String CONTEUDOS_CONCLUIDOS = "Conteúdos Concluidos";

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descricao Curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Descricao Curso Python");
        curso2.setCargaHoraria(4);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria Java");
        mentoria1.setDescricao("Descricao Java Python");
        mentoria1.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev devPaulo = new Dev();
        devPaulo.setNome("Paulo");
        devPaulo.inscreverBootcamp(bootcamp);
        log.info("-----------------{}-----------------", devPaulo.getNome());
        log.info("{}: {}", CONTEUDOS_INSCRITOS, devPaulo.getConteudosInscritos());
        devPaulo.progredir();
        devPaulo.progredir();
        devPaulo.progredir();
        devPaulo.progredir(curso1);
        log.info("{}: {}", CONTEUDOS_INSCRITOS, devPaulo.getConteudosInscritos());
        log.info("{}: {} ", CONTEUDOS_CONCLUIDOS, devPaulo.getConteudosConcluidos());
        log.info("XP: {}", devPaulo.calcularTotalXp());


        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        log.info("-----------------{}-----------------", devCamila.getNome());
        log.info("{}: {}", CONTEUDOS_INSCRITOS, devCamila.getConteudosInscritos());
        devCamila.progredir();
        log.info("{}: {}", CONTEUDOS_INSCRITOS, devCamila.getConteudosInscritos());
        log.info("{}: {} ", CONTEUDOS_CONCLUIDOS, devCamila.getConteudosConcluidos());
        log.info("XP: {}", devCamila.calcularTotalXp());
    }

}
