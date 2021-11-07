package lotto.domain

@JvmInline
value class BonusBall private constructor(val value: LottoNumber) {

    companion object {
        private fun verify(winning: WinningLottery, bonusBall: LottoNumber) {
            require(!winning.lottery.isContainBonusBall(LottoNumber.of(bonusBall.value))) { "보너스 볼은 당첨번호에 포함된 번호일 수 없습니다." }
        }

        fun of(winning: WinningLottery, bonusBall: LottoNumber): BonusBall {
            verify(winning, bonusBall)
            return BonusBall(LottoNumber.of(bonusBall.value))
        }
    }
}
