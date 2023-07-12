package lotto.domain

data class LottoTicket(val typeLottos: List<TypeLotto>) {
    val countOfManualLotto: Int
        get() = typeLottos.count { it.type == GenerateType.MANUAL }
    val countOfAutoLotto: Int
        get() = typeLottos.count { it.type == GenerateType.AUTO }

    init {
        require(typeLottos.isNotEmpty()) { "로또는 1개 이상 구매해야 합니다." }
    }

    fun match(winningLotto: WinningLotto): MatchResult {
        return typeLottos.mapNotNull { winningLotto.match(it.lotto) }
            .run(::MatchResult)
    }
}
