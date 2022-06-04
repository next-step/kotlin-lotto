package lotto.domain

@JvmInline
value class Lotto(private val lottoNumbers: List<LottoNumber>) {

    constructor(randomNumberGenerator: RandomNumberGenerator) :
        this(randomNumberGenerator.getRandomNumbers(LOTTO_NUMBER_RANGE, LOTTO_NUMBER_COUNT).map { LottoNumber(it) })

    constructor(vararg i: Int) :
        this(i.asList().map { LottoNumber(it) })

    init {
        require(lottoNumbers.distinct().size == LOTTO_NUMBER_COUNT) {
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
        const val LOTTO_PRICE = 1_000
        const val LOTTO_NUMBER_COUNT = 6
        val LOTTO_NUMBER_RANGE = 1..45
        val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()

        fun getAutoLotto(count: Int): List<Lotto> {
            return (1..count).map { Lotto(randomNumberGenerator) }
        }
    }
}
