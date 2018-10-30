package jp.co.rakus.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import jp.co.rakus.domain.User;
import jp.co.rakus.repository.UserRepository;

/**
 * repositoryを呼び出すサービス
 * 
 * @author wataru.saito
 *
 */

@Service
public class SearchService {

	@Autowired
	private UserRepository repository;

	/**
	 * repositoryのloadメソッドをよぶメソッド.
	 * 
	 * @param id
	 *            入力された値
	 * @return
	 */
	public User load(Integer id) {
		return repository.load(id);
	}
}
