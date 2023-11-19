package lotto.domain

class Lottos(val lottos: List<Lotto>) {

    fun checkLottoWinning(jackpotNumbers: Lotto, bonusNumber: LottoNumber): List<JackpotLevel> {
        return lottos.map {
            val matchNumberCount = it.countMatchingNumbers(jackpotNumbers)
            val matchBonus = it.checkBonusNumberMatch(bonusNumber)
            JackpotLevel.findMatchingLevel(matchNumberCount, matchBonus)
        }
    }

    operator fun plus(other: Lottos): Lottos {
        val combinedLottos = this.lottos + other.lottos
        return Lottos(combinedLottos)
    }
}
