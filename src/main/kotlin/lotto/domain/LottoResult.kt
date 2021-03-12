package lotto.domain

class LottoResult {

    fun getMyLottoesRanks(lottoes: Lottoes, winningLotto: WinningLotto): LottoesRank {
        return lottoes.getMyLottoesRanks(winningLotto)
    }
}
