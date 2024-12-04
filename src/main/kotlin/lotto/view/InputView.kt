package lotto.view

import lotto.domain.ManualLottoAmount

class InputView {
    fun inputMoney(): String? {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
    }

    fun inputManualLottoAmount(): String? {
        println("수동으로 구매할 로또 수를 입력해주세요.")
        return readlnOrNull()
    }

    fun inputManualLottoNumbers(manualLottoAmount: ManualLottoAmount): List<String?> {
        println("수동으로 구매할 번호를 입력해주세요.")
        return (1..manualLottoAmount.value)
            .map { readlnOrNull() }
    }

    fun inputWinningLottoNumbers(): String? {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull()
    }

    fun inputBonusNumber(): String? {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull()
    }
}
