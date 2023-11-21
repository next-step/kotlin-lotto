package lotto.domain

class WinningLotto(val lotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in lotto.numbers) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun match(lottoList: List<LottoNumber>): Pair<Int, Boolean> {
        return lottoList.count { it in lotto.numbers } to lottoList.contains(bonusNumber)
    }
}
