package com.ggmartin.paperrockscissors.domain.ports;

import java.util.List;

import com.ggmartin.paperrockscissors.domain.models.GameDTO;
import com.ggmartin.paperrockscissors.domain.models.HandTypeDTO;
import com.ggmartin.paperrockscissors.domain.models.RoundDTO;
import com.ggmartin.paperrockscissors.domain.util.GameException;

public interface DataService {

	GameDTO merge(GameDTO gameEntity);

	HandTypeDTO getHand(Integer playerHand);

	List<HandTypeDTO> getAllHands();

	GameDTO getGameById(Integer id) throws GameException;

	RoundDTO merge(RoundDTO round, Integer integer);

	void clean(Integer id) throws GameException;


}
