package lotto.view

import lotto.domain.model.BuyPrice
import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers

/**
 * 입력 뷰
 * */
object InputView {

    private const val BUY_LOTTO_PRICE_DESCRIPTION = "구입금액을 입력해 주세요."
    private const val BUY_LOTTO_COUNT_DESCRIPTION = "%d개를 구매했습니다."
    private const val WINNING_BONUS_NUMBER_DESCRIPTION = "보너스 볼을 입력해 주세요."
    private const val WINNING_NUMBER_DESCRIPTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val WINNING_NUMBER_DELIMITER = ", "

    /**
     * 구입 금액 뷰
     * */
    fun drawBuyPrice(): BuyPrice {
        println(BUY_LOTTO_PRICE_DESCRIPTION)
        val buyPriceText = readln()

        require(buyPriceText.toIntOrNull() != null) {
            "구입 금액은 숫자만 들어올 수 있습니다."
        }

        return BuyPrice.valueOf(buyPriceText.toInt())
    }

    /**
     * 당첨 로또 번호들 뷰
     * */
    fun drawWinningLottoNumber(): LottoNumbers {
        println(WINNING_NUMBER_DESCRIPTION)
        val winningNumbersText = readln()

        require(winningNumbersText.isNotBlank()) {
            "로또 당첨 번호는 비어 있을 수 없습니다."
        }

        val winningNumbers = winningNumbersText.split(WINNING_NUMBER_DELIMITER)

        require(winningNumbers.all { winningNumber -> winningNumber.toIntOrNull() != null }) {
            "로또 당첨 번호들은 숫자만 들어올 수 있습니다."
        }

        return LottoNumbers.valueOf(winningNumbers.map { winningLottoNumber -> winningLottoNumber.toInt() }.toSet())
    }

    /**
     * 보너스 번호 뷰
     * */
    fun drawWinningBonusNumber(): LottoNumber {
        println(WINNING_BONUS_NUMBER_DESCRIPTION)
        val lottoNumberText = readln()

        require(lottoNumberText.toIntOrNull() != null) {
            "구입 금액은 숫자만 들어올 수 있습니다."
        }

        return LottoNumber.valueOf(lottoNumberText.toInt())
    }

    /**
     * 로또 목록
     * */
    fun drawLottoList(lottoList: List<Lotto>) {
        println(BUY_LOTTO_COUNT_DESCRIPTION.format(lottoList.size))
        lottoList.forEach {
            println(it.lottoNumbers.value)
        }
        println()
    }
}
