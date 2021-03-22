package lotto.domain

class LottoWonNumbers(private val lottoNumber: Set<LottoNumber>, private val bonusNumber: LottoNumber) {
    init {
        require(lottoNumber.size == Lotto.LOTTO_NUMBER_COUNT) { "당첨 로또 번호는 6개여야 합니다" }
        require(!lottoNumber.contains(bonusNumber)) { "당첨 로또 번호에는 보너스 당첨번호가 존재해서는 안됩니다." }
    }

    fun match(lottoCollection: LottoCollection): LottoRankCollection {
        val rankCount: Map<Rank, Int> = lottoCollection
            .map {
                match(it)
            }
            .groupingBy { it }
            .eachCount()

        return LottoRankCollection(rankCount)
    }

    fun match(lotto: Lotto): Rank {
        val wonNumberCount: Int = lotto.count { lottoNumber.contains(it) }
        val matchBonus: Boolean = lotto.contains(bonusNumber)

        return Rank.getRankByCount(wonNumberCount, matchBonus)
    }

    constructor(lottoNumber: Set<Int>, bonusNumber: Int) : this(
        lottoNumber.map(::LottoNumber).toSet(),
        LottoNumber(bonusNumber)
    )
}
