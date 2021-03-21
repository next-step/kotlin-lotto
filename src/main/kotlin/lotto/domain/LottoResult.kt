package lotto.domain

class LottoResult(private val matchResult: List<Int>) {

    fun same(count: Int): Int {
        return matchResult.count { it == count }
    }
}
