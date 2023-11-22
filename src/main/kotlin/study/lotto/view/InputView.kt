package study.lotto.view

import study.lotto.domain.Amount
import study.lotto.domain.LottoNumber
import study.lotto.domain.LottoNumbers

class InputView {
    fun getPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
            ?.trim()
            ?.toIntOrNull()
            ?.let(::Amount)
            ?: Amount.ZERO
    }

    fun getManualBuying(): List<LottoNumbers> = getManualBuyingAmount()
        .takeIf { it.amount > 0 }
        ?.let(::getManualLottoNumbersList)
        ?: emptyList()

    private fun getManualBuyingAmount(): Amount {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()
            ?.trim()
            ?.toIntOrNull()
            ?.let(::Amount)
            ?: Amount.ZERO
    }

    private fun getManualLottoNumbersList(buyingAmount: Amount): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualNumbers = mutableListOf<LottoNumbers>()

        while (true) {
            if (buyingAmount.amount <= manualNumbers.size) {
                break
            }

            val line = readlnOrNull()?.trim()
            if (line.isNullOrEmpty()) {
                break
            }

            runCatching {
                manualNumbers.add(parseManualLottoNumbers(line))
            }.onFailure(::onLineParsingError)
        }

        return manualNumbers
    }

    fun getLastWeekWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return (readlnOrNull() ?: "")
            .trim()
            .let(::parseManualLottoNumbers)
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull()
            ?.trim()
            ?.toIntOrNull()
            ?.let(::LottoNumber)
            ?: throw NumberFormatException("유효하지 않는 숫자입니다.")
    }

    private fun parseManualLottoNumbers(line: String): LottoNumbers {
        val numbers = line.split(",").mapNotNull { it.trim().toIntOrNull() }
        return LottoNumbers.get(numbers)
    }

    private fun onLineParsingError(e: Throwable) {
        when (e) {
            is NumberFormatException -> println("유효하지 않은 숫자 형식입니다. 다시 입력해주세요.")
            else -> println(e)
        }
    }
}
