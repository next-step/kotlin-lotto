package lotto.data

import java.util.TreeSet

class LottoNumber private constructor(private val number: Int) : Comparable<LottoNumber> {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val SUB_LIST_START_POSITION = 0
        private const val LOTTO_NUMBER_LENGTH = 6
        private const val ERR_MSG_OUT_OF_LOTTO_RANGE = "로또의 범위를 넘어서는 번호입니다."
        private const val ERR_MSG_OUT_OF_LOTTO_LENGTH = "번호는 6개로 구성되어야 합니다."

        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith(::LottoNumber)

        fun createLottoNumbers(numbers: List<Int>): TreeSet<LottoNumber> {
            val lottoNumbers = TreeSet(numbers.map(::from))
            validateDuplication(lottoNumbers)

            return lottoNumbers
        }

        fun createRandomLotto(): TreeSet<LottoNumber> {
            val randomNumberList = (MIN_NUMBER..MAX_NUMBER).shuffled()
                .subList(SUB_LIST_START_POSITION, SUB_LIST_START_POSITION + LOTTO_NUMBER_LENGTH - 1)

            return createLottoNumbers(randomNumberList)
        }

        fun validateDuplication(lottoNumbers: TreeSet<LottoNumber>) {
            require(lottoNumbers.size == LOTTO_NUMBER_LENGTH) { ERR_MSG_OUT_OF_LOTTO_LENGTH }
        }

        private fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException(ERR_MSG_OUT_OF_LOTTO_RANGE)
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number.compareTo(other.number)
    }
}
