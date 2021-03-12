package lotto.domain

data class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {

    init {
        require(
            (bonusNumber in lotto).not()
        ) { "당첨 번호와 보너스 넘버는 중복될 수 없습니다. 당첨 번호: ${lotto.elements}, 보너스 넘버: $bonusNumber" }
    }

    fun match(other: Lotto) = Rank.of(lotto.matchCount(other), bonusNumber in other)
}
