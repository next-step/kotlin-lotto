package lotto.domain

class WinningLottoNumbers private constructor(
    val lotto: Lotto,
    val bonusLotto: LottoNumber
) {

    init {
        require(!lotto.contains(bonusLotto)) {
            "보너스 볼과 당첨번호는 중복될 수 없습니다."
        }
    }

    fun countWinningNumbers(lottoTicket: LottoTicket): Int {
        return lottoTicket.lotto.count(this.lotto)
    }

    companion object {

        fun of(stringWinningLottoNumbers: String, bonusNumber: Int): WinningLottoNumbers {
            val winningLottoNumberTokens = stringWinningLottoNumbers.trim().split(",").map { it.trim() }

            validate(winningLottoNumberTokens)

            val winningLottoInstance = Lotto.from(winningLottoNumberTokens.map { LottoNumber.from(it.toInt()) })
            val bonusLotto = LottoNumber.from(bonusNumber)
            return WinningLottoNumbers(lotto = winningLottoInstance, bonusLotto = bonusLotto)
        }

        private fun validate(tokens: List<String>) {
            require(tokens.groupBy { it }.all { it.value.size == 1 }) {
                "당첨 번호는 중복된 번호를 허용할 수 없습니다."
            }
        }
    }
}
