package lotto.domain

data class LottoTicket(val lottos: List<Lotto>) {
    val countOfManualLotto: Int
        get() = lottos.count { it.type == GenerationType.MANUAL }
    val countOfAutoLotto: Int
        get() = lottos.count { it.type == GenerationType.AUTO }

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상 구매해야 합니다." }
    }

    fun match(winningLotto: WinningLotto): MatchResult {
        return lottos.mapNotNull { winningLotto.match(it.lottoNumbers) }
            .run(::MatchResult)
    }
}
