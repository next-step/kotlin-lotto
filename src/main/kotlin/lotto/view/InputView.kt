package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.WinningLotto

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        val price = Money(readln().toInt())
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        price.manualCount = readln().toInt()
        return price
    }

    fun getManaulLottos(buy: Money): List<Lotto> {
        var manaulLottos = mutableListOf<Lotto>()
        if (buy.manualCount > 0) {
            println("수동으로 구매할 번호를 입력해 주세요.")
            repeat(buy.manualCount) {
                val manualLotto = readln().replace(" ", "").split(",").map { LottoNumber(it.toInt()) }.toSet()
                manaulLottos.add(Lotto(manualLotto))
            }
        }
        return manaulLottos
    }

    fun getWinningNumbers(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln().replace(" ", "").split(",").map { LottoNumber.valueOf(it.toInt()) }.toSet()
        val winningLotto = convertToLotto(winningNumbers)

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(readln().toInt())
        return WinningLotto(winningLotto, bonusNumber)
    }

    private fun convertToLotto(numbers: Set<LottoNumber>): Lotto {
        return Lotto(numbers)
    }
}
