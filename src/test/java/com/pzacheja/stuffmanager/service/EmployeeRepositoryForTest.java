package com.pzacheja.stuffmanager.service;

import com.pzacheja.stuffmanager.model.Employee;
import com.pzacheja.stuffmanager.repo.EmployeeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

class EmployeeRepositoryForTest implements EmployeeRepository {
	private final Map<Long, Employee> repository = new HashMap<>();
	private Long id = 1L;

	Long getId() {
		return id++;
	}

	@Override
	public void flush() {

	}

	@Override
	public <S extends Employee> S saveAndFlush(final S entity) {
		return null;
	}

	@Override
	public <S extends Employee> List<S> saveAllAndFlush(final Iterable<S> entities) {
		return null;
	}

	@Override
	public void deleteAllInBatch(final Iterable<Employee> entities) {

	}

	@Override
	public void deleteAllByIdInBatch(final Iterable<Long> longs) {

	}

	@Override
	public void deleteAllInBatch() {

	}

	@Override
	public Employee getOne(final Long aLong) {
		return null;
	}

	@Override
	public Employee getById(final Long aLong) {
		return null;
	}

	@Override
	public Employee getReferenceById(final Long aLong) {
		return null;
	}

	@Override
	public <S extends Employee> Optional<S> findOne(final Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends Employee> List<S> findAll(final Example<S> example) {
		return null;
	}

	@Override
	public <S extends Employee> List<S> findAll(final Example<S> example, final Sort sort) {
		return null;
	}

	@Override
	public <S extends Employee> Page<S> findAll(final Example<S> example, final Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Employee> long count(final Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Employee> boolean exists(final Example<S> example) {
		return false;
	}

	@Override
	public <S extends Employee, R> R findBy(final Example<S> example, final Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}

	@Override
	public <S extends Employee> S save(final S entity) {
		entity.setId(id);
		repository.put(getId(), entity);
		return entity;
	}

	@Override
	public <S extends Employee> List<S> saveAll(final Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<Employee> findById(final Long aLong) {
		return Optional.ofNullable(repository.get(aLong));
	}

	@Override
	public boolean existsById(final Long aLong) {
		return false;
	}

	@Override
	public List<Employee> findAll() {
		return repository.values().stream().toList();
	}

	@Override
	public List<Employee> findAllById(final Iterable<Long> longs) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(final Long aLong) {
		repository.remove(aLong);
	}

	@Override
	public void delete(final Employee entity) {

	}

	@Override
	public void deleteAllById(final Iterable<? extends Long> longs) {

	}

	@Override
	public void deleteAll(final Iterable<? extends Employee> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public List<Employee> findAll(final Sort sort) {
		return null;
	}

	@Override
	public Page<Employee> findAll(final Pageable pageable) {
		return null;
	}

}