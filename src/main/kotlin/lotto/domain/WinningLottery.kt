package lotto.domain

@JvmInline
value class WinningLottery(val lottery: Lottery) {

    companion object {
        fun of(numbers: List<Int>): WinningLottery {
            return numbers.map { LottoNumber.of(it) }
                .run { LottoNumbers.of(this) }
                .run { Lottery.of(this) }
                .run { WinningLottery(this) }
        }
    }
}
