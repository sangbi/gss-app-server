package com.gss.web.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gss.web.api.dto.MyPartyDto;
import com.gss.web.api.dto.PartyMainDto1;
import com.gss.web.api.dto.PartyMainDto2;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;

@Mapper
public interface PartyMapper {

	public int getArticleCountNum();

	public int createParty(Party party);

	public int insert(MemberOfPartyTab memberOfPartyTab);

	public void bossHunting(@Param("bossNum") int bossNum, @Param("partyNum") int partyNum);

	public int getPartyNum();

	public int getUserNum(String userId);

	public int getBossNum(@Param("bossName") String bossName, @Param("bossGrade") String bossGrade);

	public List<PartyMainDto1> showMain(PartyPageDto page);

	public List<PartyMainDto2> showMain2(PartyPageDto page);

	public int getPartyNumByName(String partyName);

	public MyPartyDto getMyPartyInfo(@Param("partyNum") int partyNum, @Param("gssUserId") String gssUserId);

	public int getIenterNumByName(String partyName);

	public MyPartyDto getIenterParty(@Param("partyNum") int partyNum, @Param("gssUserId") String gssUserId);

	public List<String> getBossName();

	public List<String> getBossGrade();
}
