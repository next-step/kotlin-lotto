package lotto

class WinningLotto(private val lotto: Lotto, private val bonusNo: LottoNumber) {
    constructor(lottoNos: String, bonusNo: Int):
            this(Lotto.ofComma(lottoNos), LottoNumber.of(bonusNo))

    fun match(lotto: Lotto): Rank {
        val matchCount = this.lotto.match(lotto)
        val matchBonus = lotto.contains(bonusNo)
        return Rank.rank(matchCount, matchBonus)
    }
}
