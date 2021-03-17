package lotto.domain

import lotto.domain.LottoStore.Companion.LOTTO_COST

class LottoGame(private var money: Money) {
    private val lottoStore = LottoStore()

    fun purchaseManualLottoes(numberOfManual: Int, stringManualNumbers: List<List<String>>): Lottoes {
        checkEnoughMoney(numberOfManual)
        val manualNumbers = stringManualNumbers.map { strings ->
            convertStringToInt(strings)
        }
        return lottoStore.purchaseManual(money, numberOfManual, manualNumbers)
    }

    fun purchaseAutoLottoes(): Lottoes {
        return lottoStore.purchaseAuto(money)
    }

    private fun checkEnoughMoney(numberOfManual: Int) {
        if (numberOfManual * LOTTO_COST > money.currentMoney) throw IllegalStateException("사고자 하는 수량이 현재 가진 돈보다 많습니다.")
    }

    private fun convertStringToInt(strings: List<String>): List<Int> {
        return strings.map {
            it.toInt()
        }
    }
}
