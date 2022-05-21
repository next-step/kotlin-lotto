package lotto.domain

class LottoBuyer(
    private val money: Int,
    private val lottoSeller: LottoSeller = LottoSeller(),
    ownLottoBundle: LottoBundle? = null,
) {
    private lateinit var lottoBundle: LottoBundle

    init {
        if (ownLottoBundle != null) {
            lottoBundle = ownLottoBundle
        }
    }

    fun buyAll(): LottoBundle {
        lottoBundle = lottoSeller.sell(money)
        return lottoBundle.copy()
    }

    fun confirmWinning(winningNumber: WinningNumber): WinningResult {
        check(this::lottoBundle.isInitialized) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningNumber.toLotto())
        return WinningResult(winnings, money)
    }
}

data class WinningNumber(
    private val numbers: Set<Int>
) {
    init {
        require(numbers.size == Lotto.SIZE_OF_LOTTO_NUMBERS) {
            "당첨 번호는 중복되지 않은 6개의 숫자이어야 합니다"
        }
        require(numbers.all { it in LottoNumber.LOTTO_NUMBER_RANGE }) {
            "당첨 번호는 1 ~ 45 사이의 값만 가질 수 있습니다"
        }
    }

    fun toLotto(): Lotto {
        return Lotto.of(numbers)
    }
}

data class WinningResult(
    private val winnings: List<WinningPlace>,
    private val cost: Int
) {
    private val totalReword = winnings.fold(0) { reword, winning ->
        reword + winning.reward
    }
    val rateOfReturn = totalReword / cost.toDouble()

    private val groupByWinningPlace = winnings.groupBy({ it }, { it.reward })

    val first = groupByWinningPlace[WinningPlace.FIRST]?.size ?: 0
    val second = groupByWinningPlace[WinningPlace.SECOND]?.size ?: 0
    val third = groupByWinningPlace[WinningPlace.THIRD]?.size ?: 0
    val fourth = groupByWinningPlace[WinningPlace.FOURTH]?.size ?: 0
}
