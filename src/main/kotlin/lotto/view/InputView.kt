package lotto.view

import lotto.domain.LottoPurchaseCount

class InputView {
    fun inputPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }

    fun inputManualPurchaseCount(): String {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readln()
    }

    fun inputManualNumbers(manualPurchaseCount: LottoPurchaseCount): List<String> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return (1..manualPurchaseCount.count).map {
            readln()
        }
    }

    fun inputWinningNumbers(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun inputBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }
}
