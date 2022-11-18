package lotto.domain

class LottoNumbers {
    companion object {
        private val numbers: List<LottoNumber> = init()

        private fun init(): List<LottoNumber> {
            return buildList {
                (LottoNumber.MINIMUM_VALUE..LottoNumber.MAXIMUM_VALUE).forEach {
                    add(LottoNumber(it))
                }
            }
        }

        fun getNumbers(): List<LottoNumber> {
            return numbers.shuffled().subList(0, 6).sorted()
        }
    }
}
