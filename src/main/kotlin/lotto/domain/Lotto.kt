package lotto.domain

@JvmInline
value class Lotto(private val lotto: List<LottoNumber>) {
    val value: List<Int>
        get() = lotto.map { it.value }

    init {
        require(lotto.size == MAXIMUM_LOTTO_NUMBER_LENGTH) { "로또 번호는 6개의 숫자여야 합니다." }
        require(lotto.distinct().size == MAXIMUM_LOTTO_NUMBER_LENGTH) { "로또 번호는 중복될 수 없습니다." }
        require(lotto.sortedBy { it.value } == lotto) { "로또 번호는 오름차순으로 정렬되어야 합니다." }
    }

    fun getCountOfMatches(lotto: Lotto): Int {
        return this.lotto.count { lotto.contains(it) }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lotto.contains(lottoNumber)
    }

    companion object {
        const val MAXIMUM_LOTTO_NUMBER_LENGTH = 6
    }
}
