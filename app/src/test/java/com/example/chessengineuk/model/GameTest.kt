package com.example.chessengineuk.model

import com.example.chessengineuk.interfaces.SingleGame
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

internal class GameTest {

    private val singleGame: SingleGame = mockk()

    private fun getTestPlayers() : Array<Player> {
        val player1 = Player()
        player1.humanPlayer = true
        player1.whiteSide = true

        val player2 = Player()
        player2.humanPlayer = false
        player2.whiteSide = false

        return arrayOf(player1, player2)
    }

    private fun setupAndStartGame() {
        val expectedPlayers = getTestPlayers()

        singleGame.setGamePlayers(expectedPlayers)
        singleGame.startGame()
    }

    @Test
    fun happy_path_check_is_possible_to_set_player_for_inactive_game() {
        val expectedPlayers = getTestPlayers()
        val isPossibleToSetPlayers = singleGame.setGamePlayers(expectedPlayers)

        assert(isPossibleToSetPlayers)
    }

    @Test
    fun happy_path_check_is_return_player_list_correctly() {
        setupAndStartGame()

        val expectedPlayers = getTestPlayers()
        val activePlayers = singleGame.getGamePlayers()

        assert(expectedPlayers.contentEquals(activePlayers))
    }

    @Test
    fun happy_path_check_is_return_game_board_correctly() {
        setupAndStartGame()

        val expectedBoard = Board()
        val activeBoard = singleGame.getBoard()

        assert(expectedBoard == activeBoard)
    }

    @Test
    fun happy_path_check_is_return_game_status_correctly() {
        setupAndStartGame()

        val gameStatus = singleGame.getGameStatus()
        val expectedGameStatus = GameStatus.ACTIVE
        assert(expectedGameStatus == gameStatus)
    }

    @Test
    fun happy_path_check_is_return_played_moves_correctly() {
        setupAndStartGame()

        val players = singleGame.getGamePlayers()
        val player1 = players[0]
        val move = Move()
        singleGame.makeMove(move, player1)

        val moveList = singleGame.getMoveList()
        val expectedSizeOfList = 1
        val actualSizeOfList = moveList.size
        assert(expectedSizeOfList == actualSizeOfList)
    }

    @Test
    fun happy_path_check_is_possible_to_set_make_move_and_is_done_success() {
        setupAndStartGame()

        val players = singleGame.getGamePlayers()
        val player1 = players[0]
        val move = Move()
        move.pieceMoved = Piece(true)
        val isPossibleToMakeMove = singleGame.makeMove(move, player1)

        assert(isPossibleToMakeMove)
    }

    @Test
    fun unhappy_path_try_set_players_for_active_game() {
        setupAndStartGame()

        val testPlayers = getTestPlayers()
        val isPossibleToSetPlayers = singleGame.setGamePlayers(testPlayers)

        assert(!isPossibleToSetPlayers)
    }

    @Test
    fun happy_path_check_status_for_finished_game_white_won() {
        setupAndStartGame()

        val players = singleGame.getGamePlayers()
        val playerWhite = players[0]
        singleGame.winPlayer(playerWhite)

        val expectedGameStatus = GameStatus.WHITE_WIN
        val actualGameStatus = singleGame.getGameStatus()

        assert(expectedGameStatus == actualGameStatus)
    }

    @Test
    fun happy_path_check_status_for_finished_game_black_won() {
        setupAndStartGame()

        val players = singleGame.getGamePlayers()
        val playerBlack = players[1]
        singleGame.winPlayer(playerBlack)

        val expectedGameStatus = GameStatus.BLACK_WIN
        val actualGameStatus = singleGame.getGameStatus()

        assert(expectedGameStatus == actualGameStatus)
    }
}