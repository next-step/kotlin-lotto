package lotto.domain

@JvmInline
value class WinningLottery(val lottery: Lottery) {

    companion object {
        fun of(numbers: List<Int>): WinningLottery {
            return numbers.map { LottoNumber.of(it) }
                .let { LottoNumbers.of(it) }
                .let { Lottery.of(it) }
                .let { WinningLottery(it) }
        }
    }
}
