package lottery.domain

data class Lotto(
    val lottoNumber: List<Int>
) {
    fun getMatchResult(other: Lotto): Int {
        return other.lottoNumber.intersect(this.lottoNumber.toSet()).size
    }
}
