package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(!lotto.contain(bonusNumber)) { BONUS_NUMBER_IN_LOTTO_ERROR_MESSAGE(bonusNumber) }
    }

    fun match(newLotto: Lotto): Rank {
        val matchCount = lotto.match(newLotto)
        val isBonus = newLotto.contain(bonusNumber)

        return Rank.of(matchCount, isBonus)
    }

    fun matchAll(lottoList: LottoList): LottoResult =
        lottoList.lottos
            .groupBy { this.match(it) }
            .mapValues { it.value.size }
            .let { LottoResult(it) }

    companion object {
        private val BONUS_NUMBER_IN_LOTTO_ERROR_MESSAGE =
            { bonusNumber: LottoNumber -> "보너스 번호 ${bonusNumber.number}는 당첨 번호에 포함되어 있습니다." }
    }
}
