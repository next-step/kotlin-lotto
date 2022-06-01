package lotto.domain

data class Lotto(
    val lottoNumbers: List<Int>
)

data class LottoTickets(
    val lottoCount: Int,
    val lottos: List<Lotto>
)
