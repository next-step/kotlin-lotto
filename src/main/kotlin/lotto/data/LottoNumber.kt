package lotto.data

import lotto.domain.RandomLogicInterface

class LottoNumber private constructor(private val number: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int {
        return this.number.compareTo(other.number)
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_NUMBER_LENGTH = 6
        private const val ERR_MSG_OUT_OF_LOTTO_RANGE = "로또의 범위를 넘어서는 번호입니다."
        private const val ERR_MSG_OUT_OF_LOTTO_LENGTH = "번호는 6개로 구성되어야 합니다."

        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith(::LottoNumber)

        fun createLottoNumbers(numbers: List<Int>): LinkedHashSet<LottoNumber> {
            val lottoNumbers = LinkedHashSet(numbers.map(::from))
            validateDuplication(lottoNumbers)

            return lottoNumbers
        }

        fun createRandomLotto(randomLogic: RandomLogicInterface): LinkedHashSet<LottoNumber> {
            return randomLogic.createRandomLotto(NUMBERS)
        }

        private fun validateDuplication(lottoNumbers: LinkedHashSet<LottoNumber>) {
            require(lottoNumbers.size == LOTTO_NUMBER_LENGTH) { ERR_MSG_OUT_OF_LOTTO_LENGTH }
        }

        private fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException(ERR_MSG_OUT_OF_LOTTO_RANGE)
        }
    }
}
