package lotto.domain

import lotto.domain.dto.LottoMatchResult
import lotto.domain.dto.LottoNumber
import lotto.model.Rank

class LottoDraw(private val luckyDrawNumber: List<Int>, private val bonusNumber: Int) {

    init {
        require(luckyDrawNumber.count() == INSERT_LIMIT_NUMBER_COUNT) { "당첨번호는 6개만 입력해주세요" }
        luckyDrawNumber.forEach {
            require(LUCKY_DRAW_MAX_NUM > it) { "숫자는 45 이하만 입력 가능합니다." }
            require(LUCKY_DRAW_MIN_NUM <= it) { "숫자는 1 이상만 입력 가능합니다." }
        }
        require(!luckyDrawNumber.contains(bonusNumber)) { "보너스 번호가 당첨 번호에 이미 존재하는 번호입니다." }
        require(LUCKY_DRAW_MAX_NUM > bonusNumber) { "보너스 숫자는 45 이하만 입력 가능합니다." }
        require(LUCKY_DRAW_MIN_NUM <= bonusNumber) { "보너스 숫자는 1 이상만 입력 가능합니다." }
    }

    val winningRanks: List<Rank>
        get() = _winningRanks.toList()
    private var _winningRanks: MutableList<Rank> = mutableListOf()

    fun draw(lottoList: List<LottoNumber>) {
        lottoList.forEach {
            this.addDrawResult(getDrawResult(it))
        }
    }

    private fun getDrawResult(lottoNumber: LottoNumber): LottoMatchResult {
        val numbers = lottoNumber.numbers
        return LottoMatchResult(
            luckyDrawNumber.count { numbers.contains(it) },
            numbers.contains(bonusNumber)
        )
    }

    private fun addDrawResult(lottoMatchResult: LottoMatchResult) {
        this._winningRanks.add(Rank.of(lottoMatchResult))
    }

    companion object {
        private const val LUCKY_DRAW_MIN_NUM = 1
        private const val LUCKY_DRAW_MAX_NUM = 45
        private const val INSERT_LIMIT_NUMBER_COUNT = 6
    }
}
