package lotto.domain

class Lotto(
    val numbers: List<LottoNumber>
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { "로또 번호는 6개여야 합니다." }
    }

    fun checkEqualCount(anotherLotto: Lotto): Int {
        val otherNumbers = anotherLotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6

        fun autoCreate(): Lotto {
            val lottoNumbers = LottoNumber.create(NUMBER_OF_LOTTO_NUMBERS)
            return Lotto(lottoNumbers)
        }
    }
}
