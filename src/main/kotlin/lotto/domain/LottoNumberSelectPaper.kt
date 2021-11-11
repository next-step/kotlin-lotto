package lotto.domain

import lotto.domain.ExceptionType.CAN_NOT_ADD_MANUAL_GAME_MORE_THEN_FIXED_NUMBER
import lotto.domain.ExceptionType.NUMBER_OF_MANUAL_SELECT_GAME_MUST_LESS_THEN_FULL_GAME_NUMBER

data class LottoNumberSelectPaper(
    val budget: LottoBudget,
    val numberOfManualSelectGames: NumberOfManualSelectGames = NumberOfManualSelectGames(0)
) {
    private val manualSelectedLottoGameList = LottoGameList()

    init {
        require(budget.getNumberOfGames() - numberOfManualSelectGames.numberOfGames >= 0) { NUMBER_OF_MANUAL_SELECT_GAME_MUST_LESS_THEN_FULL_GAME_NUMBER }
    }

    fun addManualSelectGame(lottoGame: LottoGame) {
        require(manualSelectedLottoGameList.size() < numberOfManualSelectGames.numberOfGames) { CAN_NOT_ADD_MANUAL_GAME_MORE_THEN_FIXED_NUMBER }
        manualSelectedLottoGameList.add(lottoGame)
    }

    fun getManualSelectedLottoGames() = manualSelectedLottoGameList
}
