package lotto.view

import lotto.model.Lotto

object InputView {

    fun requestPrice(): Int {
        println("구입 금액을 입력해주세요.")
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

    fun requestBonusBall(): Int {
        println("보너스 볼을 입력해주세요.")
        return readLine()?.toInt() ?: 0
    }
}
