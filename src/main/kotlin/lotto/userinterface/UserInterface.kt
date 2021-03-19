package lotto.userinterface

import lotto.dto.LottoNumbersDto
import lotto.dto.StatisticsDto

interface UserInterface {
    fun inputPurchaseAmount(): Int
    fun inputLastWeekWinningLottoNumbers(): List<Int>
    fun inputLastWeekWinningLottoBonusNumber(): Int
    fun outputPurchasedMessage(dto: LottoNumbersDto)
    fun outputWinningStatistics(dto: StatisticsDto)
}
