package uetak.repository;

import java.util.List;

import uetak.entity.Shain;

public interface ShainRepository {

	//全社員を取得
	List<Shain> findAll();

	//社員IDから一件の社員情報を取得
	Shain findByShainId(int shainId);

	//社員データの挿入
	void insertShain(Shain shain);

	//社員更新
	void updateShain(Shain shain);

	//社員削除
	void deleteShain(int shainId);

}
