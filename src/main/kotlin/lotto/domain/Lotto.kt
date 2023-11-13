package lotto.domain

class Lotto private constructor(
    private val lottoNumbers: Set<LottoNumber> = HashSet()
) {

    val lotto: Set<LottoNumber> = lottoNumbers

    fun makeMatchCountByNumbers(winningLotto: Lotto): Int {
        var count = 0
        winningLotto.lotto.forEach { winNumber ->
            count += countByMatchNumbers(winNumber)
        }
        return count
    }

    private fun countByMatchNumbers(winNumber: LottoNumber): Int {
        return lotto.count {
            it == winNumber
        }
    }

    companion object {

        private const val MAX_NUMBERS_COUNT = 6

        fun from(numbers: List<Int>): Lotto {

            require(numbers.size == MAX_NUMBERS_COUNT) {
                "로또를 올바르게 생성하려면 반드시 6개의 번호를 넣어주세요."
            }

            require(numbers.groupBy { it }.size == 6) {
                "중복된 숫자를 제외한 6개의 숫자를 입력해 주세요"
            }

            val lottoNumbers = numbers.map {
                LottoNumber.from(it)
            }.toSet()

            return Lotto(lottoNumbers)
        }
    }
}
