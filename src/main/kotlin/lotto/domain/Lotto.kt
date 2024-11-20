package lotto.domain

class Lotto(
    private val lottoNumbers: List<LottoNumber>,
) {

    init {
        require(lottoNumbers.size == 6) { "로또 번호는 6개여야 합니다." }
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(", ") { it.value.toString() }
    }

    fun match(winningLotto: Lotto): LottoRank {
        val matchNumberCount = lottoNumbers.count { it in winningLotto.lottoNumbers }
        return when (matchNumberCount) {
            6 -> LottoRank.FIRST
            5 -> LottoRank.SECOND
            4 -> LottoRank.THIRD
            3 -> LottoRank.FOURTH
            else -> LottoRank.NONE
        }
    }
}
