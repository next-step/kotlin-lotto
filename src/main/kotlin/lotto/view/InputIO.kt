package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoTickets
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): PurchaseAmount {
        return try {
            PurchaseAmount(inputString?.toIntOrNull() ?: 0)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.inputPurchaseAmount()
        }
    }

    fun inputManualLottoCount(inputString: String? = readlnOrNull()): ManualLottoCount {
        return try {
            ManualLottoCount(inputString?.toIntOrNull() ?: 0)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.inputManualLottoCount()
        }
    }

    fun inputManualLottoNumbers(manualLottoCount: ManualLottoCount): LottoTickets {
        return LottoTickets(List(manualLottoCount.count) { inputLotto() })
    }

    private fun inputLotto(): Lotto {
        return try {
            Lotto(inputLottoNumber())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.inputLotto()
        }
    }

    fun inputLottoNumber(inputString: String? = readlnOrNull()): List<LottoNumber> {

        if (inputString.isNullOrEmpty()) {
            return listOf()
        }

        return try {
            convertStringToLottoNumbers(inputString)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.inputLottoNumber()
        }
    }

    private fun convertStringToLottoNumbers(string: String): List<LottoNumber> {
        return string.replace(" ", "")
            .split(",")
            .map { LottoNumber.from(it.toInt()) }
    }

    fun inputBonusNumber(inputString: String? = readlnOrNull()): LottoNumber {
        return try {
            LottoNumber.from(inputString?.toIntOrNull() ?: 0)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.inputBonusNumber()
        }
    }
}
