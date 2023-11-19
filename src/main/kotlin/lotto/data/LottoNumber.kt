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
        private const val ERR_MSG_OUT_OF_LOTTO_RANGE = "로또의 범위를 넘어서는 번호입니다."

        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith(::LottoNumber)

        fun createLottoNumbers(numbers: List<Int>): Set<LottoNumber> {
            return LinkedHashSet(numbers.map(::from))
        }

        fun createRandomLottoNumber(lottoCreation: RandomLogicInterface): Set<LottoNumber> {
            return lottoCreation.createAutoLotto(NUMBERS)
        }

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException(ERR_MSG_OUT_OF_LOTTO_RANGE)
        }
    }
}
