package study.lotto.view

import study.lotto.LottoService
import study.lotto.model.Lotto

/**
 * @author 이상준
 */
class InputView {
    fun inputMoney(): Int {
        println(INPUT_MONEY_LOTTO_MESSAGE)
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException()
    }

    fun inputWinLotto(): Lotto {
        println(INPUT_WIN_LOTTO_MESSAGE)
        val lottoNumbers = readlnOrNull()?.split(",")?.map { it.toInt() } ?: throw IllegalArgumentException()
        return Lotto(lottoNumbers.toSet())
    }

    fun inputBonusBall(winLotto: Lotto): Int {
        println(INPUT_BONUS_BALL_MESSAGE)
        val bonus = readlnOrNull()?.toInt() ?: throw IllegalArgumentException()
        require(bonus in LottoService.MIN_LOTTO_NUMBER..LottoService.MAX_LOTTO_NUMBER) {
            ERROR_BONUS_NUMBER_CHECK_MESSAGE.format(LottoService.MIN_LOTTO_NUMBER, LottoService.MAX_LOTTO_NUMBER)
        }
        require(bonus !in winLotto.lottoNumbers) { ERROR_BONUS_WIN_LOTTO_CHECK_MESSAGE }

        return bonus
    }

    companion object {
        private const val INPUT_MONEY_LOTTO_MESSAGE = "구입금액을 입력해 주세요: "
        private const val INPUT_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요: "
        private const val INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val ERROR_BONUS_NUMBER_CHECK_MESSAGE = "보너스 볼은 %s ~ %s 사이의 숫자입니다."
        private const val ERROR_BONUS_WIN_LOTTO_CHECK_MESSAGE = "보너스 볼은 당첨 번호와 중복되면 안됩니다."
    }
}
