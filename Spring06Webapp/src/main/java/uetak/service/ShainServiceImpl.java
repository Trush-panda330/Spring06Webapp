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

	//リクエストパラメーターから社員を作成し戻す
	@Override
	public Shain makeShain(Shain request) {
		//社員オブジェクトの作成
		Shain shain = new Shain();
		//社員オブジェクトに値を代入
		shain.setId(request.getId());
		shain.setName(request.getName());
		shain.setGender(request.getGender());
		shain.setNen(request.getNen());
		shain.setAddress(request.getAddress());
		return shain;
	}
	
	@Override
	public void insertShain(Shain shain) {
		shainRepository.insertShain(shain);
		
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
