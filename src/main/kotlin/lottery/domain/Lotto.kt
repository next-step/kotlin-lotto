package lottery.domain

data class Lotto(
    val lottoNumber: List<Int>
) {
    fun getMatchResult(other: Lotto): List<Int> {
        return other.lottoNumber.intersect(this.lottoNumber.toSet()).toList()
    }
}
