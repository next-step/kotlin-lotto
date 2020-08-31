package lotto.domain

data class WinningLotto(val prizeLotto: Lotto, val bonusNumber: LottoNumber) {
    fun getPrizeMoney(lotto: Lotto): Prize =
        Prize.getPrize(
            lotto.getCountOfMatchNumber(prizeLotto)
        )
}
