package lotto.domain

class Winner(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!winningLotto.contains(bonusLottoNumber)) { "지난 주 당첨 번호를 제외한 숫자를 입력해주세요." }
    }

    fun match(lottoList: List<Lotto>): Rank {
        val rewards = lottoList
            .mapNotNull { lotto ->
                val matchCount = this.winningLotto.match(lotto, bonusLottoNumber).size
                val hasBonus = lotto.contains(bonusLottoNumber)

                Reward.from(matchCount = matchCount, hasBonus = hasBonus)
            }
            .groupingBy { it }
            .eachCount()

        return Rank(rewards)
    }
}
