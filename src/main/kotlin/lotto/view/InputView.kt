package lotto.view

import lotto.domain.Lotto

object InputView {

    private const val MONEY_QUESTION = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val CUSTOM_MANUAL_QUESTION = "수동으로 구매할 번호를 입력해 주세요."

    private const val INPUT_NULL_POINTER_EXCEPTION_MESSAGE = "입력은 null일 수 없습니다"
    private const val NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 갯수는 숫자로만 입력해주세요"

    fun getMoney(): String {
        println(MONEY_QUESTION)
        return readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
    }

    fun inputManualLottoCount(): Int {
        println(MANUAL_LOTTO_COUNT_QUESTION)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE)
    }

    fun inputWinningNumbers(): String {
        println(WINNING_NUMBER_QUESTION)
        return readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
    }

    fun inputBonusBall(): String {
        println(BONUS_BALL_QUESTION)
        return readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
    }

    fun inputManualLotto(lottoCount: Int): List<Lotto> {
        println(CUSTOM_MANUAL_QUESTION)
        val manualLottoList = mutableListOf<String>()
        repeat(lottoCount) {
            val manualLotto = readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
            manualLottoList.add(manualLotto)
        }
        return manualLottoList.map { Lotto.from(it) }
    }
}
