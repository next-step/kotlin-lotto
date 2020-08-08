package lotto.view

import lotto.model.Lotto

object InputView {

    const val REQUEST_PRICE = "구입 금액을 입력해주세요."
    const val REQUEST_BONUS_BALL = "보너스 볼을 입력해주세요."
    const val REQUEST_BUY_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."

    fun requestWithInputMode(mode: Mode): Int {
        println(mode.message)
        return readLine()?.toInt() ?: 0
    }

    fun requestWinningLottoNumber(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumber =
            readLine()?.split(",")?.map { it.toIntOrNull() ?: 0 }?.toSet() ?: emptySet()
        require(winningLottoNumber.size == Lotto.NUMBER_COUNT) {
            "로또 번호는 6개까지 입력 가능합니다."
        }
        return winningLottoNumber
    }

    enum class Mode(val message: String) {
        PRICE(REQUEST_PRICE),
        BONUS_BALL(REQUEST_BONUS_BALL),
        MANUALLY_BUY_NUMBER(REQUEST_BUY_MANUAL_LOTTO_COUNT);
    }
}
