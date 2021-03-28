package lotto.userinterface

import lotto.dto.LottoNumbersDto
import lotto.dto.StatisticsDto
import lotto.dto.WinningLottoDto

interface UserInterface {
    fun inputPurchaseAmount(lottoPrice: Int): Int
    fun inputManualLottoNumbers(): List<List<Int>>
    fun inputLastWeekWinningLotto(): WinningLottoDto
    fun outputPurchasedMessage(dto: LottoNumbersDto)
    fun outputWinningStatistics(dto: StatisticsDto)
}
