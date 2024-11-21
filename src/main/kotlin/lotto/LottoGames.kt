package lotto

class LottoGames(private val lottoGames: List<LottoGame>) {
    init {
        require(lottoGames.isNotEmpty()) { "1개 이상의 로또 게임을 가지고 있어야 합니다." }
    }
}
