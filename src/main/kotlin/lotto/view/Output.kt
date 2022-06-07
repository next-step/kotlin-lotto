package lotto.view

import lotto.domain.Rank

object Output {
    fun result(resultRank: List<Rank>, rate: Double) {
        val groupBy = resultRank.groupBy { it }

        val status = Rank.values()
            .filter { it != Rank.FAIL }
            .map {
                val count = groupBy[it]?.size ?: 0

                "${it.matchCount}개 일치 (${it.prize}원) - ${count}개"
            }

        status.forEach {
            println(it)
        }
        println("총 수익률은 ${rate}입니다.")
    }
}
