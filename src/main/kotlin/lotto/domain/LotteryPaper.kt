package lotto.domain

class LotteryPaper(private val lottoNumberSelectPaper: LottoNumberSelectPaper) {
    private val lottoGameList = LottoGameList()

    init {
        lottoGameList.addAll(lottoNumberSelectPaper.getManualSelectedLottoGames())
        val numberOfAutoGenerateGames =
            with(lottoNumberSelectPaper) { budget.getNumberOfGames() - numberOfManualSelectGames.numberOfGames }

        repeat(numberOfAutoGenerateGames) { lottoGameList.add(LottoGame.createWithAutoSelect()) }
    }

    fun getLottoGameList() = lottoGameList

    fun getLottoBudget() = lottoNumberSelectPaper.budget

    fun getNumberOfGames() = lottoGameList.size()
}
