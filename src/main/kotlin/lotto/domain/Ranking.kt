package lotto.domain

class Ranking(buyedLottoes: LottoNumbers, val winNumber: LottoNumber) {

    var threeCorrect = 0
        private set

    var fourCorrect = 0
        private set

    var fiveCorrect = 0
        private set

    var sixCorrect = 0
        private set

    var totalWinAmount: Int = 0
        private set
        get() =  Rank.THREE.winningMoney * threeCorrect + Rank.FOUR.winningMoney * fourCorrect + Rank.FIVE.winningMoney * fiveCorrect + Rank.SIX.winningMoney * sixCorrect

    init {
        buyedLottoes.lottoNumbers.forEach {
            setRanking(it)
        }
    }

    private fun setRanking(lottoNumber: LottoNumber) {
        when(Rank.valueOf(lottoNumber.lottoNumber.filter { it in winNumber.lottoNumber }.size)) {
            Rank.SIX -> sixCorrect++
            Rank.FIVE -> fiveCorrect++
            Rank.FOUR -> fourCorrect++
            Rank.THREE -> threeCorrect++
            else -> ""
        }
    }
}