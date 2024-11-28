package study.lotto.view

import study.lotto.LottoService
import study.lotto.model.Lotto
import study.lotto.model.LottoNumber
import study.lotto.model.Lottos

/**
 * @author 이상준
 */
class InputView {
    fun inputMoney(): Int {
        println(INPUT_MONEY_LOTTO_MESSAGE)
        val money = readlnOrNull()?.toInt() ?: throw IllegalArgumentException()
        require(money >= LOTTO_PRICE) { ERROR_MONEY_LOTTO_MESSAGE.format(LOTTO_PRICE) }

        return money
    }

    fun inputBuyManualCount(money: Int): Int {
        println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
        require(money / LOTTO_PRICE >= 1)
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException()
    }

    fun inputManualLotto(manualCount: Int): Lottos {
        println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE)
        val lottos = Lottos()
        repeat(manualCount) {
            val lottoNumbers = readlnOrNull()?.split(",")?.map { LottoNumber(it.toInt()) } ?: throw IllegalArgumentException()
            lottos.addLotto(Lotto(lottoNumbers.toSet()))
        }

        return lottos
    }

    fun inputWinLotto(): Lotto {
        println(INPUT_WIN_LOTTO_MESSAGE)
        val lottoNumbers = readlnOrNull()?.split(",")?.map { LottoNumber(it.toInt()) } ?: throw IllegalArgumentException()
        return Lotto(lottoNumbers.toSet())
    }

    fun inputBonusBall(winLotto: Lotto): LottoNumber {
        println(INPUT_BONUS_BALL_MESSAGE)
        val bonus = readlnOrNull()?.toInt() ?: throw IllegalArgumentException()
        require(bonus in LottoService.MIN_LOTTO_NUMBER..LottoService.MAX_LOTTO_NUMBER) {
            ERROR_BONUS_NUMBER_CHECK_MESSAGE.format(LottoService.MIN_LOTTO_NUMBER, LottoService.MAX_LOTTO_NUMBER)
        }
        require(!winLotto.lottoNumbers.contains(LottoNumber(bonus))) { ERROR_BONUS_WIN_LOTTO_CHECK_MESSAGE }

        return LottoNumber(bonus)
    }

    companion object {
        private const val INPUT_MONEY_LOTTO_MESSAGE = "구입금액을 입력해 주세요."
        private const val ERROR_MONEY_LOTTO_MESSAGE = "로또 구입금액은 최소 %s원입니다."
        private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
        private const val INPUT_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val ERROR_BONUS_NUMBER_CHECK_MESSAGE = "보너스 볼은 %s ~ %s 사이의 숫자입니다."
        private const val ERROR_BONUS_WIN_LOTTO_CHECK_MESSAGE = "보너스 볼은 당첨 번호와 중복되면 안됩니다."
        private const val LOTTO_PRICE = 1000
    }
}
