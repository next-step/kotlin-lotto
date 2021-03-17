package lotto.domain

class Lotto constructor(
    val numbers: List<LottoNumber>
) {

    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE) {
            "로또 번호는 6개여야 합니다."
        }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    fun count(lotto: Lotto): Int {
        return this.numbers.filter {
            lotto.numbers.contains(it)
        }.size
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6

        fun from(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers)
        }

        fun create(): Lotto {
            val lottoNumbers = (LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER).map {
                LottoNumber.from(it)
            }.shuffled().take(LOTTO_NUMBERS_SIZE)

            return Lotto(lottoNumbers)
        }
    }
}