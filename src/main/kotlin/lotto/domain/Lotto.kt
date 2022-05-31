package lotto.domain

@JvmInline
value class Lotto(val lottoNumbers: List<LottoNumber>) {

    constructor(randomNumberGenerator: RandomNumberGenerator) :
        this(randomNumberGenerator.getRandomNumbers(LOTTO_NUMBER_RANGE, LOTTO_NUMBER_COUNT).map { LottoNumber(it) })

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) {
            "로또는 여섯개의 번호를 가져야 합니다."
        }
    }

    fun contains(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    fun countMatchedNumbers(other: Lotto): Int {
        return lottoNumbers.count { other.contains(it) }
    }

    fun toString(delimiter: String, prefix: String = "", postfix: String = ""): String {
        return lottoNumbers.joinToString(delimiter, prefix, postfix)
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
