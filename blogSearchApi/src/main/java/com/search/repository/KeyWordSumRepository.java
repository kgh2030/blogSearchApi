package com.search.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.search.entity.TbKeywordSum;

import jakarta.transaction.Transactional;

@Repository
public interface KeyWordSumRepository extends JpaRepository<TbKeywordSum, Long>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update TbKeywordSum  m set m.count=m.count+1 where m.keyWord=:keyWord")
	int keywordSumCountPlus(@Param("keyWord") String keyWord);
	
	@Query("select count(*) from TbKeywordSum m where m.keyWord=:keyWord")
	int checkKeyWord(@Param("keyWord") String keyWord);
	
	@Query("select new map (rownum as no, x.keyWord as keyWord, x.count as count) from (select m.keyWord as keyWord, m.count as count from TbKeywordSum m order by m.count desc limit 10) x")
	List<Map<String, Object>> popularSearchList();

}
