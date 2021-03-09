package lotto.userInterface

import lotto.domain.LottoPrize
import lotto.dto.LottoNumbersDto

class Console : UserInterface {
    override fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }

    override fun inputLastWeekWinningLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(WINNING_LOTTO_NUMBERS_DELIMITER)
            ?.map { it.trim() }
            ?.map { it.toInt() }
            ?: listOf()
    }

    override fun outputPurchasedMessage(dto: LottoNumbersDto) {
        println("${dto.count}개를 구매했습니다.")
        dto.lottos.forEach { println(it) }
    }

    override fun outputWinningStatistics(lottoPrizes: List<LottoPrize>) {
        println("당첨 통계")
        println("---------")
        lottoPrizes.forEach { println(it) }
    }

    companion object {
        private const val WINNING_LOTTO_NUMBERS_DELIMITER = ","
    }
}
