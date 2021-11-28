package lotto.view

class ResultView {

    fun showLottoCount(count: Int) {
        println(LOTTO_COUNT_MSG.format(count))
    }

    companion object {
        private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
    }
}
