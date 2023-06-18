package lotto.view

import lotto.domain.LottoNumbers

object InputView {

    private const val NUMBER_SEPARATOR = ","

    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readInt()
    }

    fun getLottoNumbersOfLastWeek(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getLottoNumbers()
    }

    private fun getLottoNumbers(): LottoNumbers {
        runCatching {
            LottoNumbers(getNumbers())
        }.onSuccess {
            return it
        }
        println("다시 입력해 주세요.")
        return getLottoNumbers()
    }

    private fun getNumbers(): List<Int> {
        return readln()
            .split(NUMBER_SEPARATOR)
            .mapNotNull {
                it.trim()
                    .toIntOrNull()
            }
    }

    private tailrec fun readInt(): Int {
        val enteredInt = readln().toIntOrNull()
        if (enteredInt != null) return enteredInt
        println("다시 입력해 주세요.")
        return readInt()
    }
}
