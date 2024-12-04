package lotto

import lotto.domain.BonusNumber
import lotto.domain.BoughtLotto
import lotto.domain.BoughtMoney
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.ManualLottoAmount
import lotto.domain.WinningLotto

class LottoGame {
    fun parseInputMoney(input: String?): BoughtMoney =
        try {
            requireNotNull(input) { "구입 금액은 필수입니다." }
            BoughtMoney(input.toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("구입 금액은 숫자만 입력가능합니다.")
        }

    fun parseInputManualLottoAmount(input: String?): ManualLottoAmount =
        try {
            requireNotNull(input) { "수동으로 구매할 로또 수는 필수입니다." }
            ManualLottoAmount(input.toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.")
        }

    fun generateLottos(
        boughtMoney: BoughtMoney,
        manualLottoAmount: ManualLottoAmount,
        inputManualLottoNumbers: List<String?>,
    ): List<Lotto> {
        require(manualLottoAmount.value == inputManualLottoNumbers.size) { "구매한 수동 로또 수만큼 수동 로또 번호 입력이 필요합니다." }

        val manualLottos = generateManualLottos(inputManualLottoNumbers)
        val autoLottoAmount = boughtMoney.calculateAutoLottoAmount(manualLottoAmount)
        val autoLottos = (1..autoLottoAmount).map { Lotto.auto() }

        return manualLottos + autoLottos
    }

    private fun generateManualLottos(inputManualLottoNumbers: List<String?>) =
        inputManualLottoNumbers.map {
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

    fun generateWinningLotto(
        inputWinningLottoNumbers: String?,
        inputBonusNumber: String?,
    ): WinningLotto {
        val winningLottoNumber = inputWinningLottoNumbers(inputWinningLottoNumbers)
        val bonusNumber = inputBonusNumber(inputBonusNumber)
        return WinningLotto(winningLottoNumber, bonusNumber)
    }

    private fun inputWinningLottoNumbers(inputWinningLottoNumbers: String?): Lotto {
        return try {
            val winningNumbers = inputWinningLottoNumbers
                ?.split(", ")
                ?.map { it.toInt() }
                ?: throw IllegalArgumentException("지난 주 당첨 번호는 필수입니다.")
            Lotto.manual(winningNumbers)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("지난 주 당첨 번호는 숫자만 입력 가능합니다.")
        }
    }

    private fun inputBonusNumber(inputBonusNumber: String?): BonusNumber =
        try {
            requireNotNull(inputBonusNumber) { "보너스 볼은 필수입니다." }
            BonusNumber(LottoNumber(inputBonusNumber.toInt()))
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("보너스 볼은 숫자만 입력 가능합니다.")
        }

    fun play(
        lottos: List<Lotto>,
        winningLotto: WinningLotto,
    ): LottoResult =
        BoughtLotto(lottos, winningLotto)
            .matchResult()
}