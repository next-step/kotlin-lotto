package lotto.domain

import lotto.util.ErrorCode

object LottoGenerator {
    private val lottoNumbersRegex = """^[0-9,\s]*$""".toRegex()
    private const val SEPARATOR = ","
    fun generateLottoList(lottoCount: Long, numberGenerator: NumberGenerator): List<Lotto> =
        (1..lottoCount).map {
            Lotto(
                numberGenerator.generateLottoNumbers(
                    LottoNumber.possibleNumbers,
                    Lotto.LOTTO_NUMBER_COUNT
                ).toMutableSet()
            )
        }

    fun generateLotto(lottoNumbers: String): Lotto {
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
