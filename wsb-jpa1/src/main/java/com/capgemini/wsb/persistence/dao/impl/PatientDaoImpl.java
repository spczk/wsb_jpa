package com.capgemini.wsb.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;


@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

        public List<PatientEntity> findByLastName(String lastName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> criteriaQuery = builder.createQuery(getDomainClass());
        Root<PatientEntity> root = criteriaQuery.from(getDomainClass());

        criteriaQuery.select(root).where(builder.equal(root.get("lastName"), lastName));

        TypedQuery<PatientEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<PatientEntity> getPatientWithMoreThanXVisits(int x) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> criteriaQuery = builder.createQuery(PatientEntity.class);
        Root<PatientEntity> patientRoot = criteriaQuery.from(PatientEntity.class);
        Join<PatientEntity, VisitEntity> visitJoin = patientRoot.join("visits", JoinType.LEFT);

        Expression<Long> patientVisitsCount = builder.count(visitJoin.get("id"));

        criteriaQuery.select(patientRoot)
                .groupBy(patientRoot.get("id"))
                .having(builder.gt(patientVisitsCount, x));

        TypedQuery<PatientEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<PatientEntity> findByStillAlive(boolean stillAlive) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> criteriaQuery = builder.createQuery(getDomainClass());
        Root<PatientEntity> root = criteriaQuery.from(getDomainClass());

        criteriaQuery.select(root).where(builder.equal(root.get("stillAlive"), stillAlive));

        TypedQuery<PatientEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}
