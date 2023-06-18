package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.LottoWinningNumbers

object InputView {

    private const val NUMBER_SEPARATOR = ","

    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readInt()
    }

    tailrec fun getLottoWinningNumbers(): LottoWinningNumbers {
        runCatching {
            LottoWinningNumbers(
                getLottoNumbersOfLastWeek(),
                getBonusNumber()
            )
        }.onSuccess {
            return it
        }
        println("다시 입력해 주세요.")
        return getLottoWinningNumbers()
    }

    private fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return readInt()
    }

    private fun getLottoNumbersOfLastWeek(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getLottoNumbers()
    }

    private tailrec fun getLottoNumbers(): LottoNumbers {
        runCatching {
            LottoNumbers(getNumbers())
        }.onSuccess {
            return it
        }
        println("다시 입력해 주세요.")
        return getLottoNumbers()
    }

    private fun getNumbers(): Set<Int> {
        return readln()
            .split(NUMBER_SEPARATOR)
            .mapNotNull {
                it.trim()
                    .toIntOrNull()
            }.toSet()
    }

    private tailrec fun readInt(): Int {
        val enteredInt = readln().toIntOrNull()
        if (enteredInt != null) return enteredInt
        println("다시 입력해 주세요.")
        return readInt()
    }
}
