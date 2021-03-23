package lotto.domain

class Lotto(
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
        return this.numbers.count {
            lotto.numbers.contains(it)
        }
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6

        fun from(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers)
        }
    }
}
