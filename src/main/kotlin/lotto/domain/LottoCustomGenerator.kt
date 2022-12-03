package lotto.domain

import lotto.util.ErrorCode

object LottoCustomGenerator : LottoGenerator {
    private val lottoNumbersRegex = """^[0-9,\s]*$""".toRegex()
    private const val SEPARATOR = ","
    private const val LOTTO_NUMBER_INIT = 0

    override fun generateLottoFromNumbers(): Lotto {
        val numberList =
            LottoNumber.possibleNumbers
                .shuffled()
                .subList(LOTTO_NUMBER_INIT, Lotto.LOTTO_NUMBER_COUNT)
                .sortedBy { it.number }
        return Lotto(numberList.toMutableSet())
    }

    override fun generateLotto(lottoNumbers: String): Lotto {
        val lottoNumberSet = validateLottoNumbers(lottoNumbers).toMutableSet()

        return Lotto(lottoNumberSet)
    }

    private fun validateLottoNumbers(number: String): List<LottoNumber> {
        require(number.matches(lottoNumbersRegex)) {
            ErrorCode.LOTTO_NUMBERS_INPUT_FORMAT_EXCEPTION.errorMessage
        }

        return number
            .split(SEPARATOR)
            .mapNotNull {
                it.trim()
                    .toIntOrNull()
            }.map { LottoNumber(it) }
    }
}
