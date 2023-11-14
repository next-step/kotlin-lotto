package lotto.domain

import lotto.enums.Rank

class Lotto(
    val lottoNumbers: Set<LottoNumber> = HashSet()
) {
    init {
        require(lottoNumbers.size == MAX_NUMBERS_COUNT) {
            "로또를 올바르게 생성하려면 반드시 6개의 번호를 넣어주세요."
        }

        require(lottoNumbers.groupBy { it }.size == 6) {
            "중복된 숫자를 제외한 6개의 숫자를 입력해 주세요"
        }
    }

    fun makeMatchCountByNumbers(lotto: Lotto): Int {
        return this.lottoNumbers.intersect(lotto.lottoNumbers)
            .count()
    }


    fun matchCounts(bundle: List<Lotto>): List<Int> {
        val counts = mutableListOf<Int>()
        bundle.forEach { lotto ->
            val countByNumbers = lotto.makeMatchCountByNumbers(this)//0~6개

            val rank = Rank.values().firstOrNull {
                it.matchCount == countByNumbers
            } ?: Rank.NONE_RANK

            counts.add(countByNumbers)
        }
        return counts
    }


    companion object {

        private const val MAX_NUMBERS_COUNT = 6

        fun from(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map {
                LottoNumber.from(it)
            }.toSet()

            return Lotto(lottoNumbers)
        }
    }
}
