package lotto.domain

class Lotto {
    private val lottoNumbers: List<LottoNumber>

    constructor(randomNumberGenerator: RandomNumberGenerator) {
        lottoNumbers = randomNumberGenerator
            .getRandomNumbers(LOTTO_NUMBER_RANGE, LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) }
    }

    constructor(numbers: List<LottoNumber>) {
        this.lottoNumbers = numbers
    }

    fun contains(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        if (lottoNumbers != other.lottoNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
    }

    fun toString(delimiter: String, prefix: String = "", postfix: String = ""): String {
        return lottoNumbers.joinToString(delimiter, prefix, postfix)
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
