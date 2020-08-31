package lotto.domain

data class WinningLotto(val prizeLotto: Lotto, val bonusNumber: LottoNumber) {
    fun getPrizeMoney(lotto: Lotto): Prize =
        Prize.getPrize(lotto.getCountOfMatchNumber(prizeLotto))

    companion object {
        fun from(prizeNumbers: String, bonusNumberInput: String): WinningLottoResult {
            val prizeLotto = Lotto.from(prizeNumbers) ?: return WinningLottoResult.InvalidPrizeLotto
            if (!LOTTO_NUMBER_REGULAR_EXPRESSION.matches(bonusNumberInput)) return WinningLottoResult.InvalidBonusNumber
            val bonusNumber: LottoNumber = LottoNumber.from(bonusNumberInput)
            if (prizeLotto.isContainNumber(bonusNumber)) return WinningLottoResult.IsContainBonusNumber
            return WinningLottoResult.Success(prizeLotto, bonusNumber)
        }
    }
}
