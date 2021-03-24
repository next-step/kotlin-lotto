package lotto.domain

import lotto.domain.generator.ManualLottoGenerator

class WinningLottoNumbers private constructor(
    val lotto: Lotto,
    val bonusLotto: LottoNumber
) {

    init {
        require(!lotto.contains(bonusLotto)) {
            "보너스 볼과 당첨번호는 중복될 수 없습니다."
        }
    }

    fun countWinningNumbers(lotto: Lotto): Int {
        return lotto.count(this.lotto)
    }

    companion object {

        fun of(lottoNumbers: String, bonusNumber: Int): WinningLottoNumbers {
            validate(LottoNumberTokenizer.tokenize(lottoNumbers))
            val lotto = ManualLottoGenerator(lottoNumbers).generate()

            val bonusLotto = LottoNumber.from(bonusNumber)
            return WinningLottoNumbers(lotto, bonusLotto)
        }

        private fun validate(tokens: List<Int>) {
            require(tokens.groupBy { it }.all { it.value.size == 1 }) {
                "당첨 번호는 중복된 번호를 허용할 수 없습니다."
            }
        }
    }
}
