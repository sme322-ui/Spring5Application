package com.example.spring5application;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

@SuppressWarnings("ALL")
public class ArticleRepository implements JpaRepository<Article, Long> {


    @Override
    public Iterable<Article> findAll(Sort var1) {
        return null;
    }

    @Override
    public Page<Article> findAll(Pageable var1) {
        return null;
    }

    @Override
    public <S extends Article> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Article> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Article> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Article> findAll() {
        return null;
    }

    @Override
    public Iterable<Article> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Article entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Article> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Article> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Article> Iterable<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Article> Iterable<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Article> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Article> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Article> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Article, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
