package lotto.sixFortyFiveNumberLotto

fun List<SixFortyFiveLotto>.toLottoes() = SixFortyFiveLottoes(this)

@JvmInline
value class SixFortyFiveLottoes(private val list: List<SixFortyFiveLotto>) {
    fun getWinningResultEnumList(winningValue: SixFortyFiveWinningLotto): List<SixFortyFiveWinningEnum> {
        return list.map { lotto ->
            SixFortyFiveWinningEnum.valueOf(winningValue.matchCount(lotto.numbers))
        }
    }

    fun getCount(): SixFortyFiveLottoCount {
        return SixFortyFiveLottoCount(list.size)
    }

    fun getList(): List<SixFortyFiveLotto> {
        return list
    }
}
