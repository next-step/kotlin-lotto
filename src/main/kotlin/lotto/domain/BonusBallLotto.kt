package lotto.domain

class BonusBallLotto(
    winLotto: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(bonusNumber !in winLotto.numbers) {
            "보너스 번호는 당첨 번호와 겹칠 수 없습니다."
        }
    }

    fun matches(lotto: Lotto): Boolean {
        return bonusNumber in lotto.numbers
    }

    companion object {
        fun read(winLotto: Lotto): BonusBallLotto {
            while (true) {
                try {
                    println("보너스 볼을 입력해 주세요.")
                    return BonusBallLotto(winLotto, LottoNumber(readln()))
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }
    }
}
