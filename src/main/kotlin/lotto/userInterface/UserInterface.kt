package lotto.userInterface

import lotto.domain.LottoPrize
import lotto.dto.LottoNumbersDto

interface UserInterface {
    fun inputPurchaseAmount(): Int
    fun inputLastWeekWinningLottoNumbers(): List<Int>
    fun outputPurchasedMessage(dto: LottoNumbersDto)
    fun outputWinningStatistics(lottoPrizes: List<LottoPrize>)
}
