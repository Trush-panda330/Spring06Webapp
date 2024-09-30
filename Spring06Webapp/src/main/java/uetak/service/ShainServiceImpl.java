package uetak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uetak.entity.Shain;
import uetak.repository.ShainRepository;

@Service
public class ShainServiceImpl implements ShainService {

	@Autowired
	ShainRepository shainRepository;

	@Override
	public List<Shain> findAll() {

		return shainRepository.findAll();
	}

	@Override
	public Shain makeShain(Shain request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Shain findByShainId(int shainId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void updateShain(Shain shain) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteShain(int shainId) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
