package lotto.domain

class LottoNumbers {
    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        private val numbers: List<LottoNumber> = init()

        private fun init(): List<LottoNumber> {
            return buildList {
                (LottoNumber.MINIMUM_VALUE..LottoNumber.MAXIMUM_VALUE).forEach {
                    add(LottoNumber.from(it))
                }
            }
        }

        fun getNumbers(): List<LottoNumber> {
            return numbers.shuffled().subList(0, LOTTO_NUMBER_COUNT).sorted()
        }
    }
}
