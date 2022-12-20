package com.gura.spring04.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public boolean isExist(String inputId) {
		//id 를 이용해서 select 해보면 null 혹은 null 이 아니다.
		UsersDto dto=session.selectOne("users.getData", inputId);
		//아이디 존재 여부를 알아내서
		boolean isExist= dto==null ? false : true;
		//리턴해준다.
		return isExist;
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

	@Override
	public UsersDto getData(String id) {
		/*
		 *  mapper's namespace => users
		 *  sql's id => getData
		 *  parameterType => String
		 *  selectOne() 메소드를 호출한경우 resultType 이 메소드의 리턴 type 이 된다.
		 *  resultType => UsersDto
		 */
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}

	@Override
	public void updatePwd(UsersDto dto) {//비밀번호 수정
		session.update("users.updatePwd", dto);
	}

	@Override
	public void update(UsersDto dto) {//이메일과 프로필 수정
		session.update("users.update", dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
		
	}

}