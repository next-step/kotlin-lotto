package lotto.domain

class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {

    init {
        require(!lotto.hasNumber(bonusNumber)) { "당첨번호 중에 보너스번호가 존재할 수 없습니다." }
    }

    constructor(lottoNumbers: List<Int>, bonusNumber: Int) : this(
        lotto = Lotto(lottoNumbers.map { LottoNumber(it) }),
        bonusNumber = LottoNumber(bonusNumber)
    )

    fun calculateLottoPrize(lotto: List<Lotto>): Map<LottoPrize, PositiveNumber> {
        val lottoPrizes = lotto.map(::calculateLottoPrize)
            .filter { it != LottoPrize.WHACK }
            .groupingBy { it }
            .eachCount()

        return lottoPrizes.mapValues { PositiveNumber(it.value) }
    }

    private fun calculateLottoPrize(lotto: Lotto): LottoPrize {
        val matchedCount = matchLottoNumberCount(lotto)
        val hasBonusNumber = lotto.hasNumber(bonusNumber)
        return LottoPrize.valueOf(matchedCount, hasBonusNumber)
    }

    private fun matchLottoNumberCount(targetLotto: Lotto): Int {
        return lotto.matchedNumberCount(targetLotto)
    }
}
