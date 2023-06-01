package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlayerServiceImp implements PlayerService {

    private final PlayerRepository playerRepository;


    private final PlayerConverter playerConverter;
    private final RollConverter rollConverter;

    public PlayerServiceImp(PlayerRepository playerRepository, PlayerConverter playerConverter, RollConverter rollConverter) {
        this.playerRepository = playerRepository;
        this.playerConverter = playerConverter;
        this.rollConverter = rollConverter;
    }


    @Override
    public List<PlayerDTO> findAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return playerConverter.fromEntity(players);
    }

    @Override
    public Optional<PlayerDTO> findPlayerById(Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) return Optional.of(playerConverter.fromEntity(player.get()));
        else return Optional.empty();
    }

    @Override
    public void deletePlayerById(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<RollDTO> findAllRolls(int id) {
        Optional<Player> playerData = playerRepository.findById(id);

        if (playerData.isPresent()) {
            return rollConverter.fromEntity(playerData.get().getRolls());
        } else {
            return null;
        }
    }


    @Override
    public void deleteRolls(Integer id) {
        playerRepository.findById(id).stream().findAny().map(player -> {
            player.setRolls(new ArrayList<>());
            playerRepository.save(player);
            return player;
        });


    }
    //probar si no deja datos incoherentes

    public void rollDices(PlayerDTO playerDTO) {
        int firstroll = (int) Math.floor(Math.random() * 6 + 1);
        int secondroll = (int) Math.floor(Math.random() * 6 + 1);
        RollDTO rollDTO = new RollDTO(firstroll, secondroll);
        if (playerDTO.getRolls() != null) {
            playerDTO.getRolls().add(rollDTO);
        } else {
            List<RollDTO> rolls = playerDTO.getRolls();
            rolls = new ArrayList<>();
            playerDTO.getRolls().add(rollDTO);
        }
        playerDTO.setWinningRate();
        Roll roll = rollConverter.fromDto(rollDTO);
        Player player = playerConverter.fromDto(playerDTO);
        playerRepository.save(player);
    }


    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        playerRepository.save(playerConverter.fromDto(playerDTO));
        return playerDTO;
    }



    public boolean checkName(String name) {
        Optional<Player> player = playerRepository.findByName(name);
        if (player.isPresent()) return false;
        else return true;
    }

    @Override
    public float calculateWinningRate() {
        float totalRates = 0;
        List<PlayerDTO> players = playerConverter.fromEntity(playerRepository.findAll());
        for (PlayerDTO p : players) {
            totalRates += p.getWinningRate();
        }
        return totalRates / players.size();
    }

    @Override
    public PlayerDTO findWinner() {
        List<PlayerDTO> players = playerConverter.fromEntity(playerRepository.findAll());
        List<PlayerDTO> sortedList = players.stream().sorted(Comparator.comparingDouble(PlayerDTO::getWinningRate).reversed()).collect(Collectors.toList());
        return sortedList.get(0);
    }

    @Override
    public PlayerDTO findLoser() {
        List<PlayerDTO> players = playerConverter.fromEntity(playerRepository.findAll());
        List<PlayerDTO> sortedList = players.stream().sorted(Comparator.comparingDouble(PlayerDTO::getWinningRate)).collect(Collectors.toList());
        return sortedList.get(0);
    }
}

