package lotto.model

class Lotto(private val lottoNumbers: List<LottoNumber>) {

    fun rank(winningLotto: Lotto, bonus: LottoNumber): Rank {
        return Rank.of(matchCount(winningLotto), matchBonus(bonus))
    }

    fun matchCount(winningLotto: Lotto): Int {
        return winningLotto.lottoNumbers.filter {
            lottoNumbers.contains(it)
        }.size
    }

    fun matchBonus(bonus: LottoNumber): Boolean {
        return lottoNumbers.contains(bonus)
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }
}
