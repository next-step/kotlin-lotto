package lotto.domain

class Lotto private constructor(
    val numbers: List<LottoNumber>,
    val auto: Boolean = false
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { "로또 번호는 6개여야 합니다." }
    }

    fun checkEqualCount(winningLotto: WinningLotto): Int {
        val otherNumbers = winningLotto.lotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    fun isCatchBonus(bonusNumber: LottoNumber): Boolean = numbers.contains(bonusNumber)

    companion object {
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6

        fun autoCreate(): Lotto {
            val lottoNumbers = LottoNumber.createRandomList(NUMBER_OF_LOTTO_NUMBERS)
            return Lotto(lottoNumbers, true)
        }

        fun manualCreate(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map {
                LottoNumber.create(it)
            }
            return Lotto(lottoNumbers)
        }
    }
}
