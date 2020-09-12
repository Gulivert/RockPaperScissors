package com.ggmartin.paperrockscissors.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggmartin.paperrockscissors.domain.models.GameDTO;
import com.ggmartin.paperrockscissors.domain.models.HandTypeDTO;
import com.ggmartin.paperrockscissors.domain.models.RoundDTO;
import com.ggmartin.paperrockscissors.domain.ports.DataService;
import com.ggmartin.paperrockscissors.domain.util.GameException;
import com.ggmartin.paperrockscissors.infrastructure.entity.DscHandTypeEntity;
import com.ggmartin.paperrockscissors.infrastructure.entity.GameEntity;
import com.ggmartin.paperrockscissors.infrastructure.entity.RoundEntity;
import com.ggmartin.paperrockscissors.infrastructure.repository.DscHandTypeRepository;
import com.ggmartin.paperrockscissors.infrastructure.repository.GameRepository;
import com.ggmartin.paperrockscissors.infrastructure.repository.RoundRepository;

@Service
public class H2DataRepository implements DataService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private RoundRepository roundRepository;

	@Autowired
	private DscHandTypeRepository handRepository;
	
	@Override
	public GameDTO merge(GameDTO game) {
		GameEntity map = modelMapper.map(game, GameEntity.class);
		GameEntity save = gameRepository.save(map);
		return game.id(save.getId());
	}

	@Override
	public RoundDTO merge(RoundDTO round,Integer gameId) {
		RoundEntity map = modelMapper.map(round, RoundEntity.class);
		map.setGameId(gameId);
		RoundEntity save = roundRepository.save(map);
		return round.id(save.getId());
	}
	
	@Override
	public HandTypeDTO getHand(Integer playerHand) {
		Optional<DscHandTypeEntity> findById = handRepository.findById(playerHand);
		if(findById.isEmpty())
			return null;
		return modelMapper.map(findById.get(), HandTypeDTO.class);
	}

	@Override
	public List<HandTypeDTO> getAllHands() {
		List<DscHandTypeEntity> findAll = handRepository.findAll();
		return findAll
				  .stream()
				  .map(hand -> modelMapper.map(hand, HandTypeDTO.class))
				  .collect(Collectors.toList());
	}

	@Override
	public GameDTO getGameById(Integer id) throws GameException {
		Optional<GameEntity> findById = gameRepository.findById(id);
		if(findById.isEmpty())
			throw new GameException("The Id didn't exist");
		
		return modelMapper.map(findById.get(),GameDTO.class);
	}

	@Override
	@Transactional
	public void clean(Integer id) throws GameException {
		roundRepository.deleteByGameId(id);
	}


}
