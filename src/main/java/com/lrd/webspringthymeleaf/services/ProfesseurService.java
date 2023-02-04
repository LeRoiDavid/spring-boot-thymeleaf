package com.lrd.webspringthymeleaf.services;

import com.lrd.webspringthymeleaf.entities.Professeur;
import com.lrd.webspringthymeleaf.repositories.IProfesseurRepository;

import lombok.AllArgsConstructor;
import com.lrd.webspringthymeleaf.exception.EntityNotFoundException;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ProfesseurService {

    private final String notFoundMessage = "user.notfound";
    private final IProfesseurRepository iProfesseurRepository;
    private final MessageSource messageSource;

    @Transactional
    public Professeur create(Professeur professeur) {
        return iProfesseurRepository.save(professeur);
    }

    @Transactional
    public Professeur update(int id, Professeur professeur) {
        return iProfesseurRepository.findById(id)
                .map(entity -> {
                    professeur.setId(id);
                    return iProfesseurRepository.save(professeur);
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage(notFoundMessage,
                        new Object[] { id },
                        Locale.getDefault())));
 
    }

    @Transactional
    public Professeur changeStatus(int id) {
        return iProfesseurRepository.findById(id)
                .map(entity -> {
                    entity.setEtat(!entity.getEtat());
                    return iProfesseurRepository.save(entity);
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage(notFoundMessage,
                        new Object[] { id },
                        Locale.getDefault())));

    }

    @Transactional(readOnly = true)
    public Professeur getOne(int id) {
        return iProfesseurRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(messageSource.getMessage(notFoundMessage, new Object[] { id },
                                Locale.getDefault())));
    }

    @Transactional(readOnly = true)
    public List<Professeur> getAll() {
        return iProfesseurRepository.findAll();
    }

    @Transactional
    public void delete(int id) {
        Professeur professeur = iProfesseurRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(messageSource.getMessage(notFoundMessage, new Object[] { id },
                        Locale.getDefault())));
        iProfesseurRepository.delete(professeur);
    }

    public Professeur findByEmail(String email) {
        return iProfesseurRepository.findByEmail(email)
                .orElseThrow(() -> new com.lrd.webspringthymeleaf.exception.EntityNotFoundException(
                        messageSource.getMessage("auth.failled", new Object[] { email },
                                Locale.getDefault())));
    }

}
