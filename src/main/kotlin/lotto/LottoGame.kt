package lotto

import lotto.domain.BoughtMoney
import lotto.domain.Lotto
import lotto.domain.ManualLottoAmount

class LottoGame {
    fun parseInputMoney(input: String?): BoughtMoney =
        try {
            requireNotNull(input) { "구입 금액은 필수입니다." }
            BoughtMoney(input.toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("구입 금액은 숫자만 입력가능합니다.")
        }

    fun parseInputManualLottoAmount(input: String?): Int =
        try {
            requireNotNull(input) { "수동으로 구매할 로또 수는 필수입니다." }
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.")
        }

    fun generateLottos(
        boughtMoney: BoughtMoney,
        manualLottoAmount: ManualLottoAmount,
        inputManualLottoNumbers: List<String?>,
    ): List<Lotto> {
        require(manualLottoAmount.value == inputManualLottoNumbers.size) { "구매한 수동 로또 수만큼 수동 로또 번호 입력이 필요합니다." }

        val manualLottos = inputManualLottoNumbers.map {
            try {
                val manualLottoNumbers = it
                    ?.split(", ")
                    ?.map { manualLottoNumber -> manualLottoNumber.toInt() }
                    ?: throw IllegalArgumentException("수동 로또 번호는 입력은 필수입니다.")
                Lotto.manual(manualLottoNumbers)
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("수동 로또 번호는 숫자만 입력 가능합니다.")
            }
        }

        val autoLottoAmount = boughtMoney.calculateAutoLottoAmount(manualLottoAmount)
        val autoLottos = (1..autoLottoAmount).map { Lotto.auto() }

        return manualLottos + autoLottos
    }
}