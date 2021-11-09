package lotto.domain

class LottoGameList(private val gameList: MutableList<LottoGame> = mutableListOf()) {

    fun size() = gameList.size

    fun add(lottoGame: LottoGame) = gameList.add(lottoGame)

    fun addAll(lottoGameList: List<LottoGame>) = gameList.addAll(lottoGameList)

    fun addAll(lottoGameList: LottoGameList) = gameList.addAll(lottoGameList.getGames())

    fun getGames() = gameList.toList()
}
