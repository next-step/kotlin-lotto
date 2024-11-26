package lotto.view

import lotto.BonusNumber
import lotto.BoughtLotto
import lotto.Lotto
import lotto.LottoCost
import lotto.LottoNumber
import lotto.WinningLotto

class InputView {
    fun input(): BoughtLotto {
        val lottos = inputLottoCost()
        val winningLotto = inputWinningLotto()
        println()
        return BoughtLotto(
            lottos = lottos,
            winningLotto = winningLotto,
        )
    }

    private fun inputLottoCost(): List<Lotto> {
        val money = inputMoney()
        val manualLottoAmount = inputManualLottoAmount()
        val lottoCost = LottoCost(money, manualLottoAmount)
        return generateLottos(lottoCost)
    }

    private fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val maybeMoney = readlnOrNull()
        return try {
            requireNotNull(maybeMoney) { "구입 금액은 필수입니다." }
            maybeMoney.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("구입 금액은 숫자만 입력가능합니다.")
        }
    }

    private fun inputManualLottoAmount(): Int {
        println("수동으로 구매할 로또 수를 입력해주세요.")
        try {
            val maybeManualLottoAmount = readlnOrNull() ?: throw IllegalArgumentException("수동으로 구매할 로또 수는 필수입니다.")
            return maybeManualLottoAmount.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.")
        }
    }

    private fun generateLottos(lottoCost: LottoCost): List<Lotto> {
        println("수동으로 구매할 로또 수를 입력해주세요.")
        val manualLottos = inputManualLottoNumbers(lottoCost)

        val autoLottoAmount = lottoCost.autoLottoAmount
        val autoLottos = (1..autoLottoAmount).map { Lotto.auto() }

        val generatedLottos = manualLottos + autoLottos
        printBoughtLottos(lottoCost, generatedLottos)
        return generatedLottos
    }

    private fun inputManualLottoNumbers(lottoCost: LottoCost): List<Lotto> {
        println("수동으로 구매할 번호를 입력해주세요.")
        val maybeManualLottoNumbers = (1..lottoCost.manualLottoAmount)
            .map { readlnOrNull() }

        return maybeManualLottoNumbers.map {
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
    }

    private fun printBoughtLottos(
        lottoCost: LottoCost,
        lottos: List<Lotto>,
    ) {
        println("수동으로 ${lottoCost.manualLottoAmount}장, 자동으로 ${lottoCost.autoLottoAmount}장 구매했습니다.")
        lottos.forEach {
            val lottoNumbersString = it.numbers.joinToString(", ") {
                lottoNumber -> lottoNumber.value.toString()
            }
            println("[$lottoNumbersString]")
        }
    }

    private fun inputWinningLotto(): WinningLotto {
        val winningLotto = inputWinningLottoNumbers()
        val bonusNumber = inputBonusNumber()
        return WinningLotto(
            lotto = winningLotto,
            bonusNumber = bonusNumber,
        )
    }

    private fun inputWinningLottoNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return try {
            val maybeWinningNumbers = readlnOrNull()
            val winningNumbers = maybeWinningNumbers
                ?.split(", ")
                ?.map { it.toInt() }
                ?: throw IllegalArgumentException("지난 주 당첨 번호는 필수입니다.")
            Lotto.manual(winningNumbers)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("지난 주 당첨 번호는 숫자만 입력 가능합니다.")
        }
    }

    private fun inputBonusNumber(): BonusNumber {
        println("보너스 볼을 입력해 주세요.")
        val maybeBonusBall = readlnOrNull()
        return try {
            requireNotNull(maybeBonusBall) { "보너스 볼은 필수입니다." }
            BonusNumber(LottoNumber(maybeBonusBall.toInt()))
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("보너스 볼은 숫자만 입력 가능합니다.")
        }
    }
}
