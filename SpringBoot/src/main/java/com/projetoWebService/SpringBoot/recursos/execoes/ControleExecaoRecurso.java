package com.projetoWebService.SpringBoot.recursos.execoes;

import com.projetoWebService.SpringBoot.servicos.execoes.ExecaoRecursosNaoEncontrados;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControleExecaoRecurso {

    @ExceptionHandler(ExecaoRecursosNaoEncontrados.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExecaoRecursosNaoEncontrados e, HttpServletRequest requisicao) {
        String erro = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao er = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), requisicao.getRequestURI());
        return ResponseEntity.status(status).body(er);
    }
}
