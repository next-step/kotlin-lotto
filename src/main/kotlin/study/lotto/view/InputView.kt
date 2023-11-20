package study.lotto.view

import study.lotto.domain.Amount

class InputView {
    fun getPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
            ?.toIntOrNull()
            ?.let(::Amount)
            ?: Amount.ZERO
    }

    fun getManualBuyingAmount(): Amount {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()
            ?.toIntOrNull()
            ?.let(::Amount)
            ?: Amount.ZERO
    }

    fun getLastWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return runCatching {
            readlnOrNull()?.let(::parseManualLottoNumbers)
        }.getOrNull() ?: emptyList()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull()
            ?.trim()
            ?.toIntOrNull()
            ?: 0
    }

    fun getManualLottoNumbers(buyingAmount: Amount): List<List<Int>> {
        if (buyingAmount.amount <= 0) return emptyList()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualNumbers = mutableListOf<List<Int>>()

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

    private fun parseManualLottoNumbers(line: String): List<Int> {
        val numbers = line.split(",").mapNotNull { it.trim().toIntOrNull() }
        if (numbers.size != 6) {
            throw IllegalArgumentException("로또 번호는 6개여야 합니다.")
        }
        return numbers
    }

    private fun onLineParsingError(e: Throwable) {
        when (e) {
            is NumberFormatException -> println("유효하지 않은 숫자 형식입니다. 다시 입력해주세요.")
            else -> println(e)
        }
    }
}
