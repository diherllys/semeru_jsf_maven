/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.semeru.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

/**
 *
 * @author Dih-DesktopW10
 */
public class PhaseListener implements javax.faces.event.PhaseListener {

    @Override
    public void afterPhase(PhaseEvent phase) {//abrir sessão do hibernate e setala
        if (phase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("Antes da Phase: " + phase.getPhaseId().toString());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);

        }
    }

    @Override
    public void beforePhase(PhaseEvent phase) {
        System.out.println("Depois da Phase " + phase.getPhaseId().toString());
        if (phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {// se der algo errado ele vai da um rollback no banco de dados
                    session.getTransaction().rollback();
                }
            } finally {
                session.close();
            }
        }

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
